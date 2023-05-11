package diplomas_mgt_app.service;

import java.util.List;

import diplomas_mgt_app.dao.ProfessorDAO;
import diplomas_mgt_app.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.dao.StudentDAO;
import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;
import diplomas_mgt_app.model.Subject;

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
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void applyToSubject(String email, Integer subjectId) {
        Student student = studentDAO.findByEmail(email);
        Subject subject = subjectDAO.getOne(subjectId);

        if (student != null && subject != null) {
            // Create a new Application and save it
            Application application = new Application(student, subject, "pending");
            applicationDAO.save(application);
        } else {
            // Handle errors (e.g., student or subject not found)
        }
    }
}