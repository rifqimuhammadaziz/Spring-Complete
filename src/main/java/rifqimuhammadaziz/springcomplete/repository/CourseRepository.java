package rifqimuhammadaziz.springcomplete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springcomplete.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
