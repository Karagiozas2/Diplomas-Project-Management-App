package diplomas_mgt_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import diplomas_mgt_app.service.ProfessorService;
import diplomas_mgt_app.model.Professor;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Professor theProfessor = new Professor();

        theModel.addAttribute("professor", theProfessor);

        return "Professors/professor-form";
    }


    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("professorId") int theId,
                                    Model theModel) {

        // get the professor from the service
        Professor theProfessor = professorService.findById(theId);

        // set professor as a model attribute to pre-populate the form
        theModel.addAttribute("Professor", theProfessor);


        // send over to our form
        return "Professors/professor-form";
    }


    @RequestMapping("/save")
    public String saveProfessor(@ModelAttribute("professor") Professor theProfessor){
        /*
         *  @ModelAttribute("professor") -  this is how to get
         *  a reference to the object holding the data entered
         *  in a form.
         *  https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-ann-modelattrib
         *
         */

        // save the professor
        professorService.save(theProfessor);

        // redirect to /professors/list ACTION
        return "redirect:/Professors/list-professors";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("professorId") int theId) {

        // delete the professor
        professorService.deleteById(theId);

        // redirect to /professors/list ACTION
        return "redirect:/Professors/list-professors";

    }

}
