package samueldale.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private Long id;
    //    @NotEmpty(message = "First name is required")
    private String organizationName;
    //    @NotEmpty(message = "First name is required")
    private String organizationDescription;
    //    @NotEmpty(message = "First name is required")
    private String organizationCode;
    private LocalDateTime createdDate;

}
