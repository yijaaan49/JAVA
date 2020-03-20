package com.mystudy.ex03_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex01 {

	public static void main(String[] args) {
		// FileOutputStream : byte 단위 파일 저장 (출력, 쓰기)
		// - OutpotStream : 추상 클래스를 상속받아 (확장해서extends) 만들어진 클래스가 된다.
		
		//1. 객체생성 
		File file = new File("file/test_out_01.txt");
		
		FileOutputStream fos = null;	
		try {
			//2. 객체생성 작업처리
			fos = new FileOutputStream(file, true); //추가 (apped) 형태로 출력
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
			//write(바이트배열, 시작위치, 위치)
			fos.write(bytes, 6, 6);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3. 객체 종료처리
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
