package diplomas_mgt_app.model;

import javax.persistence.*;

@Entity
@Table(name="assignedthesis")
public class AssignedThesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;


    @Column(name = "implementation_grade")
    private Double implementationgrade;


    @Column(name = "report_grade")
    private Double reportgrade;

    @Column(name = "presentation_grade")
    private Double presentationgrade;

    @Column(name = "total_grade")
    private Double totalgrade;


    public AssignedThesis(int id, String title, Student student, Professor professor) {
        this.id = id;
        this.title = title;
        this.student = student;
        this.professor = professor;
    }

    public AssignedThesis(int id, String title, Student student, Professor professor, Double implementationgrade, Double reportgrade, Double presentationgrade, Double totalgrade) {
        this.id = id;
        this.title = title;
        this.student = student;
        this.professor = professor;
        this.implementationgrade = implementationgrade;
        this.reportgrade = reportgrade;
        this.presentationgrade = presentationgrade;
        this.totalgrade = totalgrade;
    }

    public AssignedThesis() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Double getImplementationgrade() {
        return implementationgrade;
    }

    public void setImplementationgrade(Double implementationgrade) {
        this.implementationgrade = implementationgrade;
    }

    public Double getReportgrade() {
        return reportgrade;
    }

    public void setReportgrade(Double reportgrade) {
        this.reportgrade = reportgrade;
    }

    public Double getPresentationgrade() {
        return presentationgrade;
    }

    public void setPresentationgrade(Double presentationgrade) {
        this.presentationgrade = presentationgrade;
    }

    public Double getTotalgrade() {
        return totalgrade;
    }

    public void setTotalgrade(Double totalgrade) {
        this.totalgrade = totalgrade;
    }
}
