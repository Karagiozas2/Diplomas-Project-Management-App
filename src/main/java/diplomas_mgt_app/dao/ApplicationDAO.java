package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {

    public Application findById(int theId);
    public List<Application> findAll();
    public List<Application> findByStudent(Student student);
    List<Application> findAllByThesisId(Integer thesisId);
}