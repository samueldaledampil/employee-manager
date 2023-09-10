package samueldale.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import samueldale.departmentservice.dto.DepartmentDto;
import samueldale.departmentservice.entity.Department;
import samueldale.departmentservice.exception.ResourceNotFoundException;
import samueldale.departmentservice.mapper.AutoDepartmentMapper;
import samueldale.departmentservice.repository.DepartmentRepository;
import samueldale.departmentservice.service.DepartmentService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository repo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //Convert department DTO to department JPA entity
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = repo.save(department);

        //Convert JPA entity to department dto
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = repo.findByDepartmentCode(departmentCode);

        if(department == null){
            throw new ResourceNotFoundException("Department", "code", departmentCode);
        }

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }


}
