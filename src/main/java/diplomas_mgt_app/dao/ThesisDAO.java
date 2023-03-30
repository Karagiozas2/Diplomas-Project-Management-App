package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer> {

    public Thesis findById(int theId);

}
