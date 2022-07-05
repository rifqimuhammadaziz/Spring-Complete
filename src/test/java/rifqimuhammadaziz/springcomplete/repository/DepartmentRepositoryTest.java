package rifqimuhammadaziz.springcomplete.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rifqimuhammadaziz.springcomplete.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Sistem Cerdas")
                .departmentAddress("Indonesia")
                .departmentCode("SC-001")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findDepartmentByDepartmentNameIgnoreCase("Sistem Cerdas");
        assertEquals(department.getDepartmentName(), "Sistem Cerdas");
    }
}