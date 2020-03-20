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

		// ������
		// 1. �������� ����ؼ� Ŭ���̾�Ʈ ���Ӵ��
		// 2. Ŭ���̾�Ʈ�� �����ϸ�
		/// 2-1. Ŭ���̾�Ʈ�κ��� �޽����� �޽��ϴ� (�б�, Input)
		/// 2-2. �����޽����� Ŭ���̾�Ʈ���� �ٽ� ���� ( ����, Output)
		//
		
		
		try {
			System.out.println(">>> ���� ");
			System.out.println(">> ���� �����....");
			server = new ServerSocket(10001);
			socket = server.accept();
			
			System.out.println(">> Ŭ���̾�Ʈ ����\n");
			
			InputStream is =socket.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			String str = null;
			StringBuilder sbr = null;
			while(true) {
				str = br.readLine();
				sbr = new StringBuilder(str);
				
				System.out.println("[����] Ŭ���̾�Ʈ�κ��� �޽��� -����-: "+str);
				System.out.println();
				System.out.println("[����] Ŭ���̾�Ʈ���� �޽��� -����-: "+str);
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
			
			System.out.println("��������");
		}
		
	}
}
