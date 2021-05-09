package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.sql.Time;

@Getter
@Builder
public class RequisitionLine {
    Id id;
    @JsonProperty("created-at")
    TimeStamp createdAt;
    @JsonProperty("updated-at")
    TimeStamp updatedAt;
    String description;
    Total total;
    @JsonProperty("requisition-description")
    String requisitionDescription;
    Commodity commodity;
}
