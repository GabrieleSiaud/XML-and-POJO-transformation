package util;

import modal.Student;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Klase isvedanti studento informacija
 * Transformuoja XML duomenis i POJO ir juos isveda i terminala
 * Duomenis transformuoja is sukurto XML failo
 */

public class TransformToPOJO {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/studentas.xml");

            JAXBTransformer pojo = new JAXBTransformer();
            Student student = pojo.transformToPOJO(xmlFile);

            System.out.println(student);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
