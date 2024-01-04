package Login;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import List.ListFrame;
import Login.Repo.LoginRepo;

public class LoginFrame extends JFrame{
	LoginFrame() {
		 
		 setTitle("도서관리 시스템-로그인화면");
		 setSize(300, 200);
		 
		 JPanel p = new JPanel(new GridLayout(3, 0));
		 
		 JPanel p1 = new JPanel();
		 JLabel j1 = new JLabel("ID");
		 JTextField t1 = new JTextField(10);
		 p1.add(j1);
		 p1.add(t1);
		 
		 JPanel p2 = new JPanel();
		 JLabel j2 = new JLabel("PW");
		 JPasswordField t2 = new JPasswordField(10);
		 p2.add(j2);
		 p2.add(t2);
		 
		 JPanel p3 = new JPanel();
		 JButton b1 = new JButton("로그인");
		 //로그인 처리(id= admin pw : 1234
		 b1.addActionListener(e -> {
			 LoginRepo repo = new LoginRepo();
			 String id = t1.getText();
			 String password = t2.getText();
			 
			 boolean result = repo.login(id, password);
			 if(result) {
				 JOptionPane.showMessageDialog(null, "관리자님 환영합니다.");
				 setVisible(false); //로그인 시 창 이동
				 new ListFrame();
			 } else {
				 JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 틀립니다.");
			 }
		 });
        p3.add(b1);
	
		p.add(p1);
		p.add(p2);
		p.add(p3);

		 add(p);
		 
		 
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(3);
		 setVisible(true);
		 
	 
	 }
	 
	public static void main(String[] args) {
		new LoginFrame();
		
	}
}