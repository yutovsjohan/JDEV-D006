package main;

import java.util.ArrayList;
import java.util.List;

import dao.ClazzDAO;
import dao.CourseDAO;
import dao.StudentDAO;
import entities.Address;
import entities.Clazz;
import entities.Course;
import entities.Student;


public class Test {

	public static void main(String[] args) {
		testUpdateStudentJoinCourse();
		//testInsertStudent();
		//testGetStudentById(1);
		//testDeleteStudent();
		//testUpdateStudent();
		//testInsertClass();
		//testInsertCourse();
	}

	public static void testUpdateStudentJoinCourse() {
		CourseDAO courseDAO = new CourseDAO();
		StudentDAO studentDAO = new StudentDAO();
		
		try {
			Student student = studentDAO.get(1);
			Course course = courseDAO.get(1);
			List<Course> courses = new ArrayList<Course>();
			courses.add(course);
			student.setCourses(courses);
			studentDAO.update(student);
			System.out.println("testUpdateStudentJoinCourse successful: " + student.toString());
		} catch (Exception e) {
			System.out.println("testUpdateStudentJoinCourse failed: " + e.getMessage());
		}
	}

	public static void testInsertCourse() {
		try {
			CourseDAO courseDAO = new CourseDAO();
			Course course = new Course("PHP-Laravel-Framwork");
			courseDAO.insert(course);
			System.out.println("Insert Course object successful: " + course.toString());
		} catch (Exception e) {
			System.out.println("Insert Course object failed: " + e.getMessage());
		}
	}

	public static void testInsertClass() {
		try {
			ClazzDAO dao = new ClazzDAO();
			Clazz clazz = new Clazz("RUBY-R123");
			dao.insert(clazz);
			System.out.println("Insert Class object successful: " + clazz.toString());
		} catch (Exception e) {
			System.out.println("Insert Class object failed: " + e.getMessage());
		}
	}

	public static void testUpdateStudent(long id) {
		try {
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.get(id);
			student.setAge(40);
			studentDAO.update(student);
			System.out.println("Update Student object successful: " + student.toString());
		} catch (Exception e) {
			System.out.println("Update Student object failed: " + e.getMessage());
		}
	}

	public static void testDeleteStudent() {
		try {
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.get(2);
			studentDAO.delete(student);
			System.out.println("Delete Student object successful: " + student.toString());
		} catch (Exception e) {
			System.out.println("Delete Student object failed: " + e.getMessage());
		}
	}

	public static void testInsertStudent() {

		try {
			StudentDAO studentDAO = new StudentDAO();
			ClazzDAO clazzDAO = new ClazzDAO();
			CourseDAO courseDAO = new CourseDAO();

			Address add = new Address("Nguyen Thi Minh Khai", "3", "HCM");
			Clazz clazz = clazzDAO.get(2);
			Student student = new Student("Thanh", "Thanh", 21, add, clazz);

			studentDAO.insert(student);
			System.out.println("Insert Student object successful: " + student.toString());
		} catch (Exception e) {
			System.out.println("Insert Student object failed: " + e.getMessage());
		}
	}

	public static void testGetStudentById(long id) {
		StudentDAO dao = new StudentDAO();
		Student result = dao.get(id);
		System.out.println("Get student by id=%s: " + result.toString());
	}
}
