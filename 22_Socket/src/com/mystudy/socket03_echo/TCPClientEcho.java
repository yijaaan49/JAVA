package com.mystudy.socket03_echo;

import java.io.BufferedReader;
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
	
		

		// Ŭ���̾�Ʈ��
		// 1. ���� ����ؼ� Ŭ���̾�Ʈ ���Ӵ��
		// 2. ������ �����ϸ�
		/// 2-1. ���������� �޽����� ���� ( ����, Output)
		/// 2-2. �����ʿ��� ������ �޽��� �ޱ� (�б�, Input)
		// 3. ���� �޽��� ȭ�� ���
	
			
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		try {
			
			System.out.println("���� ��ǻ��IP : "+InetAddress.getLocalHost());
			System.out.println(">> ���� ����");
			
			socket = new Socket(InetAddress.getLocalHost(),10000);
			
			
			
			OutputStream os =socket.getOutputStream();
			PrintWriter pw =new PrintWriter(os);
			InputStream is =socket.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			
			String ddddd =null; 
			while (true) {
				ddddd = scan.nextLine();
				
				pw.println(ddddd);
				pw.flush(); //���ۿ� �ִ� ������ ������ ���(����)
				
				System.out.println("[Ŭ��] ���ۿϷ�!\n");
				if("exit".equalsIgnoreCase(ddddd))break;
			}
			
			//5.�ڿ� �ݳ�
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
		System.out.println(">>> Ŭ���̾�Ʈ ����");
		scan.close();
	}
}