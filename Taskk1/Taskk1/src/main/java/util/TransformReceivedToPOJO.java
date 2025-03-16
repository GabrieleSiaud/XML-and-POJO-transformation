package util;

import modal.Student;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Klase isvedanti studento informacija
 * Transformuoja XML duomenis i POJO ir juos isveda i terminala
 * Duomenis transformuoja is serverio gauto XML failo
 */

public class TransformReceivedToPOJO {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("received_studentas.xml");
            File xsdFile = new File("src/main/resources/student.xsd");

            XMLValidator.validateXML(xmlFile, xsdFile);

            JAXBTransformer pojo = new JAXBTransformer();
            Student student = pojo.transformToPOJO(xmlFile);

            System.out.println("Student object: " + student);
        } catch (JAXBException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
