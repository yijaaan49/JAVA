package com.mystudy.ex04_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_Test {
	public static void main(String[] args) {
		//파일복사 : 원본파일에서 읽고(input) 대상파일에 쓰기(Output)
		
		//복사할 원본 파일(source file : AS-IS)
//		File fileIn = new File("바이트_InputStream.png");
		File fileIn = new File("src\\com\\mystudy\\ex04_filecopy\\FileCopy_Test.java");
		//쓰기위한 대상파일(target file : TO-BE)
//		File fileOut = new File("file\\바이트_InputStream_backup.png");
		File fileOut = new File("file\\FileCopy_Test_backup.java");
		//파일에서 읽고 쓰기위한 객체를 저장하기위한 변수 선언
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//파일에서 읽고 쓰기위한 객체를 생성
			fis = new FileInputStream(fileIn);
			fos = new FileOutputStream(fileOut);
			
			//2. 객체 사용해서 작업처리
			int value = -1;
			
			while(true) {
				value = fis.read(); // 1byte 읽기
				if(value == -1) break; // EOF(End Of File) 파일의 끝이면 반복종료
				fos.write(value);//1byte 쓰기
			}
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
