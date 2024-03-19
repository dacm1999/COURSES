package com.dacm.cruddemo;

import com.dacm.cruddemo.dao.AppDAO;
import com.dacm.cruddemo.dao.AppDAOImpl;
import com.dacm.cruddemo.entity.Course;
import com.dacm.cruddemo.entity.Instructor;
import com.dacm.cruddemo.entity.InstructorDetail;
import com.dacm.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvanceMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAOImpl appDAO) {

		return runner -> {
			//createCourseAndReview(appDAO);
			retrieveCourseAndReviews(appDAO);
		};
	}

	private void retrieveCourseAndReviews(AppDAOImpl appDAO) {
		int id = 11;
		Course tempCourse = appDAO.findCourseAndReviewById(id);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReview(AppDAOImpl appDAO) {

		Course tempCourse = new Course("Pacman . How to score one million points");
		tempCourse.addReview(new Review("Great course ... I love it"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dumb course XDD"));

		System.out.println("Saving the course!");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAOImpl appDAO) {
		int id = 10;
		System.out.println("Deleting course with id " + id);
		appDAO.deleteCoursebyId(id);
		System.out.println("Done!");

	}

	private void deleteInstructor2(AppDAOImpl appDAO) {

		int id = 1;
		System.out.println("Deleting user with id: " + id);

		appDAO.deleteInstructorById2(id);
		System.out.println("Done");
	}

	private void updateCourse(AppDAOImpl appDAO) {
		int id = 10;

		System.out.println("Finding course id " + id);
		Course course = appDAO.findCourseById(id);
		System.out.println("Updating course id " + id);
		course.setTitle("Enjoy simpe things ");
		appDAO.updateCourse(course);
		System.out.println("Done");
	}

	private void updateInstructor(AppDAOImpl appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Updating instructor by id: " + id);
		instructor.setEmail("danielcontreras_98@hotmail.com");
		instructor.setLastName("Mejia");
		appDAO.updateInstructor(instructor);
		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAOImpl appDAO) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAOImpl appDAO) {
		int theId = 1;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAOImpl appDAO) {
		int id =1;
		System.out.println("Instructor id " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("The associated courses " + instructor.getCourses());
		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAOImpl appDAO) {


		// create the instructor
		Instructor tempInstructor =
				new Instructor("Daniel", "Contreras", "dacm.dev@icloud.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.com/youtube",
						"VideoGames");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//Create some courses
		Course tempCourse = new Course("AIR GUTIAR - THE ULTIME GUIDE");
		Course tempCourse2 = new Course("The Pinball Masterclass");
		Course tempCourse3 = new Course("GTA VICE CITY");

		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		//Save instructor
		System.out.println("Saving instructor" + tempInstructor.getFirstName());
		System.out.println("The courses " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("DONE!");
	}

	private void deleteInstructorDetail(AppDAOImpl appDAO) {
		int id = 2;
		System.out.println("Delete userdetail with id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAOImpl appDAO) {

		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor detail " + instructorDetail.toString());
		System.out.println("The associated instructor: " + instructorDetail.getInstructor());
		System.out.println("Done");
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
				new Instructor("Daniel", "Contreras", "dacm.dev@icloud.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.com/youtube",
						"PlayGames");

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








