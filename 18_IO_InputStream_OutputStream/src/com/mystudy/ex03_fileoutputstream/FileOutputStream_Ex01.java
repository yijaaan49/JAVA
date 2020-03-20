package com.mystudy.ex03_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex01 {

	public static void main(String[] args) {
		// FileOutputStream : byte ���� ���� ���� (���, ����)
		// - OutpotStream : �߻� Ŭ������ ��ӹ޾� (Ȯ���ؼ�extends) ������� Ŭ������ �ȴ�.
		
		//1. ��ü���� 
		File file = new File("file/test_out_01.txt");
		
		FileOutputStream fos = null;	
		try {
			//2. ��ü���� �۾�ó��
			fos = new FileOutputStream(file, true); //�߰� (apped) ���·� ���
			fos.write('H');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');
			fos.write('~');
			
			byte[] bytes = "Hello Java!!".getBytes();
			for(int i = 0 ; i < bytes.length ; i++) {
				fos.write(bytes[i]);
			}
			
			fos.write(bytes);
			//write(����Ʈ�迭, ������ġ, ��ġ)
			fos.write(bytes, 6, 6);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3. ��ü ����ó��
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		

	}

}
