package diplomas_mgt_app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Thesis> theses;


    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    public Subject() {

    }

    public Subject(int id, String name, String description, List<Thesis> theses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.theses = theses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Thesis> getTheses() {
        return theses;
    }

    public void setTheses(List<Thesis> theses) {
        this.theses = theses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", theses=" + theses +
                '}';
    }

    public void save(Professor professor) {
    }
}