package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {

    public Professor findById(int theId);

    public Professor findByEmail(String email);

}
