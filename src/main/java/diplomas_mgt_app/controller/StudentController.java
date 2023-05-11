package diplomas_mgt_app.controller;

import diplomas_mgt_app.model.Student;
import diplomas_mgt_app.service.StudentService;
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
@RequestMapping("/Students")
    public class StudentController{


    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }
    // add mapping for "/list"

    @RequestMapping("/list-students")
    public String listStudents(Model theModel) {

        // get student from db
        List<Student> theStudents = studentService.findAll();

        // add to the spring model
        theModel.addAttribute("students", theStudents);

        return "Students/list-students";
    }

    @RequestMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent){
        /*
         *  @ModelAttribute("student") -  this is how to get
         *  a reference to the object holding the data entered
         *  in a form.
         *  https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-ann-modelattrib
         *
         */

        // save the professor
        studentService.saveProfile(theStudent);

        return "auth/signin";
    }
    @RequestMapping("/mainMenu")
    public String getStudentMainMenu(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentStudentUsername = authentication.getName();

        // Fetch the professor using the username
        Student currentStudent = studentService.findByUsername(currentStudentUsername);

        // Add the professor to the model
        model.addAttribute("student", currentStudent);

        // Redirect to the main menu view
        return "Students/main-menu";
    }



}