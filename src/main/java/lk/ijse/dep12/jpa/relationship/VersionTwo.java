package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class VersionTwo {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Student s001 = em.find(Student.class, "S001");
                Student s002 = em.find(Student.class, "S002");
                Student s003 = em.find(Student.class, "S003");

                Course c001 = em.find(Course.class, "C001");
                Course c002 = em.find(Course.class, "C002");
                Course c003 = em.find(Course.class, "C003");

                StudentCourse sc1 = new StudentCourse(s003,c003,"Nuwan",Date.valueOf(LocalDate.now()));
                StudentCourse sc2 = new StudentCourse(s001,c003,"Kasun",Date.valueOf(LocalDate.now()));

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
