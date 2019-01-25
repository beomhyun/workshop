package com.ssafy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatClient extends JFrame {
	private TextArea ta;
	private JTextField tf;
	private JButton b1;
	private JButton b2;
	private JPanel p;
	private static ChatConnect cc;
	public ChatClient() {
		super();
	}
	public static void main(String[] args) {
		ChatClient cl = new ChatClient();
		cl.createGUI();
		String ip ="192.168.208.63";
		int port = 5435;
		String name ="beom";
		cc = new ChatConnect(cl,ip,port,name);
		cc.go();
	}
	public void createGUI() {
		ta = new TextArea(25,30);
		tf = new JTextField(50);
		b1 = new JButton("SEND");
		b2 = new JButton("EXIT");
		p = new JPanel();
		
		tf.addActionListener(new ChattingListener());
		b1.addActionListener(new ChattingListener());
		b2.addActionListener(new ChattingListener());
		ta.setEditable(false);
		ta.setBackground(Color.PINK);
		
		//패널에 버튼 추가
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(b1);
		p.add(b2);
		//패널 ta tf 를 프레임에 추가
		add(p,BorderLayout.LINE_END);
		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		setSize(400,500);		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void show(String msg) {
		ta.append(msg+"\n");
	}

	//frame의 멤버인 ta나 tf 에 접근하려면 내부 클래스로 작성하는게 용이함.
	class ChattingListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//tf에서 엔터키를 누르거나 send 버튼을 클릭하는 이벤트가 발생했을 때 이 메소드가 실행되게 합시다.
			if(e.getSource() == b2) {
				System.exit(0);
			}
			String input_msg = tf.getText();
			//ta.append(input_msg+"\n");
			tf.setText("");
//			System.out.println(input_msg);
			cc.send((String)input_msg);
		}
	}
}
