package mock.coupa.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.text.SimpleDateFormat;

public class XmlUtil {
    private static XmlMapper XML_MAPPER = new XmlMapper();
    static {
        XML_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        XML_MAPPER.configure( ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );
        XML_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }

    public static String serialize(Object object, String rootElement) throws JsonProcessingException {
        return XML_MAPPER.writer().withRootName(rootElement).writeValueAsString(object);
    }
}
