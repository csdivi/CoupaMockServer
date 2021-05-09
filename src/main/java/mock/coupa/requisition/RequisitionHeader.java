package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequisitionHeader {
    Id id;
    @JsonProperty("created-at")
    TimeStamp createdAt;
    @JsonProperty("updated-at")
    TimeStamp updatedAt;
    @JsonProperty("submitted-at")
    TimeStamp submittedAt;
    Total total;
    @JsonProperty("requisition-description")
    String requisitionDescription;
    @JsonProperty("requestors-cost-center")
    String requestorsCostCenter;

    Currency currency;

    @JsonProperty("requested-by")
    User requestedBy;

    @JsonProperty("requisition-lines")
    RequisitionLines requisitionLines;

    @JsonProperty("current-approval")
    Approval currentApproval;

}
