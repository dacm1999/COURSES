package com.dacm.crudDemo;

import com.dacm.crudDemo.dao.StudentDAO;
import com.dacm.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {


		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			quearyForStudent(studentDAO);
//			quearyForStudentByFirstName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};
	}
	private void deleteAll(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row counts " + numRowsDeleted);
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int studentid = 1;
		System.out.println("Getting student with id:" + studentid);
		Student myStudent = studentDAO.findById(studentid);
		//Change first name to "Alejandro"
		System.out.println("Updating student...");
		myStudent.setFirstName("Luis");
		// Update the student
		studentDAO.update(myStudent);
		// Dispaly the update student
		System.out.println("Updated student: "+myStudent);
		
	}

	private void quearyForStudentByFirstName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByFirstName("Daniel");
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void quearyForStudent(StudentDAO studentDAO){
		//Get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//Display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//Creating a new student
		System.out.println("Creating a new student object...");
		Student tempStuden = new Student("Daniel","Contreras", "danielcontreras@mail.conm");
		//Save the object
		System.out.println("Saving the student");
		studentDAO.save(tempStuden);
		//Display id of the save student
		int theId = tempStuden.getId();
		System.out.println("Saved student, Generate id" + tempStuden.getId());
		//Retrieve student bases on the id: primary key
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the studnet " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		//Creating a new student
		System.out.println("Creating a new student object...");
		Student tempStuden = new Student("Pepe","Contreras", "pepecontreras@mail.conm");
		//Save the object
		System.out.println("Saving the student");
		studentDAO.save(tempStuden);
		//Display id of the save student
		System.out.println("Saved student, Generate id" + tempStuden.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//Creating a new student
		System.out.println("Creating a new students object...");
		Student tempStuden = new Student("Luis","Contreras", "luiscontreras@mail.conm");
		Student tempStuden2 = new Student("Alejandro","Contreras", "Alejandrocontreras@mail.conm");
		Student tempStuden3 = new Student("Mery","Contreras", "Meryocontreras@mail.conm");
		//Save the object
		System.out.println("Saving students");
		studentDAO.save(tempStuden);
		studentDAO.save(tempStuden2);
		studentDAO.save(tempStuden3);
		//Display id of the save student
		System.out.println("Saved student, Generate id" + tempStuden.getId());
		System.out.println("Saved student, Generate id" + tempStuden2.getId());
		System.out.println("Saved student, Generate id" + tempStuden3.getId());
	}

}
