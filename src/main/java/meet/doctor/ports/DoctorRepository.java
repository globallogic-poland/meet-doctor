package meet.doctor.ports;

import meet.doctor.model.Doctor;
import meet.doctor.model.DoctorKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends ReactiveCassandraRepository<Doctor, DoctorKey> {

}
