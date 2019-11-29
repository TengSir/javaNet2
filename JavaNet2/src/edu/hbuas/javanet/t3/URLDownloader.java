package edu.hbuas.javanet.t3;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class URLDownloader extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					URLDownloader frame = new URLDownloader();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public URLDownloader() {
		setResizable(false);
		setTitle("\u7F51\u7EDC\u8D44\u6E90\u4E0B\u8F7D\u8F6F\u4EF6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 522, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		JTextArea textArea = new JTextArea();
		
		JButton btnNewButton = new JButton("解析资源");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url=textField.getText().trim().toString();
				try {
					URL  u=new URL(url);
					URLConnection  c=u.openConnection();
					long size=c.getContentLength();
					String type=c.getContentType();
					
					StringBuffer  s=new StringBuffer();
					s.append("URL地址："+url+"\r\n");
					s.append("资源类型："+type+"\r\n");
					s.append("资源大小："+size+"\r\n");
					textArea.setText(s.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(538, 9, 93, 23);
		contentPane.add(btnNewButton);
		
	
		textArea.setBorder(BorderFactory.createLineBorder(Color.black));
		textArea.setEditable(false);
		textArea.setBounds(10, 51, 522, 149);
		contentPane.add(textArea);
		
		JButton btnSaveAs = new JButton("下载资源");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArea.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "必须先解析资源！");
					return ;
				}
				JFileChooser  f=new JFileChooser();
				f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				f.showOpenDialog(URLDownloader.this);
				String path=f.getSelectedFile().getAbsolutePath().toString();
				URL u;
				try {
					u = new URL(textField.getText().trim().toString());
					URLConnection  c=u.openConnection();
					InputStream  in=c.getInputStream();
					FileOutputStream   out=new FileOutputStream(path+"/"+UUID.randomUUID()+"."+c.getContentType().substring(c.getContentType().lastIndexOf("/")+1,c.getContentType().length()));
					byte[] bs=new byte[1024*1024];
					int length=-1;
					while((length=in.read(bs))!=-1) {
						out.write(bs,0,length);
					}
					out.close();
					in.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSaveAs.setBounds(538, 51, 93, 23);
		contentPane.add(btnSaveAs);
	}
}
