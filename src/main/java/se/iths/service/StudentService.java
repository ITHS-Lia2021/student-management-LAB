package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.Style;
import javax.transaction.Transactional;
import javax.ws.rs.QueryParam;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent (Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent (Student student){
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id){
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents (){
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public List <Student> getStudentsByLastname (String lastName){

        return entityManager.createQuery("SELECT s from Student s where s.lastName LIKE :lastName ", Student.class).setParameter("lastName", lastName).
                getResultList();
    }

    public void deleteStudent (Long id){
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

    public Student updateLastName (Long id, String lastName){
        Student foundStudent = entityManager.find(Student.class, id);
        foundStudent.setLastName(lastName);
        return entityManager.merge(foundStudent);
    }

}
