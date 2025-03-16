package modal;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Klase anotuojanti studento informacija
 * Nustatomi laukai: studento vardas, id ir paskaitos
 * Atvaizduoja studento informacija
 */

@ToString
@XmlRootElement(name = "student")
@XmlType(propOrder={"name", "id", "subjects"})
public class Student {
    private String name;
    private int id;
    private List<Subject> subjects;

    public Student() {
    }

    public Student(String name, int id, List<Subject> subjects) {
        this.name = name;
        this.id = id;
        this.subjects = subjects;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElementWrapper(name = "subjects")
    @XmlElement(name = "subject")
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "STUDENT:" +
                "\nname: " + name +
                "\nid: " + id +
                "\n\nSUBJECTS" + subjects;
    }
}
