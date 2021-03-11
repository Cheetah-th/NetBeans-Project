/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import studentdatabasejpa.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Cheetah
 */
public class StudentTable {
        
    public static void insertStudent(Student stu) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        st.getTransaction().begin();
        try {
            st.persist(stu);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
    }
    public static void updateStudent(Student stu) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        Student fromDb = st.find(Student.class, stu.getId());
        fromDb.setName(stu.getName());
        fromDb.setGpa(stu.getGpa());
        st.getTransaction().begin();
        try {
            st.persist(fromDb);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
    }
    public static Student findStudentById(Integer id) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        Student stu = st.find(Student.class, id);
        st.close();
        return stu;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        List<Student> stuList = (List<Student>) st.createNamedQuery("Student.findAll").getResultList();
        st.close();
        return stuList;
    }
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        Query query = st.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> stuList = (List<Student>) query.getResultList();
        st.close();
        return stuList;
    }
    public static void removeStudent(Student stu) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        Student fromDb = st.find(Student.class, stu.getId());
        st.getTransaction().begin();
        try {
            st.remove(fromDb);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
                
    }

}