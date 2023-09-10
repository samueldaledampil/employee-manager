package samueldale.departmentservice.service;

import samueldale.departmentservice.dto.DepartmentDto;

import java.util.Optional;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);

}
