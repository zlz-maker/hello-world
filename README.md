# hello-world
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class loginView {
	 private JFrame frame; 
	 private JTextField textField; 
	 private JPasswordField textField_1; 
	
	 
	 public static void main(String[] args) { 	 
	    loginView window = new loginView(); 
	    window.initialize();
	    window.frame.setVisible(true); 
	 } 
		 
	 private void initialize() { 
	  frame = new JFrame(); 
	  frame.setTitle("欢迎进入学生成绩排名系统"); 
	  frame.setBounds(300, 250, 900, 500); 	
	  
	  Icon icon=new ImageIcon();
	  JLabel label1=new JLabel(icon);
	  frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
	  label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
	  Container cp=frame.getContentPane();
	  cp.setLayout(new BorderLayout());
	  ((JPanel)cp).setOpaque(false);
	  
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  frame.getContentPane().setLayout(null);    
	  JLabel lblNewLabel = new JLabel("学生成绩排名系统用户登录"); 
	  lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 32)); 
	  lblNewLabel.setBounds(250, 10, 400, 125);
	  frame.getContentPane().add(lblNewLabel); 	   
	  JLabel lblNewLabel_1 = new JLabel("用户名"); 
	  lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18)); 
	  lblNewLabel_1.setBounds(300, 150, 67, 30); 
	  frame.getContentPane().add(lblNewLabel_1); 	   
	  textField = new JTextField(); 
	  textField.setBounds(400, 150, 141, 30); 
	  frame.getContentPane().add(textField); 
	  textField.setColumns(18); 	   
	  JLabel label = new JLabel("密码"); 
	  label.setFont(new Font("宋体", Font.PLAIN, 18));
	  label.setBounds(300, 220, 67, 30); 
	  frame.getContentPane().add(label);    
	  textField_1 = new JPasswordField(); 
	  textField_1.setEchoChar('*');
	  textField_1.setColumns(18); 
	  textField_1.setBounds(400, 220, 141, 30); 
	  frame.getContentPane().add(textField_1); 
	  JButton button = new JButton("登录");
	  button.setBounds(300, 300, 100, 40); 
	  frame.getContentPane().add(button); 
	  button.addMouseListener(new MouseAdapter() { 
	   @Override 
	   public void mouseClicked(MouseEvent e) {  
	    String user=textField.getText(); 
	    String password=textField_1.getText(); 
	    if(user.equals("")||user==null){ 
	     JOptionPane.showMessageDialog(frame, "提示：帐号不能为空！"); 
	     return; 
	    }else if(password.equals("")||password==null){ 
	     JOptionPane.showMessageDialog(frame, "提示：密码不能为空！"); 
	     return; 
	    }else if("1".equals(user)&&"123456".equals(password)){  
	      MainView index=new MainView(); 
	      JFrame frame2=index.getFrame(); 
	      frame2.setVisible(true); 
	      frame.dispose(); 
	    }else {
	    	JOptionPane.showMessageDialog(frame, "提示：用户名或密码错误，请重新输入！");
	    }
	   }    
	  });   
	  JButton button_1 = new JButton("退出"); 
	  button_1.setBounds(450, 300, 100, 40); 
	  frame.getContentPane().add(button_1); 
	  button_1.addMouseListener(new MouseAdapter() {
		  @Override 
		   public void mouseClicked(MouseEvent e) { 
			 frame.dispose();
		  }
	  });	   
	} 
}
