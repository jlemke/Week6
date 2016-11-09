package gov.weather;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Created by Joe on 11/9/2016.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        String response = binding.latLonListZipCode("53711");

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));

        String result = dwml.getLatLonList();

        assertEquals("Result did not match.", "43.0798,-89.3875", result);
    }

}