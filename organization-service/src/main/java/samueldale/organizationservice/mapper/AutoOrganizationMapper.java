package samueldale.organizationservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import samueldale.organizationservice.dto.OrganizationDto;
import samueldale.organizationservice.entity.Organization;

@Mapper
public interface AutoOrganizationMapper {

    AutoOrganizationMapper MAPPER = Mappers.getMapper(AutoOrganizationMapper.class);

    OrganizationDto mapToOrganizationDto(Organization organization);

    Organization mapToOrganization(OrganizationDto organizationDto);

}
