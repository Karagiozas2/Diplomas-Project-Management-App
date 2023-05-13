package diplomas_mgt_app.service;

import diplomas_mgt_app.model.Subject;
import java.util.List;
import java.util.Optional;

public interface SubjectService {

    void save(Subject subject);

    public List<Subject> findAll();

    Subject findById(Integer id);
}