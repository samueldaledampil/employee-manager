package samueldale.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import samueldale.organizationservice.dto.OrganizationDto;
import samueldale.organizationservice.entity.Organization;
import samueldale.organizationservice.exception.ResourceNotFoundException;
import samueldale.organizationservice.mapper.AutoOrganizationMapper;
import samueldale.organizationservice.repository.OrganizationRepository;
import samueldale.organizationservice.service.OrganizationService;


@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository repo;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = AutoOrganizationMapper.MAPPER.mapToOrganization(organizationDto);

        Organization savedOrganization = repo.save(organization);

        OrganizationDto savedOrganizationDto = AutoOrganizationMapper.MAPPER.mapToOrganizationDto(savedOrganization);

        return savedOrganizationDto;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = repo.findByOrganizationCode(organizationCode);

        if(organization == null){
            throw new ResourceNotFoundException("Organization", "code", organizationCode);
        }

        return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(organization);

    }

}
