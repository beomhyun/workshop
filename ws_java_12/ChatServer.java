package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class ChatServer {
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.go();
	}
	
	private ArrayList<ChatServerThread> list;
	private int port;
	ServerSocket ss;
	Socket s;
	public ChatServer() {
		list = new ArrayList<>();
		port = 5435;
	}
	private synchronized void addThread(ChatServerThread st) {
		System.out.println("hi");
		list.add(st);
	}
	public void go() {
		try {
			ss = new ServerSocket(port);
			while(true) {
				s=ss.accept();
				ChatServerThread st = new ChatServerThread(this,s);
				this.addThread(st);
				st.start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public synchronized void broadcast(String msg) {
		for (int i = 0; i < list.size(); i++) {
			ChatServerThread st1 = list.get(i);
			st1.sendMessage(msg);
		}
	}
	public synchronized void removeClient(ChatServerThread thread) {
		list.remove(thread);
	}
	
	
}
class ChatServerThread extends Thread {
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	ChatServer server;
	
	public ChatServerThread(ChatServer server, Socket s) throws IOException {
		this.server = server;
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		System.out.println(s.getInetAddress()+"가 들어옴");
	}
	public void sendMessage(String string) {
		pw.println(string);
	}
	public void run() {
		try {
			while((str = br.readLine())!= null) {
				server.broadcast(str);
			}
		} catch (IOException e) {
			System.out.println(s.getInetAddress()+"가 나감");
			server.removeClient(this);
			try {
				s.close();	//형식상 예외처리
			} catch (IOException e1) {
			}
		}
	}
}