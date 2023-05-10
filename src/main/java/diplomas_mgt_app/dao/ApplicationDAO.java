package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {

    public Application findById(int theId);

    List<Application> findBySubjectId(Integer subjectId);
    public List<Application> findBySubject(Subject subject);
}