package diplomas_mgt_app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student")
public class Student {
    // define fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="year_of_studies")
    private int yearofstudies;

    @Column(name="current_average_grade")
    private int currentaveragegrade;

    @Column(name="number_of_remaining_courses_for_graduation")
    private int numberofremainingcoursesforgraduation;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Student() {

    }
    public Student(int id, String firstName, String lastName, String email, int yearofstudies, int currentaveragegrade, int numberofremainingcoursesforgraduation, List<Application> applications) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearofstudies = yearofstudies;
        this.currentaveragegrade = currentaveragegrade;
        this.numberofremainingcoursesforgraduation = numberofremainingcoursesforgraduation;
        this.applications = applications;
    }

    public Student(String firstName, String lastName, String email, int yearofstudies, int currentaveragegrade, int numberofremainingcoursesforgraduation, List<Application> applications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearofstudies = yearofstudies;
        this.currentaveragegrade = currentaveragegrade;
        this.numberofremainingcoursesforgraduation = numberofremainingcoursesforgraduation;
        this.applications = applications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearofstudies() {
        return yearofstudies;
    }

    public void setYearofstudies(int yearofstudies) {
        this.yearofstudies = yearofstudies;
    }

    public int getCurrentaveragegrade() {
        return currentaveragegrade;
    }

    public void setCurrentaveragegrade(int currentaveragegrade) {
        this.currentaveragegrade = currentaveragegrade;
    }

    public int getNumberofremainingcoursesforgraduation() {
        return numberofremainingcoursesforgraduation;
    }

    public void setNumberofremainingcoursesforgraduation(int numberofremainingcoursesforgraduation) {
        this.numberofremainingcoursesforgraduation = numberofremainingcoursesforgraduation;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", yearofstudies=" + yearofstudies + ", currentaveragegrade=" + currentaveragegrade + ", numberofremainingcoursesforgraduation=" + numberofremainingcoursesforgraduation + '}';
    }
}
