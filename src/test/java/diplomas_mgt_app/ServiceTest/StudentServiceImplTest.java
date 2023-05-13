package diplomas_mgt_app.ServiceTest;

import diplomas_mgt_app.dao.ApplicationDAO;
import diplomas_mgt_app.dao.StudentDAO;
import diplomas_mgt_app.dao.SubjectDAO;
import diplomas_mgt_app.model.Application;
import diplomas_mgt_app.model.Student;
import diplomas_mgt_app.model.Subject;
import diplomas_mgt_app.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private ApplicationDAO applicationDAO;

    @Mock
    private SubjectDAO subjectDAO;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        when(studentDAO.findAll()).thenReturn(Collections.singletonList(new Student()));
        List<Student> students = studentService.findAll();
        assertEquals(1, students.size());
    }

    @Test
    public void testFindByUsername() {
        Student student = new Student();
        studentService.saveProfile(student);
        when(studentDAO.findByUsername(anyString())).thenReturn(student);
        Student result = studentService.findByUsername("username");
        assertNotNull(result);
    }

    @Test
    public void testSaveProfile() {
        Student student = new Student();
        studentService.saveProfile(student);
        verify(studentDAO, times(1)).save(student);
    }


    @Test
    public void testListStudentSubjects() {
        Subject subj1 = new Subject();
        Subject subj2 = new Subject();
        List<Subject> mockSubjects = Arrays.asList(subj1, subj2);

        when(subjectDAO.findAll()).thenReturn(mockSubjects);

        List<Subject> subjects = studentService.listStudentSubjects();

        assertNotNull(subjects);
        assertEquals(2, subjects.size());
    }




}