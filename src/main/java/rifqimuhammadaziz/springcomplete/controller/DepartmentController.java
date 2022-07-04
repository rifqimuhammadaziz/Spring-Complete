package rifqimuhammadaziz.springcomplete.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springcomplete.entity.Department;
import rifqimuhammadaziz.springcomplete.error.DepartmentNotFoundException;
import rifqimuhammadaziz.springcomplete.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department with id " + departmentId + " successfully deleted.";
    }

    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{departmentName}")
    public Department fetchDepartmentByName(@PathVariable String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
