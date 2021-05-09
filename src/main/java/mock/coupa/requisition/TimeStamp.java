package mock.coupa.requisition;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class TimeStamp {
    @JacksonXmlProperty(isAttribute=true)
    @Builder.Default String type = "dateTime";
    @JacksonXmlText
    Date date;
}
