package com.mystudy.ex04_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_Test {
	public static void main(String[] args) {
		//���Ϻ��� : �������Ͽ��� �а�(input) ������Ͽ� ����(Output)
		
		//������ ���� ����(source file : AS-IS)
//		File fileIn = new File("����Ʈ_InputStream.png");
		File fileIn = new File("src\\com\\mystudy\\ex04_filecopy\\FileCopy_Test.java");
		//�������� �������(target file : TO-BE)
//		File fileOut = new File("file\\����Ʈ_InputStream_backup.png");
		File fileOut = new File("file\\FileCopy_Test_backup.java");
		//���Ͽ��� �а� �������� ��ü�� �����ϱ����� ���� ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//���Ͽ��� �а� �������� ��ü�� ����
			fis = new FileInputStream(fileIn);
			fos = new FileOutputStream(fileOut);
			
			//2. ��ü ����ؼ� �۾�ó��
			int value = -1;
			
			while(true) {
				value = fis.read(); // 1byte �б�
				if(value == -1) break; // EOF(End Of File) ������ ���̸� �ݺ�����
				fos.write(value);//1byte ����
			}
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
