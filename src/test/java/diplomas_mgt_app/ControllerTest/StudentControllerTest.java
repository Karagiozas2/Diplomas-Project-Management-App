package diplomas_mgt_app.ControllerTest;
import diplomas_mgt_app.controller.StudentController;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;
import diplomas_mgt_app.model.Subject;
import diplomas_mgt_app.model.Thesis;
import diplomas_mgt_app.service.ApplicationService;
import diplomas_mgt_app.service.StudentService;
import diplomas_mgt_app.service.SubjectService;
import diplomas_mgt_app.service.ThesisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @MockBean
    private ApplicationService applicationService;

    @MockBean
    private SubjectService subjectService;

    @MockBean
    private ThesisService thesisService;

    @BeforeEach
    public void setup() {
        // Given
        Student student = new Student();
        student.setId(1);
        student.setUsername("testUser");
        List<Student> students = Collections.singletonList(student);

        Mockito.when(studentService.findAll()).thenReturn(students);
    }

    @Test
    public void listStudents_ShouldAddStudentEntriesToModelAndRenderListView() throws Exception {
        // When and Then
        mockMvc.perform(get("/Students/list-students"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("students"))
                .andExpect(view().name("Students/list-students"));
    }
    @Test
    public void saveStudent_ShouldSaveStudentAndRedirectToSigninView() throws Exception {
        // Given
        Student student = new Student();
        student.setId(1);
        student.setUsername("testUser");

        // When
        mockMvc.perform(post("/Students/save").flashAttr("student", student))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/auth/signin"));

        // Then
        Mockito.verify(studentService, Mockito.times(1)).saveProfile(student);
    }
    @Test
    public void testGetStudentMainMenu() throws Exception {
        Student student = new Student();
        student.setUsername("testUser");

        Authentication auth = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(auth.getName()).thenReturn("testUser");

        Mockito.when(studentService.findByUsername("testUser")).thenReturn(student);

        mockMvc.perform(get("/Students/mainMenu"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("student"))
                .andExpect(view().name("Students/main-menu"));
    }

    @Test
    public void testListSubject() throws Exception {
        Subject subject = new Subject();
        List<Subject> subjects = Collections.singletonList(subject);
        Mockito.when(subjectService.findAll()).thenReturn(subjects);

        mockMvc.perform(get("/Students/listSubjects"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("subjects"))
                .andExpect(view().name("Students/list-subjects"));
    }

    @Test
    public void testListThesis() throws Exception {
        Thesis thesis = new Thesis();
        List<Thesis> theses = Collections.singletonList(thesis);
        Mockito.when(thesisService.findBySubjectId(1)).thenReturn(theses);

        mockMvc.perform(get("/Students/listThesis/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("theses"))
                .andExpect(view().name("Students/list-theses"));
    }

    @Test
    public void testApplyForThesis() throws Exception {
        Thesis thesis = new Thesis();
        Mockito.when(thesisService.findById(1)).thenReturn(thesis);

        Student student = new Student();
        student.setUsername("testUser");

        Application application = new Application(student, thesis);
        application.setStatus("pending");

        Mockito.when(studentService.findByUsername("testUser")).thenReturn(student);
        mockMvc.perform(get("/Students/apply/Thesis/{thesisId}", 1))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/Students/mainMenu"));

        // verify
        Mockito.verify(applicationService, Mockito.times(1)).save(Mockito.any(Application.class));
        Mockito.verify(studentService, Mockito.times(1)).saveProfile(Mockito.any(Student.class));
    }

    @Test
    public void testListStudentApplications() throws Exception {
        Application application = new Application();
        List<Application> applications = Collections.singletonList(application);
        Mockito.when(studentService.listStudentApplications(1)).thenReturn(applications);

        mockMvc.perform(get("/Students/listApplications/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("applications"))
                .andExpect(view().name("Students/list-applications"));
    }
}