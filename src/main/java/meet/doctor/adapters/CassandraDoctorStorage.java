package meet.doctor.adapters;

import lombok.AllArgsConstructor;
import meet.doctor.model.Doctor;
import meet.doctor.model.DoctorKey;
import meet.doctor.ports.DoctorRepository;
import meet.doctor.ports.DoctorStorage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CassandraDoctorStorage implements DoctorStorage {

    private final DoctorRepository doctorRepository;

    @Override
    public Mono<Doctor> findById(DoctorKey id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Flux<Doctor> insert(Flux<Doctor> doctorFlux) {
        return doctorRepository.insert(doctorFlux.map(this::applyId));
    }

    @Override
    public Flux<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    private Doctor applyId(Doctor doctor) {
        doctor.getKey().setId(UUID.randomUUID().toString());
        return doctor;
    }
}
