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
		/* 클라이언트측
		 * 1.소켓 사용해서 서버에 접속
		 * 2.서버에 접속하면
		 * 2-1 서버로 부터 메시지를 전송, (쓰기, output)
		 * 2-2 서버쪽에서 보내온 메시지 받기(읽기, input)
		 * 3. 받은 메시지 화면 출력
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
