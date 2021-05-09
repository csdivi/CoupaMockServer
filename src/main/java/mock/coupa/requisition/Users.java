package mock.coupa.requisition;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Users {
    @JacksonXmlProperty(isAttribute=true)
    @Builder.Default String type = "array";
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("user")
    public List<User> userList;
}
