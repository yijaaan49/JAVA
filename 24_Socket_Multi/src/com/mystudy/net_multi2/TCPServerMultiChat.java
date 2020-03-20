package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class TCPServerMultiChat {
	HashMap<String, DataOutputStream> clients; //������ ��� output  ���� ��������
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPServerMultiChat().serverStart();
	}
	TCPServerMultiChat(){
		clients = new HashMap<>();
	}
	//���� ���� �����ϰ� ����ϴٰ�
	//Ŭ���̾�Ʈ�� �����ϸ� �޽�����
	//�ޱ����� �����带 ����(�޽����� �а� ��ü���� ����
	private void serverStart() {
		ServerSocket serverS = null;
		Socket socket = null;
		try {
			serverS = new ServerSocket(10000);
			System.out.println("���� ���� " + InetAddress.getLocalHost().getHostAddress() + 
					" : " + serverS.getLocalPort());
			while(true) {
				socket = serverS.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort());
				//���ӵ� Ŭ���̾�Ʈ�� ���� ó��
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in; // �޽����� ���� �� ���
		DataOutputStream out; // �ʵ忡 clients �� ��Ͻ� ���
		String ip;
		String name;
		
		ServerReceiver(Socket socket){
			super();
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				ip = socket.getInetAddress().getHostAddress();
			} catch (IOException e) {e.printStackTrace();}
		}
		@Override
		public void run() {
			super.run();
			//�����ɶ� clients�� �߰�, �����Ҷ� clients���� ����
			//�޽����� �ް�, ���ӵ� ��� ������� �޽��� ����
			
			
			try {
				//Ŭ���̾�Ʈ�� ���� ���� ù �޽��� : �̸� (����/���̵�)
				name = in.readUTF();
				System.out.println("������>>" + name);
				
				//��ü���� ������ ��� �˸�
				sendToAll("#" +  name + "���� �����Ͽ����ϴ�.");
				
				//������ ������ ���(clients) �� ���
				clients.put(name, out);
				
				while(true) {
					String msg = in.readUTF();
					if(msg == null || "exit".equalsIgnoreCase(msg))break;
					System.out.println(name + ">> " + msg);// ������ ȭ�鿡 ��� ������
					
					sendToAll(msg); //������ �������� �޽��� ������
				}
				
			} catch (IOException e) {
				
			}finally {
				//Ŭ���̾�Ʈ�� ���� ����� ó��
				//�����clients���� ����
				clients.remove(name);
				String outMsg = "<" + name + "> ���� �������ϴ�.";
				sendToAll(outMsg);
				System.out.println(outMsg);
			}
		}
		private void sendToAll(String msg) {
			// ������ ��ü���� �޽��� ����.
			Iterator<String> ite = clients.keySet().iterator();
			while(ite.hasNext()) {
				String key = ite.next();
				DataOutputStream out = clients.get(key);
				try {
					out.writeUTF(msg);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		//ServerReceiver ���޹��� socket �� �ӿ��ؼ� �޽����� �ް� ��ü���� ����
		//�����ɶ� : �ʵ� Ŭ�� �߰�
		//����ɶ� : �õ� Ŭ�� ����
	}
}



