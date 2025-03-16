package modal;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;

/**
 * Klase anotuojanti paskaitu informacija
 * Nustatomi laukai: paskaitos ir destytojai
 * Atvaizduoja paskaitu informacija
 */

@ToString
public class Subject {
    private String lesson;
    private String teacher;

    public Subject() {
    }

    public Subject(String lesson, String teacher) {
        this.lesson = lesson;
        this.teacher = teacher;
    }

    @XmlElement
    public String getLesson() {
        return lesson;
    }

    @XmlElement
    public String getTeacher() {
        return teacher;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "\n\tLesson: " + lesson +
               "\n\tTeacher: " + teacher;
    }
}
