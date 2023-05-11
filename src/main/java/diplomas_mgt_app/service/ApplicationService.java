package diplomas_mgt_app.service;

import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Subject;

import java.util.List;

public interface ApplicationService {

    void save(Application application);

    public List<Application> findAll();
}