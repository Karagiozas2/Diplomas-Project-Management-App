package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {

    public Application findById(int theId);
}