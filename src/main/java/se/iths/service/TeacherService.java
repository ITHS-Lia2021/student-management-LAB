package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {


    @PersistenceContext
    EntityManager entityManager;

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public Teacher createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    public List<Teacher> findAllTeachers() {
        return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class)
                .getResultList();
    }

    public void addTeacherToSubject(Long teacherId, Long subjectId) {
        Teacher foundTeacher = entityManager.find(Teacher.class, teacherId);
        Subject foundSubject = entityManager.find(Subject.class, subjectId);

        foundTeacher.addSubject(foundSubject);
    }
}


