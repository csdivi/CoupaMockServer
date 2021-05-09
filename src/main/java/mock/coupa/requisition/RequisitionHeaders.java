package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RequisitionHeaders {
    @JacksonXmlProperty(isAttribute=true)
    String type = "array";
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("requisition-header")
    public List<RequisitionHeader> requisitionHeader = new ArrayList<>();
}
