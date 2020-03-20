package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEcho2 {
	public static void main(String[] arge) {
		/* Ŭ���̾�Ʈ��
		 * 1.���� ����ؼ� ������ ����
		 * 2.������ �����ϸ�
		 * 2-1 ������ ���� �޽����� ����, (����, output)
		 * 2-2 �����ʿ��� ������ �޽��� �ޱ�(�б�, input)
		 * 3. ���� �޽��� ȭ�� ���
		 */
		
		Socket socket = null;
		
		try {
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			
			OutputStream ops = socket.getOutputStream();
			OutputStreamWriter or = new OutputStreamWriter(ops);
			BufferedWriter bw = new BufferedWriter(or);
			
			InputStream ips = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ir);
			
			String dd = "ljkafdfjldka";
			bw.write(dd);
			bw.flush();
			
			//------------------------
			
			
			String data = br.readLine();
			System.out.println(data.toString());

			bw.close();
			br.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
