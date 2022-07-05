package rifqimuhammadaziz.springcomplete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rifqimuhammadaziz.springcomplete.entity.Student;

import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findStudentByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String lastname);

    // JPQL
    @Query("SELECT s from Student s WHERE s.emailId = ?1")
    Student findByEmailAddress(String emailId);

    // JPQL
    @Query("SELECT s.firstName from Student s WHERE s.emailId = ?1")
    String findStudentFirstNameByEmailAddress(String emailId);

    // Native SQL
    @Query(
            value = "SELECT * FROM students s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student findStudentByEmailAddressNative(String emailId);

    // Native SQL Named Param
    @Query(
            value = "SELECT * FROM students s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student findStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE students SET first_name = :firstName WHERE email_address = :emailId",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
