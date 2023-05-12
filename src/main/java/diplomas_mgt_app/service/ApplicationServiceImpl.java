package diplomas_mgt_app.service;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationDAO applicationDAO;

    @Autowired
    public ApplicationServiceImpl(ApplicationDAO theApplicationDAO) {
        applicationDAO = theApplicationDAO;
    }

    @Override
    @Transactional
    public void save(Application application) {
        applicationDAO.save(application);
    }

    @Override
    public List<Application> findAll() {
        return applicationDAO.findAll();
    }
    @Override
    public List<Application> findAllByThesisId(Integer thesisId) {
        return applicationDAO.findAllByThesisId(thesisId);
    }

    @Override
    @Transactional
    public Application findById(Integer id) {
        return applicationDAO.findById(id).orElse(null);
    }

}