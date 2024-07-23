package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class VersionThree {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Course c001 = em.find(Course.class,"C001");
                Course c002 = em.find(Course.class,"C002");

                Student s003 = em.find(Student.class,"S003");
                Student s002 = em.find(Student.class,"S002");

                StudentCourse sc4 = new StudentCourse(s003,c002,"Nuwan",Date.valueOf(LocalDate.now()));
                StudentCourse sc5 = new StudentCourse(s002,c001,"Imantha",Date.valueOf(LocalDate.now()));

                em.persist(sc4);
                em.persist(sc5);

                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
