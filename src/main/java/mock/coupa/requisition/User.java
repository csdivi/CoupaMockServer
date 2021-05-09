package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    Id id;
    String login;
    String email;
    @JsonProperty("employee-number") String employeeNumber;
    String firstname;
    String lastname;
    String fullname;
    @JsonProperty("avatar-thumb-url")  String avatarThumbUrl;
    @JsonProperty("business-title") String businessTitle;
    @JsonProperty("management-code") String managementCode;
    String company;
    @JsonProperty("cost-center") String costCenter;
    String project;
}
