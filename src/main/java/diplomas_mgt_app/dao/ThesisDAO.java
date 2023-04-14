package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer> {

    public Thesis findById(int theId);
    List<Thesis> findByProfessorEmail(String email);
    public List<Thesis> findByProfessor(Professor professor);
}
