package diplomas_mgt_app.dao;

import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.AssignedThesis;
import diplomas_mgt_app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssignedThesisDAO extends JpaRepository<AssignedThesis, Integer> {

    public AssignedThesis findById(int theId);
    List<AssignedThesis> findByStudentId(int student_id);
    List<AssignedThesis> findByProfessorId(int professor_id);
    public List<AssignedThesis> findByStudent(Student student);
}
