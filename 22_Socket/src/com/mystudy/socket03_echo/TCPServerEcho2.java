package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEcho2 {
	public static void main(String[] args) {
		/* 서버측
		 * 1.서버소켓 사용해서 클라이언트 접속 대기
		 * 2.클라이언트가 접속하면
		 * 2-1 클라이언트로 부터 메시지를 받고, (읽기, Input)
		 * 받은메시지 화면출력
		 * 2-2 받은 메시지를 클라이언트에게 다시 전송 (쓰기, Output)
		 * 3. 클라이언트에게 보낸 메시지 화면 출력
		 */
		
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10015);
			Socket socket = serverSocket.accept();
			InputStream ips = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream ops = socket.getOutputStream();
			OutputStreamWriter or = new OutputStreamWriter(ops);
			BufferedWriter bw = new BufferedWriter(or);
			
			String data = null;
			data = br.readLine();
			System.out.println("클라로온 메시지" + data.toString());
			
			
			//------------------------
			

			String dd = "ljkafdfjldka";
			bw.write(dd);
			bw.flush();
			
			
			bw.close();
			br.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
