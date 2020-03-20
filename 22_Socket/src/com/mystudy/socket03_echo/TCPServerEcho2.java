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
		/* ������
		 * 1.�������� ����ؼ� Ŭ���̾�Ʈ ���� ���
		 * 2.Ŭ���̾�Ʈ�� �����ϸ�
		 * 2-1 Ŭ���̾�Ʈ�� ���� �޽����� �ް�, (�б�, Input)
		 * �����޽��� ȭ�����
		 * 2-2 ���� �޽����� Ŭ���̾�Ʈ���� �ٽ� ���� (����, Output)
		 * 3. Ŭ���̾�Ʈ���� ���� �޽��� ȭ�� ���
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
			System.out.println("Ŭ��ο� �޽���" + data.toString());
			
			
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
