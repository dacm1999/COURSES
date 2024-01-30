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
			createStudent(studentDAO);

		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//Creating a new student
		System.out.println("Creating a new student object...");
		Student tempStuden = new Student("Daniel","Contreras", "danielcontreras@mail.conm");
		//Save the object
		System.out.println("Saving the student");
		studentDAO.save(tempStuden);
		//Display id of the save student
		System.out.println("Saved student, Generate id" + tempStuden.getId());
	}

}
