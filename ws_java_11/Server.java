package com.ssafy.edu.j7;

import java.net.*;
import java.io.*;
import java.util.Vector;

public class Server{
	ServerSocket ss;
	Socket s;
	Vector<ServerThread> v;
	public Server(){
		v = new Vector<>(10,10);	//10개가 다 차면 10개씩 추가 디폴트는 2배
	}
	public synchronized void addThread(ServerThread st){
		v.add(st);
	}
	public synchronized void removeThread(ServerThread st){
		v.remove(st);
	}
	public synchronized void broadcast(String str){	//동기화 하지 않으면 안된다 !
		for ( int i = 0 ; i < v.size() ; i++ ){
			ServerThread st1 = (ServerThread)v.elementAt(i);
			st1.sendMessage(str);	//각각의 클라이언트에게 메시지 전송
		}
	}
	public void go(){
		try{
			ss = new ServerSocket(5432);
			while ( true ){
				s = ss.accept();	//accept !!!
				ServerThread st = new ServerThread(this, s);	//클라이언트 한명이 접속할때마다 새로운 쓰레드
				this.addThread(st);	//방(v)에 새로운 클라이언드 붙이기
				st.start();	//클라이언트 연결   run()은 직접 다 처리해야함 start()는 아줌마가 다 처리해줌
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String [] args) throws IOException{
		Server server = new Server();
		server.go();
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	Server server;

	public ServerThread(Server server,Socket s) throws IOException {
		this.server = server;
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));		//클라이언트의 입력을 받을  INPUT
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);	//모든 클라이언트들에게 출력해줄  OUTPUT
		System.out.println(s.getInetAddress()+"가 붙음");	//클라이언트 연결
	}
	public void sendMessage(String string){
		pw.println(string);	//클라이언트에게 보낼 OUTPUT
	}
	public void run(){
		try{
			while ( ( str = br.readLine() ) != null ){
				server.broadcast(str);	//입력이 있으면  broadcast 메서드를 호출하여 모든 클라이언트에게 출력
			}
		}catch (IOException e){
			//클라이언트가 나가거나 접속이 끊어졌을때 안정적으로 처리
			System.out.println(s.getInetAddress()+"가 나감.");		
			server.removeThread(this);
			try{//형식상 예외처리.(헬멧쓰기)
				s.close();
			}catch (IOException ie){ }
		}
	}
}
