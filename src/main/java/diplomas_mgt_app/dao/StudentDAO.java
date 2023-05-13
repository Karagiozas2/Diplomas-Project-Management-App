package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    public Student findById(int theId);

    public Student findByEmail(String email);

    public Student findByUsername(String username);
    public List<Student> findAll();

}
