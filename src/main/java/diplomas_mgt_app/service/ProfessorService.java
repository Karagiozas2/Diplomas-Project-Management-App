package diplomas_mgt_app.service;

import java.util.List;
import diplomas_mgt_app.model.Professor;

public interface ProfessorService {

    public List<Professor> findAll();

    public Professor findById(int theId);

    public void save(Professor theProfessor);

    public void deleteById(int theId);
}
