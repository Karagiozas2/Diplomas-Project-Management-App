package diplomas_mgt_app.service;

import diplomas_mgt_app.model.AssignedThesis;

import java.util.List;

public interface AssignedThesisService {
    void save(AssignedThesis assignedThesis);
    AssignedThesis findById(int theId);
    List<AssignedThesis> findAll();
    // any other required methods
}