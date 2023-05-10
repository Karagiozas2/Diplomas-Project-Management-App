package diplomas_mgt_app.service;

import java.util.List;
import diplomas_mgt_app.model.*;
import org.springframework.transaction.annotation.Transactional;

public interface ProfessorService {

    public List<Professor> findAll();

    public Professor findById(int theId);

    public void save(Professor theProfessor);

    public void deleteById(int theId);

    public Professor retrieveProfile(String email);


    Professor findByUsername(String username);

    public void saveProfile(Professor theProfessor);
    public List<Subject> listProfessorSubjects(String email);
    public void addSubject(String email, Subject subject);
    public List<Application> listApplications(String email, Integer subjectId);
    public List<Thesis> listProfessorTheses(int professor_id);
    public void assignSubject(String email, Integer applicationId);
}
