package samueldale.organizationservice.service;

import org.springframework.stereotype.Service;
import samueldale.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);

}
