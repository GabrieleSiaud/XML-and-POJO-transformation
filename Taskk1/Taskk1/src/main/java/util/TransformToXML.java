package util;

import modal.Student;
import modal.Subject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Klase isvedanti studento informacija
 * Transformuoja duomenis is POJO i XML
 * Duomenis transformuoja is serverio gauto XML failo
 */

public class TransformToXML {
    public static void main(String[] args) throws JAXBException {

        //POJO informacija
        Student student = new Student();
        student.setName("Gabriele");
        student.setId(100);

        Subject subjects = new Subject();
        Subject subject1 = new Subject("Matematika", "Jonas Petrauskas");
        Subject subject2 = new Subject("Fizika", "Rūta Jankauskaitė");
        Subject subject3 = new Subject("Chemija", "Marius Kazlauskas");
        Subject subject4 = new Subject("Biologija", "Monika Žukauskaitė");
        Subject subject5 = new Subject("Informatika", "Andrius Miknevičius");
        Subject subject6 = new Subject("Istorija", "Justina Markeviciūtė");
        Subject subject7 = new Subject("Literatūra", "Vaidotas Naujokaitis");
        Subject subject8 = new Subject("Ekonomika", "Irina Slapšytė");
        Subject subject9 = new Subject("Psichologija", "Raimonda Žukauskienė");
        Subject subject10 = new Subject("Socialiniai mokslai", "Edgaras Jankauskas");

        student.setSubjects(Arrays.asList(subject1, subject2, subject3, subject4, subject5,
                subject6, subject7, subject8, subject9, subject10));

        //Transformacija i XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter xmlWriter = new StringWriter();
        marshaller.marshal(student, xmlWriter);
        System.out.println(xmlWriter.toString());
    }
}
