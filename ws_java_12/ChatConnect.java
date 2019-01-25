package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//채팅할때 소켓 연결과 관련된 작업을 수행하는 클래스
public class ChatConnect {
	private String ip;
	private int port;
	private String name="범현";	//대화명 기능
	private Socket s;
	private BufferedReader br;
	private PrintWriter pw;
	String str;

	private ChatClient cl;
	
	public ChatConnect(ChatClient cl, String ip, int port, String name) {
		this.cl =cl;
		this.ip = ip;
		this.port = port;
		this.name = name;
	}

	public void go(){
		try{
			s = new Socket(ip,port);
			br = new BufferedReader(new InputStreamReader(System.in));	//Input
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);	//OUTPUT

			ClientThread ct = new ClientThread(s);
			ct.start();	//다른 클라이언트에서 서버에 보낸 메시지를 서버를 통해 받기 위해 쓰레드로 처리.

			while ( ( str = br.readLine() ) != null ){
				send(str);
				//pw.println(str);	//서버에 출력
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void send(String input_msg) {
		String str = name +" : "+input_msg;
		pw.println(str);
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
					cl.show(str);
					//System.out.println(str);	//서버로부터 받은 메시지 출력
				}
			}catch (IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
}
