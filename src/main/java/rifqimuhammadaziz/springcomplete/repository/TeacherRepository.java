package rifqimuhammadaziz.springcomplete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springcomplete.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
