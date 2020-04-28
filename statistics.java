package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class statistics {
	private static JFrame frame;
	private JFrame frame1;
	private JTextField textField;
	List list=new ArrayList();
	static readerFile stu = new readerFile();
	
//	public static void main(String[] args) {
	//	statistics sc =new statistics();
	public statistics() {
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
		JLabel lblNewLabel = new JLabel("欢迎登录学生成绩统计系统！");
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
 
		JButton butlookTop = new JButton("最高分查询");
		butlookTop.setBounds(80, 320, 150, 60);
		frame.getContentPane().add(butlookTop);
 
		
		JButton butlookLow = new JButton("最低分查询");
		butlookLow.setBounds(280, 320, 150, 60);
		frame.getContentPane().add(butlookLow);
 
		
		JButton butlookAvg = new JButton("平均分查询");
		butlookAvg.setBounds(480, 320, 150, 60);
		frame.getContentPane().add(butlookAvg);
		
		
		JButton butlookPass = new JButton("及格率查询");
		butlookPass.setBounds(680, 320, 150, 60);
		frame.getContentPane().add(butlookPass);
 
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
				for (int i = 1; i <list.size()-1; i++) {
 
					float aa=Integer.parseInt((String) list.get(i));
					float bb=Integer.parseInt((String) list.get(i+1));
					if(bb<aa ){
						list.set(i+1, list.get(i));
					}
				}
				JOptionPane.showMessageDialog(frame, "最高分为："+list.get(list.size()-1));
			}
			
		});
		
		butlookLow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=textField.getText();
				list =returnList(text);
				for (int i = 1; i <list.size()-1; i++) {
 
					float aa=Integer.parseInt((String) list.get(i));
					float bb=Integer.parseInt((String) list.get(i+1));
					if(bb>aa ){
						list.set(i+1, list.get(i));
					}
				}
				JOptionPane.showMessageDialog(frame, "最低分为："+list.get(list.size()-1));
			}
			
		});
		butlookAvg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=textField.getText();	
				list =returnList(text);
				float result=0;
				int count=0;
				for (int i = 1; i <list.size(); i++) {
					result += Integer.parseInt((String) list.get(i));
					count++;
				}
				JOptionPane.showMessageDialog(frame, "平均分为："+result/count);
			}
			
		});
		
		butlookPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=textField.getText();	
				list =returnList(text);
				float count=0,pass=0;
				NumberFormat nf = NumberFormat.getPercentInstance();//小数转化为百分数
				nf.setMaximumFractionDigits(2);//这个2的意思是保存结果到小数点后几位.
				for (int i = 1; i <list.size(); i++) {
					if(Integer.parseInt((String) list.get(i))>=60) {
						pass++;
					}
					count++;
				}
				JOptionPane.showMessageDialog(frame, "及格率为："+nf.format(pass/count));
			}
			
		});
	}
 
	
	/**addAll方法 ，相当于复制list的所有数据，到另一个list
	 * 不能直接用“=” 赋值
	 */
	public static List returnList(String text) {   
		List listt=new ArrayList();
		if ("语文".equals(text)) {
				listt.addAll(stu.getStuScore1());
			} else if ("数学".equals(text)) {
				listt.addAll(stu.getStuScore2());
			} else if ("英语".equals(text)) {
				listt.addAll(stu.getStuScore3());
			} else if ("政治".equals(text)) {
				listt.addAll(stu.getStuScore4());
			} else{
				JOptionPane.showMessageDialog(frame, "提示：课程名输入不正确，请重新输入");
			}
		return listt;
	}
}
