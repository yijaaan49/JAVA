package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSeverEcho {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;

		// 서버측
		// 1. 서버소켓 사용해서 클라이언트 접속대기
		// 2. 클라이언트가 접속하면
		/// 2-1. 클라이언트로부터 메시지를 받습니다 (읽기, Input)
		/// 2-2. 받은메시지를 클라이언트에게 다시 전송 ( 쓰기, Output)
		//
		
		
		try {
			System.out.println(">>> 서버 ");
			System.out.println(">> 접속 대기중....");
			server = new ServerSocket(10001);
			socket = server.accept();
			
			System.out.println(">> 클라이언트 접속\n");
			
			InputStream is =socket.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			String str = null;
			StringBuilder sbr = null;
			while(true) {
				str = br.readLine();
				sbr = new StringBuilder(str);
				
				System.out.println("[서버] 클라이언트로부터 메시지 -수신-: "+str);
				System.out.println();
				System.out.println("[서버] 클라이언트에게 메시지 -전달-: "+str);
				sbr.append("\n");
				pw.write(sbr.toString());
				pw.flush();
				if(str.equals("exit"))break;
			}
			br.close();
			pw.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			System.out.println("서버종료");
		}
		
	}
}
