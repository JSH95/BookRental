package Detail;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import Code.CategoryUtil;
import Delete.Repo.DeleteRepo;
import Detail.Repo.DetailRepo;
import List.ListFrame;
import Modify.ModifyFrame;
import Modify.Repo.ModifyRepo;
import sun.net.www.content.image.jpeg;
import Save.Repo.SaveRepo;

public class DetailFrame extends JFrame{
	
	JButton b1 = new JButton("일람으로");
	JButton b2 = new JButton("수정");
	JButton b3 = new JButton("삭제");
	
	public DetailFrame(String num) {
			setTitle("도서관리 시스템 - 상세화면");
			setSize(400, 300);
			setLayout(new BorderLayout(10, 10));
		

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
		
		
		DetailRepo repo1 = new DetailRepo();
		String[] detailInfo = repo1.detail(num);
		
		
		
		JLabel emty1 = new JLabel("");
		JLabel emty2 = new JLabel("");
		JLabel emty3 = new JLabel("");
		JLabel emty4 = new JLabel("");
		JLabel emty5 = new JLabel("");
		JLabel emty6 = new JLabel("");
		JLabel emty7= new JLabel("");
		JLabel emty8 = new JLabel("");
		JLabel emty9 = new JLabel("");
		JLabel emty10 = new JLabel("");
		
		JTextField t1 = new JTextField(detailInfo[1]);
		
		CategoryUtil cUtil = new CategoryUtil();
		String category = cUtil.getDispValue(detailInfo[2]);
		JTextField t2 = new JTextField(category);
		
		JTextField t3 = new JTextField(detailInfo[3]);
		JTextField t4 = new JTextField(detailInfo[4]);
		//JTextField t5 = new JTextField(detailInfo[5]);
		JTextField t6= new JTextField(detailInfo[0]);
		
		JLabel t5;
		if(Integer.parseInt(detailInfo[5]) == 0) {
				t5 = new JLabel("대여가능");
			} else if(Integer.parseInt(detailInfo[5]) == 1) {
				t5 = new JLabel("대여중");
				} else {
					t5 = new JLabel("대여불가능");
				}
		
		JTextField t7= new JTextField(detailInfo[6]);
		JTextField t8= new JTextField(detailInfo[7]);
		JTextField t9= new JTextField(detailInfo[9]);
		JTextField t10= new JTextField(detailInfo[10]);

		
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

		p.add(b1);
		p.add(b2);
		p.add(b3);

		add(p);
		
		 t1.setEnabled(false);
		 t2.setEnabled(false);
		 t3.setEnabled(false);
		 t4.setEnabled(false);
		 t5.setEnabled(false);
		 t6.setEnabled(false);
		 t7.setEnabled(false);
		 t8.setEnabled(false);
		 t9.setEnabled(false);
		 t10.setEnabled(false);

		
		 
		b1.addActionListener(e -> {
			setVisible(false);
			new ListFrame();
		});
		
		b2.addActionListener(e -> {
			
			setVisible(false);
			new ModifyFrame(num);
		});
		
		b3.addActionListener(e -> {
			int result1 = JOptionPane.showConfirmDialog(null,"정말로 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if(result1 == 0) {
				DeleteRepo repo = new DeleteRepo(); 
				int no = Integer.parseInt(num);
				boolean result = repo.delete(no);
				
				JOptionPane.showMessageDialog(null,"정상삭제 되었습니다.");
				setVisible(false);
				new ListFrame();
			} else {
				JOptionPane.showMessageDialog(null,"취소되었습니다.");
			}
		});
		
	}		

}
