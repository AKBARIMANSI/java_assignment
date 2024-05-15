package utile;

import Dao.InstructorDao;
import model.Instructor;
import model.InstructorDetail;

public class Main
{
	public static void main(String[] args) 
	{
		Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@javaguides.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
        
        instructorDetail.setInstructor(instructor);
      
        instructor.setInstructorDetail(instructorDetail);

        InstructorDao instructorDao = new InstructorDao();
        instructorDao.addOrUpdate(instructor);
    }
}
