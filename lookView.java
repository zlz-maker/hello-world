package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
 
 
public class lookView {
	private JFrame frame;
	private JFrame frame1;
	private JTextField textFieldSNo;
	private JTextField textFieldName;
	private JTextField textFieldCNo;
	//在内存中开辟一块空间，可供全局调用
	
	static readerFile stu = new readerFile();
	//构造方法，在类被调用的时候，自动执行
	public lookView() {
		stu.readerfile();
	}
 
 
	public JFrame lookFrame() {
		frame = new JFrame();
		frame.setTitle("欢迎进入学生成绩排名系统");
		frame.setBounds(300, 250, 900, 500);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("欢迎登录学生成绩查询系统！");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel.setBounds(250, 10, 400, 125);
		frame.getContentPane().add(lblNewLabel);
 
		textFieldSNo = new JTextField();
		textFieldSNo.setBounds(260, 130, 200, 50);
		frame.getContentPane().add(textFieldSNo);
		textFieldSNo.setColumns(20);
 
		JButton butlookSNo = new JButton("学号查询");
		butlookSNo.setBounds(510, 120, 150, 60); 
		frame.getContentPane().add(butlookSNo);
 
		textFieldName = new JTextField();
		textFieldName.setBounds(260, 230, 200, 50);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(20);
 
		JButton butlookName = new JButton("姓名查询");
		butlookName.setBounds(510, 220, 150, 60);
		frame.getContentPane().add(butlookName);
 
		textFieldCNo = new JTextField();
		textFieldCNo.setBounds(260, 330, 200, 50);
		frame.getContentPane().add(textFieldCNo);
		textFieldCNo.setColumns(20);
 
		JButton butlookCNo = new JButton("课程名查询");
		butlookCNo.setBounds(510, 320, 150, 60);
		frame.getContentPane().add(butlookCNo);
 
		Icon icon = new ImageIcon();
		JLabel label1 = new JLabel(icon);
		frame.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
		label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		((JPanel) cp).setOpaque(false);
 
		
		
		butlookSNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				int k = 0;
				String textSNo = textFieldSNo.getText();
				for (String a : stu.getStuNumber()) {
					if (textSNo.equals(a) == true) {
						k = 1;
						break;
					} else {
						i++;//找到角标，对应的第几个学号
					}
				}
				if (k == 1) {
					JOptionPane.showMessageDialog(frame,
							"姓名:  " + stu.getStuName().get(i) + "\n学号:  " + stu.getStuNumber().get(i) + "\n班级:  " + stu.getStuClass().get(i)
									+ "\n语文  :" + stu.getStuScore1().get(i) + "\n数学:  " +stu.getStuScore2().get(i) + "\n英语:  "
									+ stu.getStuScore3().get(i) + "\n政治:  " + stu.getStuScore4().get(i),
							"查询结果如下", JOptionPane.INFORMATION_MESSAGE);
				} else if (k == 0) {
					JOptionPane.showMessageDialog(frame, "提示：学号输入不正确，请重新输入");
				}
			}
		});
 
		butlookName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				int k = 0;
				String textName = textFieldName.getText();
				for (String a : stu.getStuName()) {
					if (textName.equals(a) == true) {
						k = 1;
						break;
					} else {
						i++;
					}
				}
				if (k == 1) {
					JOptionPane.showMessageDialog(frame,
							"姓名:  " + stu.getStuName().get(i) + "\n学号:  " + stu.getStuNumber().get(i) + "\n班级:  " + stu.getStuClass().get(i)
							+ "\n语文  :" + stu.getStuScore1().get(i) + "\n数学:  " +stu.getStuScore2().get(i) + "\n英语:  "
							+ stu.getStuScore3().get(i) + "\n政治:  " + stu.getStuScore4().get(i),
							"查询结果如下", JOptionPane.INFORMATION_MESSAGE);
				} else if (k == 0) {
					JOptionPane.showMessageDialog(frame, "提示：姓名输入不正确，请重新输入");
				}
			}
		});
 
		butlookCNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 100;
				String textCNo = textFieldCNo.getText();
				if ("语文".equals(textCNo)) {
					i = 0;
					lookCNo(stu.getStuScore1());
				} else if ("数学".equals(textCNo)) {
					i = 1;lookCNo(stu.getStuScore2());
				} else if ("英语".equals(textCNo)) {
					i = 2;lookCNo(stu.getStuScore3());
				} else if ("政治".equals(textCNo)) {
					i = 3;lookCNo(stu.getStuScore4());
				} else {
					i = 4;
				}
				if(i==4){
					JOptionPane.showMessageDialog(frame, "提示：课程名输入不正确，请重新输入");
				}
			}
 
			private void lookCNo(List list) {
				frame1 = new JFrame();
				frame1.setTitle("欢迎进入学生成绩排名系统");
				frame1.setBounds(300, 250, 900, 700);
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.getContentPane().setLayout(null);
				JLabel lblNewLabel1 = new JLabel("结果如下：");
				lblNewLabel1.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel1.setBounds(100, 10, 100, 25);
				frame1.getContentPane().add(lblNewLabel1);
				JLabel text = new JLabel();
					text.setBounds(100, 30, 200, 300);
					text.setFont(new Font("宋体", Font.PLAIN, 18));
					String xx="";
				for (int j = 1; j < list.size(); j++) {
						xx=xx+"<br><br>姓名:  " + stu.getStuName().get(j) + "<br>学号:  " + stu.getStuNumber().get(j)+"<br>" + list.get(0)+ ":  "+ list.get(j);
				}
				String xxx="<html><body>"+xx+"<body></html>";
				
				text.setText(xxx);
				frame1.getContentPane().add(text); 
				JScrollPane ScrollPane = new JScrollPane(text);//设置滚动条
				ScrollPane .setBounds(250, 50, 400, 600);
				frame1.getContentPane().add(ScrollPane);
				frame1.setVisible(true);
				frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		return frame;
	}
}
