package samueldale.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import samueldale.employeeservice.dto.APIResponseDto;
import samueldale.employeeservice.dto.DepartmentDto;
import samueldale.employeeservice.dto.EmployeeDto;
import samueldale.employeeservice.entity.Employee;
import samueldale.employeeservice.exception.EmailAlreadyExistException;
import samueldale.employeeservice.exception.ResourceNotFoundException;
import samueldale.employeeservice.mapper.AutoEmployeeMapper;
import samueldale.employeeservice.repository.EmployeeRepository;
import samueldale.employeeservice.service.APIClient;
import samueldale.employeeservice.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repo;

//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = repo.findByEmail(employeeDto.getEmail());

        if(optionalEmployee.isPresent()){
            throw new EmailAlreadyExistException("Email already in use");
        }

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = repo.save(employee);

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = repo.findAll();

        return employees.stream().map((employee) -> AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = repo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee));
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee existingEmployee = repo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "employeeId", employeeId)
        );

        repo.deleteById(employeeId);
    }
}
