/*

package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TeacherService {


    @PersistenceContext
    EntityManager entityManager;

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public Teacher createTeacher(Teacher teacher) {

        // Adding Subjects for demo purposes
        teacher.addSubject(new Subject("Matematik"));
        teacher.addSubject(new Subject("Svenska"));
        teacher.addSubject(new Subject("Engelska"));
        entityManager.persist(teacher);
        return teacher;

    }
}

 */
