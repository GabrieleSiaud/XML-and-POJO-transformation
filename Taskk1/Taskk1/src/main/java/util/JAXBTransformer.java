package util;

import modal.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Klase konvertuoja XML failus i POJO
 * */

public class JAXBTransformer {
    public Student transformToPOJO(File xmlFile) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Student) unmarshaller.unmarshal(xmlFile);
    }
}
