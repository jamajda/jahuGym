package ie.gmit.its4;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException {

		System.out.println("FROM MAIN >>> does not much");
		HibernateUtil.getSessionFactory();

		User u1 = new User();
		u1.firstName = "Jacek";
		u1.lastName = "Majda";
		u1.type = "admin";
		
		User u2 = new User();
		u2.firstName = "Hugh";
		u2.lastName = "McHugh";
		u2.type = "admin";
		
		User u3 = new User();
		u3.firstName = "Donkey";
		u3.lastName = "Kong";
		u3.type = "user";
		
		
		
		Membership membership = new Membership();
		membership.setType("1month");
		membership.setDescription("Membership for one month.");
		membership.setPrice(10);
		
		membership.addUser(u1);
		membership.addUser(u2);
		membership.addUser(u3);



		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			session.save(u1);
			session.save(u2);
			session.save(u3);
			session.save(membership);

			trns.commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}

}
