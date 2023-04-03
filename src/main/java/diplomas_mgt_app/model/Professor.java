package diplomas_mgt_app.model;


import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor {

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

    @Column(name="specialty")
    private String specialty;

    // define constructors

    public Professor() {

    }
    public Professor(int id, String firstName, String lastName, String email, String specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialty = specialty;
    }

    public Professor(String firstName, String lastName, String email, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialty = specialty;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", specialty='" + specialty + '\'' + '}';
    }
}
