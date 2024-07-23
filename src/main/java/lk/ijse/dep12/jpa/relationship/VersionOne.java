package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class VersionOne {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {
//          Add students and courses
/*                Course c001 = new Course("C001", "DEP", "6 Months");
                Course c002 = new Course("C002", "CMJD", "8 Months");
                Course c003 = new Course("C003", "GDSE", "2 Years");

                Student s001 = new Student("S001", "Tharindu Rukshan", "Galle", "011-1234567", Date.valueOf("1999-05-27"));
                Student s002 = new Student("S002", "Ramesh Jayarathna", "Gampaha", "022-1234567", Date.valueOf("1997-01-07"));
                Student s003 = new Student("S003", "Ishara Dhananjani", "Kurunagala", "033-1234567", Date.valueOf("1999-05-14"));

                List.of(s001,s002,s003,c001,c002,c003).forEach(em::persist);*/

                Student s001 = em.find(Student.class, "S001");
                Student s002 = em.find(Student.class, "S002");
                Student s003 = em.find(Student.class, "S003");

                Course c001 = em.find(Course.class, "C001");
                Course c002 = em.find(Course.class, "C002");
                Course c003 = em.find(Course.class, "C003");

                StudentCourse sc1 = new StudentCourse(s001,c001,"Ravindya",Date.valueOf(LocalDate.now()));
                StudentCourse sc2 = new StudentCourse(s002,c002,"Kavindu",Date.valueOf(LocalDate.now()));

                em.persist(sc1);
                em.persist(sc2);


                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
