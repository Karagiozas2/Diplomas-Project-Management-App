package diplomas_mgt_app.service;

import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Thesis;
import java.util.List;

public interface ThesisService {

    Thesis findById(int id);

    List<Thesis> findByProfessorId(int professor_id);

    List<Thesis> findBySubjectId(int subject_id);

    List<Thesis> findByProfessor(Professor professor);

    public void delete(int id);
}