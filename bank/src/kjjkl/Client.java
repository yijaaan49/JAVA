package kjjkl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] arg)
    {
        Socket socket = null;            //Server�� ����ϱ� ���� Socket
        BufferedReader in = null;        //Server�κ��� �����͸� �о���̱� ���� �Է½�Ʈ��
        BufferedReader in2 = null;        //Ű����κ��� �о���̱� ���� �Է½�Ʈ��
        PrintWriter out = null;            //������ �������� ���� ��� ��Ʈ��
        InetAddress ia = null;
        try {
            ia = InetAddress.getByName("���� �ּ� �Է�");    //������ ����
            socket = new Socket(ia,10009);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in2 = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            
            System.out.println(socket.toString());
        }catch(IOException e) {}
        
        try {
            System.out.print("������ ���� �޼��� : ");
            String data = "asd";            //Ű����κ��� �Է�
            out.println(data);                        //������ ������ ����
            out.flush();

            String str2 = in.readLine();            //�����κ��� �ǵ��ƿ��� ������ �о����
            System.out.println("�����κ��� �ǵ��ƿ� �޼��� : " + str2);
            socket.close();
            
        }catch(IOException e) {}
    }
}