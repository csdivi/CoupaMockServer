package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Approval {
    Id id;
    @JsonProperty("created-at")
    TimeStamp createdAt;
    @JsonProperty("updated-at")
    TimeStamp updatedAt;
    Approver approver;
}
