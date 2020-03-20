package com.mystudy.net_multi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientEcho {
	public static void main(String[] args) {
	
		

		// 클라이언트측
		// 1. 소켓 사용해서 클라이언트 접속대기
		// 2. 서버에 접속하면
		/// 2-1. 서버쪽으로 메시지를 전송 ( 쓰기, Output)
		/// 2-2. 서버쪽에서 보내온 메시지 받기 (읽기, Input)
		// 3. 받은 메시지 화면 출력
	
			
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		try {
			
			System.out.println("현재 컴퓨터IP : "+InetAddress.getLocalHost());
			System.out.println(">> 서버 접속");
			
			socket = new Socket(InetAddress.getLocalHost(),10000);
			
			
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			OutputStream os =socket.getOutputStream();
			PrintWriter pw =new PrintWriter(os);
			InputStream is =socket.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			
			String ddddd =null; 
			while (true) {
				ddddd = scan.nextLine();
				dout.writeUTF(ddddd);
				//pw.flush(); //버퍼에 있는 내용을 강제로 출력(전송)
				dout.flush();
				System.out.println("[클라] 전송완료!\n");
				if("exit".equalsIgnoreCase(ddddd))break;
			}
			
			//5.자원 반납
			pw.close();
			br.close();
				
				
		} catch (IOException e) {
			e.printStackTrace();
				
		} finally {
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> 클라이언트 종료");
		scan.close();
	}
}