package diplomas_mgt_app.controller;

import diplomas_mgt_app.model.*;
import diplomas_mgt_app.model.strategies.BestApplicantStrategy;
import diplomas_mgt_app.model.strategies.BestApplicantStrategyFactory;
import diplomas_mgt_app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/Professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ThesisService thesisService;

    @Autowired
    private AssignedThesisService assignedThesisService;

    @Autowired
    public ProfessorController(ProfessorService theProfessorService,SubjectService theSubjectService,ApplicationService theApplicationService) {
        professorService = theProfessorService;
        subjectService = theSubjectService;
        applicationService =theApplicationService;
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
        return "auth/signin";
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

        // Fetch the professor using the username
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

    @RequestMapping("/listTheses")
    public String listProfessorTheses(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();

        List<Thesis> theses = professorService.listProfessorTheses(currentProfessorUsername);
        model.addAttribute("theses", theses);

        return "Professors/list-theses";
    }

    @RequestMapping("/showThesisForm")
    public String showThesisForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();
        Professor currentProfessor = professorService.findByUsername(currentProfessorUsername);

        Thesis thesis = new Thesis();
        thesis.setProfessor(currentProfessor);

        model.addAttribute("thesis", thesis);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);

        return "Professors/thesis-form";

    }
    @RequestMapping(value = "/addThesis", method = RequestMethod.POST)
    public String addThesis(@ModelAttribute("thesis") Thesis thesis, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();

        Professor currentProfessor = professorService.retrieveProfile(currentProfessorUsername);

        professorService.addThesis(currentProfessorUsername, thesis);

        return "redirect:/Professors/listTheses";
    }

    @RequestMapping(value = "/deleteThesis")
    public String deleteThesis(@RequestParam("thesisId") Integer thesisId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentProfessorUsername = authentication.getName();

        thesisService.delete(thesisId);

        return "redirect:/Professors/listTheses";
    }


    @RequestMapping("/listApplications")
    public String listApplications(@RequestParam("thesisId") Integer thesisId, Model model) {
        List<Application> applications = applicationService.findAllByThesisId(thesisId);
        model.addAttribute("applications", applications);
        model.addAttribute("thesisId", thesisId);
        return "Professors/list-applications";
    }
    @RequestMapping("/assignThesis")
    public String assignThesis(@RequestParam("applicationId") Integer applicationId, Model model) {
        Application application = applicationService.findById(applicationId);
        if (application != null && Objects.equals(application.getStatus(), "pending")) {
            application.setStatus("Accepted");
            applicationService.save(application);

            AssignedThesis assignedThesis = new AssignedThesis();
            assignedThesis.setTitle(application.getThesis().getTitle());
            assignedThesis.setStudent(application.getStudent());
            assignedThesis.setProfessor(application.getThesis().getProfessor());
            assignedThesis.setImplementationgrade(0.0);
            assignedThesis.setReportgrade(0.0);
            assignedThesis.setPresentationgrade(0.0);
            assignedThesis.setTotalgrade(0.0);

            assignedThesisService.save(assignedThesis);
        }
        return "redirect:/Professors/mainMenu";
    }
    @RequestMapping("/assignedTheseslist")
    public String listAssignedThesesList(@RequestParam("id") Integer professorId,Model model) {

        List<AssignedThesis> assignedTheses = assignedThesisService.findbyProfessorId(professorId);

        model.addAttribute("assignedTheses", assignedTheses);

        return "Professors/list-assignedtheses";
    }
    @RequestMapping("/declineThesis")
    public String declineThesis(@RequestParam("applicationId") Integer applicationId, Model model) {
        Application application = applicationService.findById(applicationId);
        if (application != null && Objects.equals(application.getStatus(), "pending")) {
            application.setStatus("Declined");
            applicationService.save(application);
        }
        return "redirect:/Professors/mainMenu";
    }
    @RequestMapping(value = "/addGrade/implementation", method = RequestMethod.GET)
    public String showAddImplementationGradeForm(@RequestParam("id") Integer id, Model model) {

        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        model.addAttribute("assignedThesis", assignedThesis);

        return "Professors/implementationGradeForm";
    }

    @RequestMapping(value = "/addGrade/implementation/save", method = RequestMethod.POST)
    public String saveImplementationGrade(@RequestParam("id") Integer id, @RequestParam("grade") Double grade,Model model) {
        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        assignedThesis.setImplementationgrade(grade);
        assignedThesisService.save(assignedThesis);

        List<AssignedThesis> assignedTheses = assignedThesisService.findAll();
        model.addAttribute("assignedTheses", assignedTheses);
        return "Professors/list-assignedtheses";
    }
    @RequestMapping(value = "/addGrade/report", method = RequestMethod.GET)
    public String showAddReportGradeForm(@RequestParam("id") Integer id, Model model) {

        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        model.addAttribute("assignedThesis", assignedThesis);

        return "Professors/reportGradeForm";
    }


    @RequestMapping(value = "/addGrade/report/save", method = RequestMethod.POST)
    public String saveReportGrade(@RequestParam("id") Integer id, @RequestParam("grade") Double grade,Model model) {
        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        assignedThesis.setReportgrade(grade);
        assignedThesisService.save(assignedThesis);

        List<AssignedThesis> assignedTheses = assignedThesisService.findAll();
        model.addAttribute("assignedTheses", assignedTheses);
        return "Professors/list-assignedtheses";
    }

    @RequestMapping(value = "/addGrade/presentation", method = RequestMethod.GET)
    public String showAddPresentationGradeForm(@RequestParam("id") Integer id, Model model) {

        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        model.addAttribute("assignedThesis", assignedThesis);

        return "Professors/presentationGradeForm";
    }


    @RequestMapping(value = "/addGrade/presentation/save", method = RequestMethod.POST)
    public String savePresentationGrade(@RequestParam("id") Integer id, @RequestParam("grade") Double grade,Model model) {
        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        assignedThesis.setPresentationgrade(grade);
        assignedThesisService.save(assignedThesis);

        List<AssignedThesis> assignedTheses = assignedThesisService.findAll();
        model.addAttribute("assignedTheses", assignedTheses);
        return "Professors/list-assignedtheses";
    }


    @RequestMapping(value = "/calculateGrade", method = RequestMethod.GET)
    public String CalculateGrade(@RequestParam("id") Integer id, Model model) {

        AssignedThesis assignedThesis = assignedThesisService.findById(id);
        double implementationGrade = assignedThesis.getImplementationgrade();
        double reportGrade = assignedThesis.getReportgrade();
        double presentationgrade = assignedThesis.getPresentationgrade();
        double totalgrade = 0.7 * implementationGrade + 0.15 * presentationgrade + 0.15 * reportGrade;
        BigDecimal bd = new BigDecimal(Double.toString(totalgrade));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        totalgrade = bd.doubleValue();

        assignedThesis.setTotalgrade(totalgrade);

        assignedThesisService.save(assignedThesis);

        List<AssignedThesis> assignedTheses = assignedThesisService.findAll();
        model.addAttribute("assignedTheses", assignedTheses);

        return "Professors/list-assignedtheses";
    }

    @RequestMapping (value = "/selectStrategy", method = RequestMethod.POST)
    public String selectStrategy(@RequestParam("strategy") String strategy, @RequestParam("thesisId") Integer thesisId, Model model, RedirectAttributes redirectAttributes) {
        if ("ThresholdApplicantStrategy".equals(strategy)) {
            redirectAttributes.addAttribute("thesisId", thesisId);
            return "redirect:/Professors/inputThresholds";
        }
        BestApplicantStrategyFactory factory = new BestApplicantStrategyFactory();
        BestApplicantStrategy bestApplicantStrategy = factory.createStrategy(strategy);

        List<Application> applications = applicationService.findAllByThesisId(thesisId);
        Student bestStudent = bestApplicantStrategy.findBestApplicant(applications);

        redirectAttributes.addFlashAttribute("bestStudent", bestStudent);

        return "redirect:/Professors/listApplications?thesisId=" + thesisId;
    }

    @RequestMapping("/inputThresholds")
    public String inputThresholds(@RequestParam("thesisId") Integer thesisId, Model model) {
        model.addAttribute("thesisId", thesisId);
        return "Professors/input-thresholds";
    }

    @RequestMapping(value = "/processThresholds", method = RequestMethod.POST)
    public String processThresholds(@RequestParam("th1") double th1, @RequestParam("th2") double th2, @RequestParam("thesisId") Integer thesisId, Model model, RedirectAttributes redirectAttributes) {
        BestApplicantStrategyFactory factory = new BestApplicantStrategyFactory();
        BestApplicantStrategy bestApplicantStrategy = factory.createThresholdStrategy(th1, th2);

        List<Application> applications = applicationService.findAllByThesisId(thesisId);
        Student bestStudent = bestApplicantStrategy.findBestApplicant(applications);

        redirectAttributes.addFlashAttribute("bestStudent", bestStudent);

        return "redirect:/Professors/listApplications?thesisId=" + thesisId;
    }
}
