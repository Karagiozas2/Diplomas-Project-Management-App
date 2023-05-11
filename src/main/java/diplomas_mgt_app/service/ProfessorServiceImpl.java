package diplomas_mgt_app.service;

import java.util.List;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.dao.ThesisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomas_mgt_app.dao.ProfessorDAO;
import diplomas_mgt_app.model.*;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDAO professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorDAO theProfessorRepository) {
        professorRepository = theProfessorRepository;
    }

    public ProfessorServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    @Transactional
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
    @Override
    @Transactional
    public Professor findById(int theId) {
        Professor result = professorRepository.findById(theId);

        if (result != null ) {
            return result;
        }
        else {
            // we didn't find the professor
            throw new RuntimeException("Did not find professor id - " + theId);
        }
    }

    @Override
    @Transactional
    public void save(Professor theProfessor) {
        professorRepository.save(theProfessor);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        professorRepository.deleteById(theId);
    }


    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private ApplicationDAO applicationDAO;

    @Autowired
    private ThesisDAO thesisDAO;

    @Override
    @Transactional
    public Professor retrieveProfile(String email) {
        return professorRepository.findByEmail(email);
    }
    @Override
    @Transactional
    public Professor findByUsername(String username) {
        return professorRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void saveProfile(Professor theProfessor) {
        professorRepository.save(theProfessor);
    }

    @Override
    @Transactional
    public List<Subject> listProfessorSubjects(String username) {
        Professor professor = professorRepository.findByUsername(username);
        return subjectDAO.findByProfessor(professor);
    }

    @Override
    @Transactional
    public void addSubject(String email, Subject subject) {
        Professor professor = professorRepository.findByEmail(email);
        subject.save(professor);
        subjectDAO.save(subject);
    }

    @Override
    @Transactional
    public List<Thesis> listProfessorTheses(int professor_id) {
        Professor professor = professorRepository.findById(professor_id);
        return thesisDAO.findByProfessorId(professor_id);
    }

    @Override
    public void assignSubject(String email, Integer applicationId) {

    }
/*
    @Override
    @Transactional
    public void assignSubject(String email, Integer applicationId) {
        Application application = applicationDAO.findById(applicationId);
        Subject subject = application.getSubject();
        Student student = application.getStudent();
        Thesis thesis = new Thesis(student, subject);
        thesisDAO.save(thesis);
    }
   TODO after student we remove the comment
*/
}

