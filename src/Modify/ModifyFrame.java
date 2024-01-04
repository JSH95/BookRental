
package Modify;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.PreparedStatement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Code.CategoryUtil;
import Detail.DetailFrame;
import Detail.Repo.DetailRepo;
import List.ListFrame;
import Modify.Repo.ModifyRepo;
import sun.net.www.content.image.jpeg;
import Save.Repo.SaveRepo;

public class ModifyFrame  extends JFrame{
	
	JButton b1 = new JButton("수정");
	JButton b2 = new JButton("취소");
	
	public ModifyFrame(String num) {
		setTitle("도서관리 시스템 - 수정화면");
		setSize(400, 300);
	
		setPanel(num);
			
		setLocationRelativeTo(null);
		setVisible(true);
		
}
	
	
	private void setPanel(String num) {
		JPanel p = new JPanel(new GridLayout(0,3));
		JLabel l1 = new JLabel("책제목");
		JLabel l2 = new JLabel("카테고리");
		JLabel l3 = new JLabel("저자");
		JLabel l4 = new JLabel("출판사");
		JLabel l5 = new JLabel("대여상태");
		JLabel l6 = new JLabel("책번호");
		JLabel l7 = new JLabel("책가격");
		JLabel l8 = new JLabel("대여자");
		JLabel l9 = new JLabel("대여일");
		JLabel l10 = new JLabel("대여비");
		
		JLabel emty1 = new JLabel("");
		JLabel emty2 = new JLabel("");
		JLabel emty3 = new JLabel("");
		JLabel emty4 = new JLabel("");
		JLabel emty5 = new JLabel("");
		JLabel emty6 = new JLabel("");
		JLabel emty7 = new JLabel("");
		JLabel emty8 = new JLabel("");
		JLabel emty9 = new JLabel("");
		JLabel emty10 = new JLabel("");
		JLabel emty11 = new JLabel("");
		
		DetailRepo repo1 = new DetailRepo();
		String[] detailInfo = repo1.detail(num);
		
		JTextField t1 = new JTextField(detailInfo[1]);
		
		JTextField t2 = new JTextField(detailInfo[2]);
		
		JTextField t3 = new JTextField(detailInfo[3]);
		JTextField t4 = new JTextField(detailInfo[4]);
		
		JTextField t5 = new JTextField(detailInfo[5]);

		
		JTextField t6 = new JTextField(detailInfo[0]);
		JTextField t7 = new JTextField(detailInfo[6]);
		JTextField t8 = new JTextField(detailInfo[7]);
		JTextField t9 = new JTextField(detailInfo[9]);
		JTextField t10 = new JTextField(detailInfo[10]);		
		
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
		
		p.add(l8);
		p.add(emty8);
		p.add(t8);
		
		p.add(l9);
		p.add(emty9);
		p.add(t9);
		
		p.add(l10);
		p.add(emty10);
		p.add(t10);
		
		p.add(emty11);
		p.add(b1);
		p.add(b2);
		
		add(p);
		
		 t6.setEnabled(false);

		b1.addActionListener(e -> {
			int result1 = JOptionPane.showConfirmDialog(null,"수정 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if(result1 == 0) {
			
				ModifyRepo repo = new ModifyRepo();
				String tilte = t1.getText();
				String category = t2.getText();
				String writer = t3.getText();
				String company = t4.getText();
				String status = t5.getText();
				int no = Integer.parseInt(t6.getText());
				int price = Integer.parseInt(t7.getText());
				String rental_user = t8.getText();
				String rental_day = t9.getText();				
				int rental_price = Integer.parseInt(t10.getText());
				String return_day = null;
				boolean result = repo.modify(tilte, category, writer, company, price, status, rental_user, return_day, rental_day, rental_price, no);
				JOptionPane.showMessageDialog(null,"정상 수정 되었습니다.");
				setVisible(false);
				new ListFrame();
			} else {
				JOptionPane.showMessageDialog(null,"취소되었습니다.");
			}
		});
	//옵션 후 종료
		b2.addActionListener(e -> {
			int result = JOptionPane.showConfirmDialog(null,"정말 수정을 취소하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);  
			if(result == 0) {
				setVisible(false);
				new ListFrame();
			}
		});
	
		
		
	}

}