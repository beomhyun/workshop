package com.ssafy.edu.j7;

import java.net.*;
import java.io.*;

public class Client {
	Socket s;
	BufferedReader br, br1;
	PrintWriter pw;
	String str;
	public void go(){
		try{
			s = new Socket("192.168.208.40",5433);
			br = new BufferedReader(new InputStreamReader(System.in));	//Input
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);	//OUTPUT

			ClientThread ct = new ClientThread(s);
			ct.start();	//다른 클라이언트에서 서버에 보낸 메시지를 서버를 통해 받기 위해 쓰레드로 처리.

			while ( ( str = br.readLine() ) != null ){
				pw.println(str);	//서버에 출력
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String [] args){
		System.out.println("Client");
		Client c = new Client();
		c.go();
	}
}

class ClientThread extends Thread{
	Socket s;
	BufferedReader br1;		
	String str;
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));	//출력하기 위해 인풋을 받음
	}
	public void run(){
		try{
			while ( ( str = br1.readLine() ) != null){
				System.out.println(str);	//서버로부터 받은 메시지 출력
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
}
	
