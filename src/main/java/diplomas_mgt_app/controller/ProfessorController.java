package diplomas_mgt_app.controller;

import diplomas_mgt_app.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import diplomas_mgt_app.service.ProfessorService;
import diplomas_mgt_app.model.Professor;
import org.springframework.web.bind.annotation.RequestMethod;
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
        theModel.addAttribute("professor", theProfessor);


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
        return "redirect:Professors/professor-form";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("professorId") int theId) {

        // delete the professor
        professorService.deleteById(theId);

        // redirect to /professors/list ACTION
        return "redirect:/Professors/list-professors";

    }

    @RequestMapping("/mainMenu")
    public String getProfessorMainMenu(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();

        // Fetch the professor using the email
        Professor currentProfessor = professorService.findByUsername(currentProfessorUsername);

        // Add the professor to the model
        model.addAttribute("professor", currentProfessor);

        // Redirect to the main menu view
        return "Professors/main-menu";
    }

    @RequestMapping("/retrieveProfile")
    public String retrieveProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorEmail = authentication.getName();

        // Fetch the professor using the email
        Professor currentProfessor = professorService.retrieveProfile(currentProfessorEmail);

        // Add the professor to the model
        model.addAttribute("professor", currentProfessor);
        return "Professors/main-menu";
    }

    @RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("professor") Professor professor, Model model) {
        // Implement logic here
        professorService.save(professor);

        // Redirect to the main menu
        return "redirect:/Professors/mainMenu";
    }

    @RequestMapping("/listSubjects")
    public String listProfessorSubject(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();


        List<Subject> subjects = professorService.listProfessorSubjects(currentProfessorUsername);
        model.addAttribute("subjects", subjects);

        return "Professors/list-subjects";
    }

    @RequestMapping("/showSubjectForm")
    public String showSubjectForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();
        Professor currentProfessor = professorService.findByUsername(currentProfessorUsername);

        Subject subject = new Subject();
        subject.setProfessor(currentProfessor);

        model.addAttribute("subject", subject);

        return "Professors/subject-form";
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public String addSubject(@ModelAttribute("subject") Subject subject, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();

        professorService.addSubject(currentProfessorUsername, subject);

        return "redirect:/Professors/listSubjects";
    }

    @RequestMapping("/listApplications")
    public String listApplications(@RequestParam("subjectId") Integer subjectId, Model model) {
        // Implement logic here
        return "";
    }

    @RequestMapping("/assignSubject")
    public String assignSubject(@RequestParam("applicationId") Integer applicationId, Model model) {
        // Implement logic here
        return "";
    }

    @RequestMapping("/listTheses")
    public String listProfessorTheses(Model model) {
        // Implement logic here
        return "";
    }

}
