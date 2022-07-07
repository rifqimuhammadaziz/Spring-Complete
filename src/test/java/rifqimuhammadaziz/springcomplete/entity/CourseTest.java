package rifqimuhammadaziz.springcomplete.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rifqimuhammadaziz.springcomplete.repository.CourseRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void saveCourse() {
        Course course = Course.builder()
                .title("Java Fundamentals")
                .credit(6)
                .build();
        repository.save(course);
    }

    @Test
    public void printCourses() {
        List<Course> courses = repository.findAll();
        System.out.println(courses);
        for (Course course : courses) {
            System.out.println(course);
        }
    }

}