package com.exam.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.exam.dao.StudentDao;
import com.exam.domain.Student;
import com.exam.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("添加学生  ------a；查找学生 -------b；删除学生 -------c");
			System.out.print("请输入操作类型:");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String type = br.readLine();

			if ("a".equals(type)) {
				System.out.print("请输入学生的姓名：");
				String name = br.readLine();

				System.out.print("请输入学生的准考证号：");
				String examid = br.readLine();

				System.out.print("请输入学生的身份证号：");
				String idcard = br.readLine();

				System.out.print("请输入学生的所在地：");
				String location = br.readLine();

				System.out.print("请输入学生的成绩：");
				String grade = br.readLine();

				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);

				StudentDao dao = new StudentDao();
				dao.add(s);

				System.out.println("添加成功!");

			} else if ("b".equals(type)) {
				System.out.print("请输入要查询的学生的准考证号码：");
				String examid = br.readLine();

				StudentDao dao = new StudentDao();
				Student student = dao.find(examid);
				if (student.equals(null)) {
					System.out.println("您输入的准考证号码不存在！");
				} else {
					System.out.println("您查询的学生信息为：");
					System.out.println("姓名：" + student.getName() + ","
							+ "身份证号码：" + student.getIdcard() + "," + "准考证号码："
							+ student.getExamid() + "," + "地区："
							+ student.getLocation() + "," + "成绩："
							+ student.getGrade());
				}
			} else if ("c".equals(type)) {

				System.out.print("请输入要删除的学生的姓名:");
				String name = br.readLine();
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("删除成功!");
				} catch (StudentNotExistException e) {
					System.out.println("您要删除的用户不存在！");
				}

			} else {
				System.out.println("不支持您的操作！");
			}
		} catch (Exception e) {
			System.out.println("对不起，出错了");
		}
	}
}
