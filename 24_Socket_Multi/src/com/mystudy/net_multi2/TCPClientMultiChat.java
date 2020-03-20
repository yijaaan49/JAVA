package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//메시지 작성 전송 독립적으로 동작하는 쓰레드 생성
//메시지 수신 독립적으로 동작하는 쓰레드 생성
public class TCPClientMultiChat {
	static boolean temp = true;
	public static void main(String[] args) {
		//송신, 수신 쓰레드 생성하고 실행
		System.out.println("--- main() 시작 ----");
		Scanner scan = new Scanner(System.in);
		System.out.println("사용할 이름(별명)입력");
		String name = scan.nextLine();
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.0.45", 10000);
			//메시지 보내기 쓰레드 생성 실행(쓰레드로 동작)
			ClientSender clientSender = new ClientSender(name, socket);
			clientSender.start();
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientReceiver.start();
			//메시지 받기 쓰레드 생성 실행(쓰레드로 동작)
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("--- main() 종료 ----");
		scan.close();
	}
	
	//메시지 보내기 쓰레드
	static class ClientSender extends Thread{
		Socket socket;
		String name;
		DataOutputStream out;
		
		ClientSender(String name, Socket socket){
			this.name = name;
			this.socket = socket;
			
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				System.out.println("[예외밸생] ClientSender 생성자 "
						+ "out 객체 생성 실패");
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			//메시지 작성하고 작성된 메시지를 서버로 전송
			Scanner sc = new Scanner(System.in);
			if(out == null) {
				System.out.println("[예외발생]객체가 null 입니다.");
				return;
			}
			try {
				out.writeUTF(name);//첫번째 메시지 전송 : 이름(별명/아이디)
				while(temp) {
					System.out.print("메시지 작성 >>");
					String msg = sc.nextLine();
					//if("exit".equalsIgnoreCase(msg))break;
					//서버로 출력 : [홍길동] 안녕하세요
					if("exit".equals(msg)) temp = false;
					out.writeUTF("["+name+"]"+msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			super.run();
		}
	}
	//메시지 받기 쓰레드
	static class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		ClientReceiver(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
		
			//메시지를 받아서 화면에 출력 (반복)
			
			
			while(temp) {
				try {
				String msg = in.readUTF();
				System.out.println(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			
		}
	}

}
