package junit.test;

import org.junit.Test;

import com.exam.dao.StudentDao;
import com.exam.domain.Student;

public class StudentDaoTest {

	@Test
	public void testAdd(){
		StudentDao dao = new StudentDao();
		Student s = new Student();
		
		s.setExamid("121");
		s.setGrade(89);
		s.setIdcard("121");
		s.setLocation("±±¾©");
		s.setName("aaa");
		dao.add(s);
	}
	
	@Test
	public void testFind(){
		StudentDao dao = new StudentDao();
		dao.find("121");
	}
	
	@Test
	public void testDelete() throws Exception{
		StudentDao dao = new StudentDao();
		dao.delete("aaa");
		
	}
}
