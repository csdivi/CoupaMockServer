package mock.coupa.requisition;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Id {
    @JacksonXmlProperty(isAttribute=true)
    @Builder.Default String type = "integer";
    @JacksonXmlText
    int value;
}
