package schoolApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import schoolApp.entity.Student;

import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

}
