package edu.hbuas.javanet.t4.chat;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	JPanel p;
	JScrollPane sp;
	JTextArea txtContent;
	JLabel lblName,lblSend;
	JTextField txtName,txtSend;
	JButton btnSend;

	public ChatClient() {
		super("�ͻ�����");
		txtContent = new JTextArea();
		// �����ı���ֻ��
		txtContent.setEditable(false);
		sp = new JScrollPane(txtContent);

		lblName=new JLabel("������");
		txtName=new JTextField(5);
		lblSend = new JLabel("�����룺");
		txtSend = new JTextField(20);
		btnSend = new JButton("����");

		p = new JPanel();
		p.add(lblName);
		p.add(txtName);
		p.add(lblSend);
		p.add(txtSend);
		p.add(btnSend);
		this.add(p, BorderLayout.SOUTH);

		this.add(sp);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			// ����һ���׽���
			socket = new Socket("127.0.0.1", 8888);
			// ����һ�����׽�����д���ݵĹܵ��������������������������Ϣ
			out = new PrintWriter(socket.getOutputStream());
			// ����һ�����׽����ض����ݵĹܵ����������������������ķ�����Ϣ
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ע�����
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�û�������ı�
				String strName=txtName.getText();
				String strMsg = txtSend.getText();
				if (!strMsg.equals("")) {
					// ͨ������������ݷ��͸�������
					out.println(strName+" ˵��"+strMsg);
					out.flush();
					// ����ı���
					txtSend.setText("");
				}
			}
		});
		// �����߳�
		new GetMsgFromServer().start();
	}

	// ���շ������ķ�����Ϣ
	class GetMsgFromServer extends Thread {
		public void run() {
			while (this.isAlive()) {
				try {
					String strMsg = in.readLine();
					if (strMsg != null) {
						// ���ı�������ʾ������Ϣ
						txtContent.append(strMsg+"\n");
					}
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		ChatClient f = new ChatClient();
		f.setVisible(true);
	}
}
