package samueldale.departmentservice.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samueldale.departmentservice.dto.DepartmentDto;
import samueldale.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService service;

    //Create department REST API
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = service.saveDepartment(departmentDto);

        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    //Get Department by Department Code
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){

        DepartmentDto departmentDto = service.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }


}
