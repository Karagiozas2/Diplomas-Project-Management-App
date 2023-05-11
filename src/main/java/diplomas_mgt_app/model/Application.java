package diplomas_mgt_app.model;
import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
    private List<Application> applications;
    public Application() {
    }

    public Application(Student student, Thesis thesis, String status) {
        this.student = student;
        this.thesis = thesis;
        this.status = status;
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