package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//�޽��� �ۼ� ���� ���������� �����ϴ� ������ ����
//�޽��� ���� ���������� �����ϴ� ������ ����
public class TCPClientMultiChat {
	static boolean temp = true;
	public static void main(String[] args) {
		//�۽�, ���� ������ �����ϰ� ����
		System.out.println("--- main() ���� ----");
		Scanner scan = new Scanner(System.in);
		System.out.println("����� �̸�(����)�Է�");
		String name = scan.nextLine();
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.0.45", 10000);
			//�޽��� ������ ������ ���� ����(������� ����)
			ClientSender clientSender = new ClientSender(name, socket);
			clientSender.start();
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientReceiver.start();
			//�޽��� �ޱ� ������ ���� ����(������� ����)
			
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
		
		System.out.println("--- main() ���� ----");
		scan.close();
	}
	
	//�޽��� ������ ������
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
				System.out.println("[���ܹ��] ClientSender ������ "
						+ "out ��ü ���� ����");
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			//�޽��� �ۼ��ϰ� �ۼ��� �޽����� ������ ����
			Scanner sc = new Scanner(System.in);
			if(out == null) {
				System.out.println("[���ܹ߻�]��ü�� null �Դϴ�.");
				return;
			}
			try {
				out.writeUTF(name);//ù��° �޽��� ���� : �̸�(����/���̵�)
				while(temp) {
					System.out.print("�޽��� �ۼ� >>");
					String msg = sc.nextLine();
					//if("exit".equalsIgnoreCase(msg))break;
					//������ ��� : [ȫ�浿] �ȳ��ϼ���
					if("exit".equals(msg)) temp = false;
					out.writeUTF("["+name+"]"+msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			super.run();
		}
	}
	//�޽��� �ޱ� ������
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
		
			//�޽����� �޾Ƽ� ȭ�鿡 ��� (�ݺ�)
			
			
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
