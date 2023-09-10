package samueldale.employeeservice.service;

import samueldale.employeeservice.dto.APIResponseDto;
import samueldale.employeeservice.dto.EmployeeDto;
import samueldale.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    APIResponseDto getEmployeeById(Long employeeId);

    void deleteEmployee(Long employeeId);

}
