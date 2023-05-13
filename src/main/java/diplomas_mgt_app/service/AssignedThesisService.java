package diplomas_mgt_app.service;

import diplomas_mgt_app.model.AssignedThesis;
import diplomas_mgt_app.model.Professor;

import java.util.List;

public interface AssignedThesisService {
    void save(AssignedThesis assignedThesis);
    AssignedThesis findById(int theId);
    List<AssignedThesis> findAll();

    List<AssignedThesis> findbyProfessorId(Integer professorId);
}