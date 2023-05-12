package diplomas_mgt_app.service;

import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDAO;

    @Autowired
    public SubjectServiceImpl(SubjectDAO theSubjectDAO) {
        subjectDAO = theSubjectDAO;
    }

    @Override
    public void save(Subject subject) {
        subjectDAO.save(subject);
    }

    @Override
    @Transactional
    public List<Subject> findAll() {
        return subjectDAO.findAll();
    }

    @Override
    public Subject findById(Integer id) {
        return subjectDAO.findById(id).orElse(null);
    }
}