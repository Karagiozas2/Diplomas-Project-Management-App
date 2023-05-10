package diplomas_mgt_app.model;

import javax.persistence.*;

@Entity
@Table(name="thesis")
public class Thesis {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="objectives")
    private String objectives;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    //constructors
    public Thesis() {

    }

    public Thesis(int id, String title, String objectives, Professor professor,Subject subject) {
        this.id = id;
        this.title = title;
        this.objectives = objectives;
        this.professor = professor;
        this.subject = subject;
    }


    public Thesis(String title, String objectives, Professor professor,Subject subject) {
        this.title  = title;
        this.objectives = objectives;
        this.professor = professor;
        this.subject = subject;
    }

    //getter-setter

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

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public Subject getSubject() {
        return subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    // tostring

    @Override
    public String toString() {
        return "Thesis{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", objectives='" + objectives + '\'' +
                ", professor='" + professor + '\'' +
                ", subject=" + subject +
                '}';
    }
}
