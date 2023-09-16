package samueldale.organizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samueldale.organizationservice.dto.OrganizationDto;
import samueldale.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService service;

    @PostMapping("create")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto savedOrganization = service.saveOrganization(organizationDto);

       return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organization-code") String organizationCode){

        OrganizationDto organizationDto = service.getOrganizationByCode(organizationCode);

        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }

}
