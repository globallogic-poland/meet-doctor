package meet.doctor.ports;

import meet.doctor.model.Doctor;
import meet.doctor.model.DoctorKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DoctorStorage {

    Mono<Doctor> findById(DoctorKey id);

    Flux<Doctor> insert(Flux<Doctor> patientFlux);

    Flux<Doctor> findAll();

}
