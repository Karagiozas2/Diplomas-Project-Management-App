package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {

    public Subject findById(int theId);
    public List<Subject> findByProfessor(Professor professor);

    public Subject findByIdAndProfessor(int id, Professor professor);
    void save(Professor theProfessor);
}