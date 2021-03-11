/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cheetah
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Student stu1 = new Student(1, "Cheetah", 4.00);
//       Student stu2 = new Student(2, "Sthang", 3.75);
//       StudentTable.insertStudent(stu1);
//       StudentTable.insertStudent(stu2);
       Student stu;
       stu = StudentTable.findStudentById(1);
       if (stu != null) {
           stu.setName("Cheetah");
           stu.setGpa(4.00);
           StudentTable.removeStudent(stu);
//           StudentTable.updateStudent(stu);
       }
//       List<Student> stuList = StudentTable.findStudentByName("Sthang"); 
       List<Student> stuList = StudentTable.findAllStudent();
       printAllStudent(stuList);
    }
    public static void printAllStudent(List<Student> studentList) {
        for(Student stu : studentList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager st = stf.createEntityManager();
        st.getTransaction().begin();
        try {
            st.persist(object);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
    }
    
}

