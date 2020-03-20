package com.mystudy.jdbc_crud;

public class AASFD {
	public static void main(String[] args) {
		String[][] st = new String[4][6];
		int num = 0;
		for(int i = 0 ; i< st.length; i++)
		{
			for(int j = 0 ; j < st[i].length; j++)
			{
				num++;
				st[1][j] = Integer.toString(num);
			}
		}
		for(int i = 0 ; i < st[0].length + 1 ; i++)
			System.out.print(i + "\t");
		System.out.println();
		userPc(st);

	}
	static public void userPc(String[][] st) {
		for(int i = 0 ; i< st.length; i++)
		{
			System.out.print((char)(i + 65) + "\t");
			for(int j = 0 ; j < st[i].length; j++)
			{		
				System.out.print((st[i][j] == null ? "□가능" : "■불가") + "\t");
			}
			System.out.println();
		}
	}
}