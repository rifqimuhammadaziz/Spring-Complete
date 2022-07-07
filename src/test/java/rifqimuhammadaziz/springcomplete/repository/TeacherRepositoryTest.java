package rifqimuhammadaziz.springcomplete.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rifqimuhammadaziz.springcomplete.entity.Course;
import rifqimuhammadaziz.springcomplete.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course1 = Course.builder()
                .title("Tutorial Spring Framework")
                .credit(10)
                .build();
        Course course2 = Course.builder()
                .title("Tutorial Laravel")
                .credit(8)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Bayu")
                .lastName("Prasetyo")
//                .courses(List.of(course1, course2))
                .build();
        teacherRepository.save(teacher);
    }

}