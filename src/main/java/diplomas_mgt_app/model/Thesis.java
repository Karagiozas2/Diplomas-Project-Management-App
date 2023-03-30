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

    @Column(name = "professor_id")
    private String professor_id;

    //constructors
    public Thesis() {

    }

    public Thesis(int id, String title, String objectives, String professor_id) {
        this.id = id;
        this.title = title;
        this.objectives = objectives;
        this.professor_id = professor_id;
    }


    public Thesis(String title, String objectives, String professor_id) {
        this.title  = title;
        this.objectives = objectives;
        this.professor_id = professor_id;
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

    public String getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }
    // tostring
    @Override
    public String toString() {
        return "Thesis{" + "id=" + id + ", title='" + title + '\'' + ", objectives='" + objectives + '\'' + ", professor_id='" + professor_id + '\'' + '}';
    }
}
