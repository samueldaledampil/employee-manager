package samueldale.organizationservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private Long id;
    @NotEmpty(message = "Organization name is required")
    private String organizationName;
    @NotEmpty(message = "Organization description is required")
    private String organizationDescription;
    @NotEmpty(message = "Organization code is required")
    private String organizationCode;
    private LocalDateTime createdDate;

}
