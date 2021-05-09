package mock.coupa.requisition;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Currency {
    @Builder.Default String code = "USD";
}
