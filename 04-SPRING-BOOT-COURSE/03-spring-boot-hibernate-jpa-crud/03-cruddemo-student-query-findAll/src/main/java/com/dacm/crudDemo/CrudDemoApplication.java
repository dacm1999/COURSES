package com.dacm.crudDemo;

import com.dacm.crudDemo.dao.StudentDAO;
import com.dacm.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			readStudent(studentDAO);

		};
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
