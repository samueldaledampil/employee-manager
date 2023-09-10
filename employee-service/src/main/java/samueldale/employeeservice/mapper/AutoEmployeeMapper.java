package samueldale.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import samueldale.employeeservice.dto.EmployeeDto;
import samueldale.employeeservice.entity.Employee;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);

}
