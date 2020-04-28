package GUI;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
 
public class readerFile {
	static List stuName = new ArrayList();
	static List stuClass = new ArrayList();
	static List stuNumber = new ArrayList();
	static List stuScore1 = new ArrayList();
	static List stuScore2 = new ArrayList();
	static List stuScore3 = new ArrayList();
	static List stuScore4 = new ArrayList();
 
	public void readerfile() {
		reader();
	}
 
	public static void reader() {
		// public static void main1(String[] args) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\zzz.csv"));//按字符读取
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line;
		stuName.clear();
		stuClass.clear();
		stuNumber.clear();
		stuScore1.clear();
		stuScore2.clear();
		stuScore3.clear();
		stuScore4.clear();
		try {
			while ((line = br.readLine()) != null) {
				stuName.add(line.split(",")[0]);
				stuNumber.add(line.split(",")[1]);
				stuClass.add(line.split(",")[2]);
				stuScore1.add(line.split(",")[3]);
				stuScore2.add(line.split(",")[4]);
				stuScore3.add(line.split(",")[5]);
				stuScore4.add(line.split(",")[6]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public void writeFile() {// 向文件写入
		write(stuName, stuNumber, stuClass, stuScore1, stuScore2, stuScore3, stuScore4);
	}
 
	public void write(List data, List data1, List data2, List data3, List data4, List data5, List data6) {
		try {
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("D:\\zzz.csv"), "UTF-8"));
 
			out.write("姓名");
			out.write(",");
			out.write("学号");
			out.write(",");
			out.write("班级");
			out.write(",");
			out.write("语文");
			out.write(",");
			out.write("数学");
			out.write(",");
			out.write("英语");
			out.write(",");
			out.write("政治");
			out.newLine();
			for (int i = 1; i < data.size(); i++) {
				out.write((String) data.get(i));
				out.write(",");
				out.write((String) data1.get(i));
				out.write(",");
				out.write((String) data2.get(i));
				out.write(",");
				out.write((String) data3.get(i));
				out.write(",");
				out.write((String) data4.get(i));
				out.write(",");
				out.write((String) data5.get(i));
				out.write(",");
				out.write((String) data6.get(i));
				out.newLine();
			}
			out.flush();
			out.close();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
 
	public static List<String> getStuName() {
		return stuName;
	}
 
	public static void setStuName(List<String> stuName) {
		readerFile.stuName = stuName;
	}
 
	public static List<String> getStuClass() {
		return stuClass;
	}
 
	public static void setStuClass(List<String> stuClass) {
		readerFile.stuClass = stuClass;
	}
 
	public static List<String> getStuNumber() {
		return stuNumber;
	}
 
	public static void setStuNumber(List<String> stuNumber) {
		readerFile.stuNumber = stuNumber;
	}
 
	public static List<String> getStuScore1() {
		return stuScore1;
	}
 
	public static void setStuScore1(List<String> stuScore1) {
		readerFile.stuScore1 = stuScore1;
	}
 
	public static List<String> getStuScore2() {
		return stuScore2;
	}
 
	public static void setStuScore2(List<String> stuScore2) {
		readerFile.stuScore2 = stuScore2;
	}
 
	public static List<String> getStuScore3() {
		return stuScore3;
	}
 
	public static void setStuScore3(List<String> stuScore3) {
		readerFile.stuScore3 = stuScore3;
	}
 
	public static List<String> getStuScore4() {
		return stuScore4;
	}
 
	public static void setStuScore4(List<String> stuScore4) {
		readerFile.stuScore4 = stuScore4;
	}
 
}

