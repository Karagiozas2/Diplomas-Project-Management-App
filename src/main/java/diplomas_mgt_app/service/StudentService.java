package diplomas_mgt_app.service;

import java.util.List;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Student;
import diplomas_mgt_app.model.Subject;

public interface StudentService {

    public void saveProfile(Student student);

    public Student retrieveProfile(String email);

    public List<Subject> listStudentSubjects();
    List<Application> listStudentApplications(int studentId);
    public List<Student> findAll();


    Student findByUsername(String currentStudentUsername);
}