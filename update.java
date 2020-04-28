package GUI;

import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class update {
 
	static readerFile stu = new readerFile();
	static List li = new ArrayList();
 
	public update() {
		stu.readerfile();
	}
 
	public static void Score(JFrame frame, String number, String choice) {
		int k = 0, i = 0;// k用于判断学号是否存在，i是为了找到角标
		for (String a : stu.getStuNumber()) {
			if (number.equals(a) == true) {
				k = 1;
				break;
			} else {
				i++;
			}
		}
		if (k == 1) {
			String xx = "姓名:  " + stu.getStuName().get(i) + "\n学号:  " + stu.getStuNumber().get(i) + "\n班级:  "
					+ stu.getStuClass().get(i) + "\n语文  :" + stu.getStuScore1().get(i) + "\n数学:  "
					+ stu.getStuScore2().get(i) + "\n英语:  " + stu.getStuScore3().get(i) + "\n政治:  "
					+ stu.getStuScore4().get(i);
			String ScoreName = JOptionPane.showInputDialog(frame, xx, "请输入科目名进行修改");
			li = returnList(frame, ScoreName);
			if (!li.isEmpty()) {// list不为空，即获得到了 目标数组对应的科目。
				if ("delete".equals(choice)) {
					li.set(i, "");
				} else if ("add".equals(choice)) {
					String score = JOptionPane.showInputDialog(frame, "修改" + ScoreName + "成绩，范围0~100", "请输入该科目的成绩");
					li.set(i, score);
				}
				if ("语文".equals(ScoreName)) {
					stu.setStuScore1(li);
				} else if ("数学".equals(ScoreName)) {
					stu.setStuScore2(li);
				} else if ("英语".equals(ScoreName)) {
					stu.setStuScore3(li);
				} else if ("政治".equals(ScoreName)) {
					stu.setStuScore4(li);
				}
				stu.writeFile();
				JOptionPane.showMessageDialog(frame,
						"修改成功,该学生信息如下：\n" + "姓名:  " + stu.getStuName().get(i) + "\n学号:  " + stu.getStuNumber().get(i)
								+ "\n班级:  " + stu.getStuClass().get(i) + "\n语文  :" + stu.getStuScore1().get(i)
								+ "\n数学:  " + stu.getStuScore2().get(i) + "\n英语:  " + stu.getStuScore3().get(i)
								+ "\n政治:  " + stu.getStuScore4().get(i));
			} else {
 
				JOptionPane.showMessageDialog(frame, "提示：科目名输入不正确，请重新输入");
			}
		} else if (k == 0) {
			JOptionPane.showMessageDialog(frame, "提示：学号输入不正确");
		}
	}
 
	public static List returnList(JFrame frame, String text) {
		List listt = new ArrayList();
		if ("语文".equals(text)) {
			listt = stu.stuScore1;
		} else if ("数学".equals(text)) {
			listt = stu.stuScore2;
		} else if ("英语".equals(text)) {
			listt = stu.stuScore3;
		} else if ("政治".equals(text)) {
			listt = stu.stuScore4;
		} else {
			JOptionPane.showMessageDialog(frame, "提示：课程名输入不正确，请重新输入");
		}
		return listt;
	}
 
}

