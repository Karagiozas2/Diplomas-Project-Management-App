package diplomas_mgt_app.controller;

import diplomas_mgt_app.model.*;
import diplomas_mgt_app.service.ApplicationService;
import diplomas_mgt_app.service.StudentService;
import diplomas_mgt_app.service.SubjectService;
import diplomas_mgt_app.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/Students")
    public class StudentController{


    @Autowired
    private StudentService studentService;
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ThesisService thesisService;

    @Autowired
    public StudentController(StudentService theStudentService, SubjectService theSubjectService,ApplicationService theApplicationService,ThesisService theThesisService) {
        studentService = theStudentService;
        subjectService = theSubjectService;
        applicationService = theApplicationService;
        thesisService = theThesisService;
    }


    @RequestMapping("/list-students")
    public String listStudents(Model theModel) {

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);

        return "Students/list-students";
    }

    @RequestMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent){
        studentService.saveProfile(theStudent);

        return "auth/signin";
    }
    @RequestMapping("/mainMenu")
    public String getStudentMainMenu(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentStudentUsername = authentication.getName();

        Student currentStudent = studentService.findByUsername(currentStudentUsername);

        model.addAttribute("student", currentStudent);

        return "Students/main-menu";
    }

    @RequestMapping("/listSubjects")
    public String listSubject(Model model) {

        List<Subject> subjects = subjectService.findAll();

        model.addAttribute("subjects", subjects);

        return "Students/list-subjects";
    }

    @RequestMapping("/listThesis/{subjectId}")
    public String listThesis(@PathVariable("subjectId") Integer thesisId, Model model) {

        List<Thesis> theses = thesisService.findBySubjectId(thesisId);

        model.addAttribute("theses", theses);

        return "Students/list-theses";
    }

    @RequestMapping("/apply/Thesis/{thesisId}")
    public String applyForThesis(@PathVariable("thesisId") Integer thesisId, Model model, Principal principal) {

        Thesis thesis = thesisService.findById(thesisId);

        Student student = studentService.findByUsername(principal.getName());


        Application application = new Application(student, thesis);
        application.setStudent(student);
        application.setThesis(thesis);
        application.setStatus("pending");

        applicationService.save(application);

        return "redirect:/Students/mainMenu";
    }
    @RequestMapping("/listApplications/{studentId}")
    public String listStudentApplications(@PathVariable int studentId, Model model) {
        List<Application> applications = studentService.listStudentApplications(studentId);
        model.addAttribute("applications", applications);

        return "Students/list-applications";
    }

}