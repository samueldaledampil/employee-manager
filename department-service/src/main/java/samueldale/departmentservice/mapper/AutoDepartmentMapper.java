package samueldale.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import samueldale.departmentservice.dto.DepartmentDto;
import samueldale.departmentservice.entity.Department;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);

}
