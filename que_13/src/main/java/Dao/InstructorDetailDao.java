package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.InstructorDetail;

public class InstructorDetailDao 
{
	
	 SessionFactory sf = null;
	
	public void addOrUpdate(InstructorDetail instructorDetail)
	{
        Transaction tx = null;
        int i=0;
        
        try  
        {
            Session s = sf.openSession();
			tx = s.beginTransaction();
			s.saveOrUpdate(instructorDetail);
			i=1;
			tx.commit();
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
			i=0;
			tx.rollback();
        }
    }

    public InstructorDetail getById(int id)
    {

        Transaction tx = null;
        InstructorDetail instructor = null;
        try 
        {
        	Session s = sf.openSession();
			tx = s.beginTransaction();
			instructor = s.load(InstructorDetail.class, id);
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
