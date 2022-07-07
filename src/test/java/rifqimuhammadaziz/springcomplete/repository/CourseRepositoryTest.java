package rifqimuhammadaziz.springcomplete.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import rifqimuhammadaziz.springcomplete.entity.Course;
import rifqimuhammadaziz.springcomplete.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Fiqi")
                .lastName("Arifianto")
                .build();
        Course course = Course.builder()
                .title("ReactJS")
                .credit(8)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 3);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println(courses);
        System.out.println("Total Elements : " + totalElements);
        System.out.println("Total Pages : " + totalPages);
    }

    @Test
    void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCredit =
                PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println(courses);
    }

    @Test
    void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findCourseByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println(courses);
    }
}