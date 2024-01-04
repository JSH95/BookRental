package List;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Code.Category;
import Code.CategoryUtil;
import Code.Status;
import Code.StatusUtil;
import Detail.DetailFrame;
import List.Repo.ListRepo;
import Save.SaveFrame;


public class ListFrame extends JFrame{
	
	String selectedNo = "0";
	String[][] datalist;
	JButton b = new JButton("검색");
	JButton b1 = new JButton("검색결과초기화");
	JButton b2 = new JButton("도서상세보기");	

	JTextField tf = new JTextField(10);
	
	JLabel l = new JLabel("책제목");
	
	JTable t;
	DefaultTableModel tm;
	
	public ListFrame() {
		setTitle("도서관리 시스템 - 일람화면");
		setSize(700, 600);
		setLayout(new BorderLayout(10, 10));
		
		setNorthPanel();
		setCenterPanel();
		setEastPanel();
		setSouthPanel();
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setSouthPanel() {
		JPanel p = new JPanel();
		p.add(b1);
		add(p, "South");
	}

	private void setEastPanel() {
		JPanel p = new JPanel(new GridLayout(10, 0));
		JButton b1 = new JButton("도서등록 ");
		b2.setEnabled(false);
		p.add(b1);
		p.add(b2);
		add(p, "East");
		
		b1.addActionListener(e ->{
			setVisible(false);
			new SaveFrame();
		});
		
		b2.addActionListener(e -> {
			setVisible(false);
			new DetailFrame(selectedNo);
		});
	}

	private void setCenterPanel() {
		JPanel p = new JPanel();
		
		String[] title = {"no", "제목", "카테고리", "저자", "출판사", "대여상태"};
		
		tm = new DefaultTableModel(new String[0][0], title);
		
		t = new JTable(tm);
		JScrollPane s = new JScrollPane(t);
	
		p.add(s);
		add(p, "Center");
		//검색버튼
		b.addActionListener(e ->{
			ListRepo repo = new ListRepo();
			datalist = repo. list();
			tm.setRowCount(0);
			
			for(String[] data : datalist) {
				
				String searchWord = tf.getText();
				if(data[0].contains(searchWord)) {
					//카테고리 변환 처리
				CategoryUtil cUtil = new CategoryUtil();
						data[2] = cUtil.getDispValue(data[2]);

						//대여상태 변환 처리
						StatusUtil bUtil = new StatusUtil();
						data[5] = bUtil.getDispValue(data[5]);
						
					tm.addRow(data);
				}
			}
					
		});
		
		t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				b2.setEnabled(true);
				int selectedRow = t.getSelectedRow();
				selectedNo = datalist[selectedRow][0];
				//행, 열 보기
//				int row = t.getSelectedRow();
//				int col = t.getSelectedColumn();
//				//JOptionPane.showMessageDialog(null, "행" + row + "열" + col);
//				System.out.println("row index값은" + row);
//				System.out.println("column index값은" + col);
//				System.out.println(data[row][col]);
			}
		});
	}

	private void setNorthPanel() {
		JPanel p = new JPanel();
		
		p.add(l);
		p.add(tf);
		p.add(b);
		add(p, "North");
		
		b1.addActionListener(e -> {
			tf.setText("");
			b2.setEnabled(false);
			tm.setRowCount(0);
			
		});
	}
	
}