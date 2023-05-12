package diplomas_mgt_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import diplomas_mgt_app.dao.ThesisDAO;
import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Thesis;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ThesisServiceImpl implements ThesisService {

    private ThesisDAO thesisDAO;

    @Autowired
    public ThesisServiceImpl(ThesisDAO theThesisDAO) {
        thesisDAO = theThesisDAO;
    }

    @Override
    public Thesis findById(int id) {
        return thesisDAO.findById(id);
    }

    @Override
    public List<Thesis> findByProfessorId(int professor_id) {
        return thesisDAO.findByProfessorId(professor_id);
    }

    @Override
    public List<Thesis> findBySubjectId(int subject_id) {
        return thesisDAO.findBySubjectId(subject_id);
    }

    @Override
    public List<Thesis> findByProfessor(Professor professor) {
        return thesisDAO.findByProfessor(professor);
    }

    @Override
    @Transactional
    public void delete(int id) {
        thesisDAO.deleteById(id);
    }
}