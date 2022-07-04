package rifqimuhammadaziz.springcomplete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springcomplete.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByDepartmentName(String departmentName);
    Department findDepartmentByDepartmentNameIgnoreCase(String departmentName);
}
