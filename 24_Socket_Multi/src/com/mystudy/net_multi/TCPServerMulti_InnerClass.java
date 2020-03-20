package com.mystudy.net_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMulti_InnerClass {
	public static void main(String[] args) {
		System.out.println("���ν���");
		new TCPServerMulti_InnerClass();
		System.out.println("��������");
	}
	TCPServerMulti_InnerClass() {
		serverStart();
	}
	private void serverStart() {
		ServerSocket server = null;
		System.out.println("���� ���� ����");
		try{
			server = new ServerSocket(10000);
			while(true) {
				System.out.println("���� ���");
				Socket socket = server.accept();
				System.out.println("Ŭ���̾�Ʈ ���ӿϷ�");
				System.out.println("Ŭ���̾�Ʈ ����" + socket.getInetAddress());
				//�������� ����ؼ� ����� ó��
				SocketThread thr = new SocketThread(socket);
				thr.start();
				System.out.println(">> ������" + socket.getInetAddress() + "����");
			}
		}catch(IOException e) {
			
		}
	}
	//���� Ŭ���� : ����(Socket) �� ���޹޾� ������ �����ϴ� Ŭ����
	
	
}
class SocketThread extends Thread {
	Socket socket;
	SocketThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		System.out.println("-----������ ����-------" + socket.getInetAddress());
		InputStream is = null;
		OutputStream os = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			System.out.println("�б� ����");
			while(true) {
				String msg = br.readLine();
				if (msg == null || "exit".equalsIgnoreCase(msg)) break;
				System.out.println(">>" + msg);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(">>Ŭ���̾�Ʈ ����");
			try {
				if (br != null) br.close();
				if (os != null) os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-----������ ����-------");
	}
}
