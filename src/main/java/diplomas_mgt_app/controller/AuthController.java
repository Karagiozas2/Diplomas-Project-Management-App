package diplomas_mgt_app.controller;

import diplomas_mgt_app.model.Professor;
import diplomas_mgt_app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import diplomas_mgt_app.model.User;
import diplomas_mgt_app.model.Role;
import diplomas_mgt_app.service.UserService;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "auth/signin";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/signup";
    }

    @RequestMapping("/save")
    public String registerUser(@ModelAttribute("user") User user, Model model){

        if(userService.isUserPresent(user)){
            model.addAttribute("successMessage", "User already registered!");
            return "auth/signin";
        }

        userService.saveUser(user);
        model.addAttribute("successMessage", "User registered successfully!");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("role", user.getRole());

        if(user.getRole().equals(Role.Professor)) {

            Professor theProfessor = new Professor();
            theProfessor.setUsername(user.getUsername());

            model.addAttribute("professor", theProfessor);
            return "Professors/professor-form";

        } else if (user.getRole().equals(Role.Student)) {

            Student theStudent = new Student();
            theStudent.setUsername(user.getUsername());

            model.addAttribute("student", theStudent);
            return "Students/student-form";

        } else {
            return "auth/signin";
        }
    }
}