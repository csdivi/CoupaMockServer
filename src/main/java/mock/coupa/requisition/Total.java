package mock.coupa.requisition;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Total {
    @JacksonXmlProperty(isAttribute=true)
    @Builder.Default String type = "decimal";
    @JacksonXmlText
    float amt;
}
