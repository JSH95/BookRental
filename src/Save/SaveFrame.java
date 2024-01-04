package Save;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import List.ListFrame;
import Save.Repo.SaveRepo;
import sun.net.www.content.image.jpeg;

public class SaveFrame  extends JFrame{
	
	JButton b1 = new JButton("일람으로");
	JButton b2 = new JButton("초기화");
	JButton b3 = new JButton("등록");
	
	public SaveFrame() {
		setTitle("도서관리 시스템 - 등록화면");
		setSize(400, 300);
	
		setPanel();
			
		setLocationRelativeTo(null);
		setVisible(true);
		
}
	
	
	private void setPanel() {
		JPanel p = new JPanel(new GridLayout(0,3));
		JLabel l1 = new JLabel("책제목");
		JLabel l2 = new JLabel("카테고리");
		JLabel l3 = new JLabel("저자");
		JLabel l4 = new JLabel("출판사");
		JLabel l5 = new JLabel("책가격");
		JLabel l6 = new JLabel("책상태");
		JLabel l7 = new JLabel("대여가격");
		
		
		JLabel emty1 = new JLabel("");
		JLabel emty2 = new JLabel("");
		JLabel emty3 = new JLabel("");
		JLabel emty4 = new JLabel("");
		JLabel emty5 = new JLabel("");
		JLabel emty6 = new JLabel("");
		JLabel emty7 = new JLabel("");

		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);
		JTextField t6 = new JTextField(10);
		JTextField t7 = new JTextField(10);

		
		p.add(l1);
		p.add(emty1);
		p.add(t1);
		
		p.add(l2);
		p.add(emty2);
		p.add(t2);
		
		p.add(l3);
		p.add(emty3);
		p.add(t3);

		p.add(l4);
		p.add(emty4);
		p.add(t4);

		p.add(l5);
		p.add(emty5);
		p.add(t5);
		p.add(l6);
		p.add(emty6);
		p.add(t6);
		p.add(l7);
		p.add(emty7);
		p.add(t7);
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		
		add(p);
		
		b1.addActionListener(e -> {
			int result = JOptionPane.showConfirmDialog(null,"정말로 돌아가시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
			setVisible(false);
			new ListFrame();
			}
		});
		
		b2.addActionListener(e ->{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			


		});
		
		b3.addActionListener(e -> {
			
				
			int result1 = JOptionPane.showConfirmDialog(null,"등록 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if(result1 == 0) {
					
					SaveRepo repo = new SaveRepo();
					String tilte = t1.getText();
					String category = t2.getText();
					String writer = t3.getText();
					String company = t4.getText();
					int price = Integer.parseInt(t5.getText());
					String status = t6.getText();
					int rental_price= Integer.parseInt(t7.getText());
					boolean result = repo.save(tilte, category, writer, company, price, status, rental_price);
					JOptionPane.showMessageDialog(null,"정상 등록 되었습니다.");
					setVisible(false);
					new ListFrame();
				} else {
					JOptionPane.showMessageDialog(null,"취소되었습니다.");
				}
			
		});		
	
	}
	
	private void SaveRepo() {
		
	}
}