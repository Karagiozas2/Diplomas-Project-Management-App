package diplomas_mgt_app.service;

import java.util.ArrayList;
import java.util.List;

import diplomas_mgt_app.dao.ProfessorDAO;
import diplomas_mgt_app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.dao.StudentDAO;
import diplomas_mgt_app.dao.SubjectDAO;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentRepository;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private ApplicationDAO applicationDAO;

    @Override
    @Transactional
    public void saveProfile(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student retrieveProfile(String email) {
        return studentDAO.findByEmail(email);
    }

    @Override
    @Transactional
    public List<Subject> listStudentSubjects() {
        return subjectDAO.findAll();
    }


    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student findByUsername(String username) {
        return studentDAO.findByUsername(username);
    }

    @Override
    public List<Application> listStudentApplications(int studentId) {
        Student student = studentDAO.findById(studentId);
        if (student != null) {
            return applicationDAO.findByStudent(student);
        }
        return new ArrayList<>();
    }
}
