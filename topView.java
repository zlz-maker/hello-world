package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
 
public class topView {
	private static JFrame frame;
	private JFrame frame1;
	private JTextField textField;
	List list=new ArrayList();
	static readerFile stu = new readerFile();
	
	
	public topView() {
		stu.readerfile();
		lookFrame();
		frame.setVisible(true); 
	}
 
	
	public void lookFrame() {
		frame = new JFrame();
		frame.setTitle("欢迎进入学生成绩排名系统");
		frame.setBounds(300, 250, 900, 500);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("欢迎登录学生成绩排序系统！");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel.setBounds(250, 10, 400, 125);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel2 = new JLabel("请输入课程名：");
		lblNewLabel2.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel2.setBounds(100, 140, 200, 80);
		frame.getContentPane().add(lblNewLabel2);
 
		textField = new JTextField();
		textField.setBounds(250, 150, 400, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(20);
 
		JButton butlookTop = new JButton("升序");
		butlookTop.setBounds(150, 320, 150, 60);
		frame.getContentPane().add(butlookTop);
 
		
		JButton butlookLow = new JButton("降序");
		butlookLow.setBounds(480, 320, 150, 60);
		frame.getContentPane().add(butlookLow);
 
		Icon icon = new ImageIcon("");
		JLabel label1 = new JLabel(icon);
		frame.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
		label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		((JPanel) cp).setOpaque(false);
 
		
		
		
		
		butlookTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=textField.getText();	
				list =returnList(text);
				top(list,1);
			}
		});
		
		butlookLow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=textField.getText();	
				list =returnList(text);
				top(list,2);
			}			
		});		
	}
	public static List returnList(String text) {   //不执行if语句
		List listt=new ArrayList();
		if ("语文".equals(text)) {
				listt=stu.stuScore1;
			} else if ("数学".equals(text)) {
				listt=stu.stuScore2;
			} else if ("英语".equals(text)) {
				listt=stu.stuScore3;
			} else if ("政治".equals(text)) {
				listt=stu.stuScore4;
			} else{
				JOptionPane.showMessageDialog(frame, "提示：课程名输入不正确，请重新输入");	
				return (List) topView.frame;
			}
		return listt;
	}
	
	private void top(List list,int choice) {
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
			text.setBounds(250, 50, 400, 600);
			text.setFont(new Font("宋体", Font.PLAIN, 18));
 
		String xx=high__low(list,choice);
		String xxx="<html><body>"+xx+"<body></html>";
		text.setText(xxx);
		frame1.getContentPane().add(text); 
		
		JScrollPane ScrollPane = new JScrollPane(text);//设置滚动条
		ScrollPane .setBounds(250, 50, 400, 600);
		frame1.getContentPane().add(ScrollPane);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String high__low(List list,int choice) {
		List ls =new ArrayList();
		for (Object object : list) {
			if(!"".equals(object)&&!"语文".equals(object)&&!"数学".equals(object)&&!"英语".equals(object)&&!"政治".equals(object)) {
				ls.add(Integer.parseInt(object.toString()));
			}
		}
		
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.size()-1; j++) {
				
				int aa=(int) ls.get(j);
				int bb=(int) ls.get(j+1);
				boolean ch = false;
				if(choice==1) {//choice为1表示升序
					 ch= aa<bb;
				}else if(choice==2){//choice为2表示降序
					ch= aa>bb;
				}
				if(ch) {
					ls.set(j, aa);
					ls.set(j+1, bb);
				}else {
					ls.set(j, bb);
					ls.set(j+1, aa);
				}
			}
				}
		String xx="";
		for (int j = 0; j < ls.size(); j++) {//做到姓名匹配还需要一个方法，
		
			xx=xx+"<br>"+list.get(0)+ ":  "+ ls.get(j);
			}
		return xx;
	}
}

