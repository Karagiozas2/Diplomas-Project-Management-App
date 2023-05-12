package diplomas_mgt_app.model;
import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "thesis_id")
    private Thesis thesis;

    @Column(name = "status")
    private String status;

    public Application(Student student, Thesis thesis, String status) {
        this.student = student;
        this.thesis = thesis;
        this.status = status;
    }

    public Application(int id, Student student1, Thesis thesis) {
        this.id = id;
        this.student = student1;
        this.thesis = thesis;
    }


    public Application(Student student1, Thesis thesis) {
        this.student = student1;
        this.thesis = thesis;
    }

    public Application() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", student=" + student +
                ", thesis=" + thesis +
                ", status='" + status + '\'' +
                '}';
    }
}