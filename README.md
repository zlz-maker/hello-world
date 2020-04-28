# hello-world
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
    public class MainView {
	private JFrame frame;
 
	public static void main(String[] args) {
		MainView index = new MainView();
		JFrame frame2 = index.getFrame();
		frame2.setVisible(true);
	}
 
	public JFrame getFrame() {
		initialize();
		return frame;
	}
 
	public void initialize() {
 
		frame = new JFrame();
		frame.setTitle("欢迎进入学生成绩排名系统");
		frame.setBounds(300, 250, 900, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
 
		
		JLabel lblNewLabel = new JLabel("欢迎登录学生成绩排名系统！");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel.setBounds(270, 10, 400, 125);
		frame.getContentPane().add(lblNewLabel);
 
 
		JButton buttonLook = new JButton("查询成绩");
		buttonLook.setBounds(200, 120, 150, 60);
		frame.getContentPane().add(buttonLook);
 
		JButton buttonAdd = new JButton("修改成绩");
		buttonAdd.setBounds(500, 120, 150, 60);
		frame.getContentPane().add(buttonAdd);
 
		JButton buttonDelete = new JButton("删除成绩");
		buttonDelete.setBounds(200, 200, 150, 60);
		frame.getContentPane().add(buttonDelete);
 
		JButton buttonTop = new JButton("成绩排序");
		buttonTop.setBounds(500, 200, 150, 60);
		frame.getContentPane().add(buttonTop);
 
		JButton buttonSta = new JButton("成绩统计");
		buttonSta.setBounds(200, 280, 150, 60);
		frame.getContentPane().add(buttonSta);
 
		JButton buttonExit = new JButton("退出系统");
		buttonExit.setBounds(500, 280, 150, 60);
		frame.getContentPane().add(buttonExit);
 
		Icon icon = new ImageIcon();
		JLabel label1 = new JLabel(icon);
		frame.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
		label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		((JPanel) cp).setOpaque(false);
 
		
		// 按钮监听器
		buttonLook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lookView index = new lookView();
				JFrame framelook = index.lookFrame();
				framelook.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
 
		buttonAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String number = JOptionPane.showInputDialog("请输入需要添加或修改成绩学生的学号：");
				add_deleteView add = new add_deleteView();
				add.Score(frame, number, "add");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
 
		buttonDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //
				String number = JOptionPane.showInputDialog("请输入需要删除成绩学生的学号：");
				add_deleteView delete = new add_deleteView();
				delete.Score(frame, number, "delete");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
 
		buttonTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				topView tp = new topView();
			}
		});
 
		buttonSta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				statistics sta = new statistics();
			}
		});
 
		buttonExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
	}
}
