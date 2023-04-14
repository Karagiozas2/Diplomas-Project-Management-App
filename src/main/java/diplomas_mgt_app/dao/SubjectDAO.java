package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {

    public Subject findById(int theId);
}