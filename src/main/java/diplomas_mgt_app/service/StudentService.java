package diplomas_mgt_app.service;

import java.util.List;
import diplomas_mgt_app.model.Student;
import diplomas_mgt_app.model.Subject;

public interface StudentService {

    public void saveProfile(Student student);

    public Student retrieveProfile(String email);

    public List<Subject> listStudentSubjects();

    public void applyToSubject(String email, Integer subjectId);
}