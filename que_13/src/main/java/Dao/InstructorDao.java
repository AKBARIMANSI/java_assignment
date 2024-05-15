package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Instructor;
import model.InstructorDetail;

public class InstructorDao
{
	SessionFactory sf = null;
	
	public void addOrUpdate(Instructor instructor)
	{
        Transaction tx = null;
        int i=0;
        try 
        {
        	Session s = sf.openSession();
 			tx = s.beginTransaction();
 			s.saveOrUpdate(instructor);
 			i=1;
            tx.commit();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            tx.rollback();
        }
    }

    public int deleteInstructor(int id)
    {

        Transaction tx = null;
        int i=0;
        try 
        {
        	Session s = sf.openSession();
			tx = s.beginTransaction();
			InstructorDao dao= s.load(InstructorDao.class, id);
			s.delete(dao);
			i=1;
            tx.commit();
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
			i=0;
			tx.rollback();
        }
        return i;
    }

    public Instructor getById(int id)
    {

        Transaction tx = null;
        Instructor instructor = null;
        try 
        {
        	Session s = sf.openSession();
			tx = s.beginTransaction();
			instructor = s.load(Instructor.class, id);
			tx.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            tx.rollback();
        }
        return instructor;
    }
}
