package diplomas_mgt_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomas_mgt_app.dao.ProfessorDAO;
import diplomas_mgt_app.model.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDAO professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorDAO theEmployeeRepository) {
        professorRepository = theEmployeeRepository;
    }

    public ProfessorServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    @Transactional
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}

