package rifqimuhammadaziz.springcomplete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rifqimuhammadaziz.springcomplete.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByDepartmentName(String departmentName);
    Department findDepartmentByDepartmentNameIgnoreCase(String departmentName);
}