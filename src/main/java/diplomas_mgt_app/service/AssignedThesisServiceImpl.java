package diplomas_mgt_app.service;

import diplomas_mgt_app.dao.AssignedThesisDAO;
import diplomas_mgt_app.model.AssignedThesis;
import diplomas_mgt_app.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssignedThesisServiceImpl implements AssignedThesisService {

    private AssignedThesisDAO assignedThesisDAO;

    @Autowired
    public AssignedThesisServiceImpl(AssignedThesisDAO theAssignedThesisDAO) {
        assignedThesisDAO = theAssignedThesisDAO;
    }

    @Override
    @Transactional
    public void save(AssignedThesis assignedThesis) {
        assignedThesisDAO.save(assignedThesis);
    }

    @Override
    @Transactional
    public AssignedThesis findById(int theId) {
        AssignedThesis result = assignedThesisDAO.findById(theId);

        if (result != null) {
            return result;
        } else {
            // we didn't find the professor
            throw new RuntimeException("Did not find AssignedThesis id - " + theId);
        } }

    @Override
    @Transactional
    public List<AssignedThesis> findAll() {
        return assignedThesisDAO.findAll();
    }

}