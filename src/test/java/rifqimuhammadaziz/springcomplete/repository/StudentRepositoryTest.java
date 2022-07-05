package rifqimuhammadaziz.springcomplete.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import rifqimuhammadaziz.springcomplete.entity.Guardian;
import rifqimuhammadaziz.springcomplete.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("rifqi@gmail.com")
                .firstName("Rifqi")
                .lastName("Muhammad Aziz")
//                .guardianName("Xenosty")
//                .guardianEmail("xenosty@gmail.com")
//                .guardianMobile("081902401999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Antos")
                .email("antos@gmail.com")
                .mobile("081902401999")
                .build();

        Student student = Student.builder()
                .emailId("bagas@gmail.com")
                .firstName("Bagas")
                .lastName("Dwi Yulianto")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void printAllStudent() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Bagas");
        System.out.println(students);
    }

    @Test
    void printStudentByGuardianName() {
        List<Student> students = studentRepository.findStudentByGuardianName("Antos");
        System.out.println(students);
    }

    @Test
    void printStudentByFirstNameAndLastName() {
        Student students = studentRepository.findByFirstNameAndLastName("Bagas", "Dwi Yulianto");
        System.out.println(students);
    }

    @Test
    void printStudentByEmailAddress() {
        Student student = studentRepository.findByEmailAddress("bagas@gmail.com");
        System.out.println(student);
    }

    @Test
    void printStudentFirstNameByEmailAddress() {
        String student = studentRepository.findStudentFirstNameByEmailAddress("bagas@gmail.com");
        System.out.println(student);
    }

    @Test
    void printStudentByEmailAddressNative() {
        Student student = studentRepository.findStudentByEmailAddressNative("bagas@gmail.com");
        System.out.println(student);
    }

    @Test
    void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.findStudentByEmailAddressNativeNamedParam("bagas@gmail.com");
        System.out.println(student);
    }

    @Test
    void updateStudentNameByEmailAddress() {
        studentRepository.updateStudentNameByEmailId("Rifqi", "bagas@gmail.com");
    }
}