package diplomas_mgt_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import diplomas_mgt_app.service.ProfessorService;
import diplomas_mgt_app.model.Professor;

import java.util.List;

@Controller
@RequestMapping("/Professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService theProfessorService) {
        professorService = theProfessorService;
    }
    // add mapping for "/list"

    @RequestMapping("/list-professors")
    public String listProfessors(Model theModel) {

        // get professor from db
        List<Professor> theProfessors = professorService.findAll();

        // add to the spring model
        theModel.addAttribute("professors", theProfessors);

        return "Professors/list-professors";
    }

}
