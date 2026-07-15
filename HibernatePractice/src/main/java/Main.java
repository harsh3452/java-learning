import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args){
        Student s = new Student();
        s.setSid(45);
        s.setSname("Harsh");
        s.setSage(74);

        Configuration config = new org.hibernate.cfg.Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Student.class);

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        //Create/save
        session.persist(s);

        // get/fetch object/data
        //Student s1 = session.find(Student.class,4);
        //System.out.println(s1.toString());

        //session.merge(s); //used to update information of the object

        //Student student = session.find(Student.class,4);
        //session.remove(student);
        tx.commit();

        session.close();
        factory.close();
    }
}
