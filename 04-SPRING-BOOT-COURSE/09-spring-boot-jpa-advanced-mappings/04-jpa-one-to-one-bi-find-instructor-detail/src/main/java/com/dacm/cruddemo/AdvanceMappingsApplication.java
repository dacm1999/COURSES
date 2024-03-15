package com.dacm.cruddemo;

import com.dacm.cruddemo.dao.AppDAO;
import com.dacm.cruddemo.dao.AppDAOImpl;
import com.dacm.cruddemo.entity.Instructor;
import com.dacm.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvanceMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAOImpl appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAOImpl appDAO) {

		int id = 1;
		System.out.println("Deleting user with id: " + id);

		appDAO.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(AppDAOImpl appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail().getHobby());

	}

	private void createInstructor(AppDAOImpl appDAO) {


		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}








