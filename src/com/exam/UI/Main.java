package com.exam.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.exam.dao.StudentDao;
import com.exam.domain.Student;
import com.exam.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("���ѧ��  ------a������ѧ�� -------b��ɾ��ѧ�� -------c");
			System.out.print("�������������:");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String type = br.readLine();

			if ("a".equals(type)) {
				System.out.print("������ѧ����������");
				String name = br.readLine();

				System.out.print("������ѧ����׼��֤�ţ�");
				String examid = br.readLine();

				System.out.print("������ѧ�������֤�ţ�");
				String idcard = br.readLine();

				System.out.print("������ѧ�������ڵأ�");
				String location = br.readLine();

				System.out.print("������ѧ���ĳɼ���");
				String grade = br.readLine();

				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);

				StudentDao dao = new StudentDao();
				dao.add(s);

				System.out.println("��ӳɹ�!");

			} else if ("b".equals(type)) {
				System.out.print("������Ҫ��ѯ��ѧ����׼��֤���룺");
				String examid = br.readLine();

				StudentDao dao = new StudentDao();
				Student student = dao.find(examid);
				if (student.equals(null)) {
					System.out.println("�������׼��֤���벻���ڣ�");
				} else {
					System.out.println("����ѯ��ѧ����ϢΪ��");
					System.out.println("������" + student.getName() + ","
							+ "���֤���룺" + student.getIdcard() + "," + "׼��֤���룺"
							+ student.getExamid() + "," + "������"
							+ student.getLocation() + "," + "�ɼ���"
							+ student.getGrade());
				}
			} else if ("c".equals(type)) {

				System.out.print("������Ҫɾ����ѧ��������:");
				String name = br.readLine();
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("ɾ���ɹ�!");
				} catch (StudentNotExistException e) {
					System.out.println("��Ҫɾ�����û������ڣ�");
				}

			} else {
				System.out.println("��֧�����Ĳ�����");
			}
		} catch (Exception e) {
			System.out.println("�Բ��𣬳�����");
		}
	}
}
