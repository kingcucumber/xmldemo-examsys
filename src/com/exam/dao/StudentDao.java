package com.exam.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.exam.domain.Student;
import com.exam.exception.StudentNotExistException;
import com.exam.utils.XmlUtils;

public class StudentDao {

	public void add(Student s) {
		try {
			Document document = XmlUtils.getDocument();

			Element studnet_tag = document.createElement("student");
			studnet_tag.setAttribute("idcard", s.getIdcard());
			studnet_tag.setAttribute("examid", s.getExamid());

			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");

			name.setTextContent(s.getName());
			location.setTextContent(s.getLocation());
			grade.setTextContent(s.getGrade() + "");

			studnet_tag.appendChild(name);
			studnet_tag.appendChild(location);
			studnet_tag.appendChild(grade);

			document.getElementsByTagName("exam").item(0).appendChild(
					studnet_tag);

			XmlUtils.write2Xml(document);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Student find(String examid) {
		try {
			Document document = XmlUtils.getDocument();

			NodeList list = document.getElementsByTagName("student");
			for (int i = 0; i < list.getLength(); i++) {
				Element student_tag = (Element) list.item(i);

				if (student_tag.getAttribute("examid").equals(examid)) {
					Student s = new Student();
					s.setExamid(examid);
					s.setIdcard(student_tag.getAttribute("idcard"));

					s.setName(student_tag.getElementsByTagName("name").item(0)
							.getTextContent());
					s.setLocation(student_tag.getElementsByTagName("location")
							.item(0).getTextContent());
					s.setGrade(Double.parseDouble(student_tag
							.getElementsByTagName("grade").item(0)
							.getTextContent()));
					return s;
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String name) throws StudentNotExistException {

		try {
			Document document = XmlUtils.getDocument();

			NodeList list = document.getElementsByTagName("name");
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getTextContent().equals(name)) {
					list.item(i).getParentNode().getParentNode().removeChild(
							list.item(i).getParentNode());
					XmlUtils.write2Xml(document);
					return ;
				}
			}
			throw new StudentNotExistException(name + "²»´æÔÚ");
		}catch(StudentNotExistException e1){
			throw e1;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
