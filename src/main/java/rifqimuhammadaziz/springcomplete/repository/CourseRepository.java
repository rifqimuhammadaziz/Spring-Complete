package rifqimuhammadaziz.springcomplete.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springcomplete.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findCourseByTitleContaining(String title, Pageable pageable);
}
