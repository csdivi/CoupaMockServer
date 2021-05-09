package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Requisitions {
    @JsonProperty("requisition-headers")
    RequisitionHeaders headers = new RequisitionHeaders();
}
