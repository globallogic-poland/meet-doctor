package meet.doctor.adapters;

import lombok.AllArgsConstructor;
import meet.doctor.dto.DoctorDto;
import meet.doctor.model.Doctor;
import meet.doctor.ports.DoctorBindings;
import meet.doctor.ports.DoctorStorage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import reactor.core.publisher.Flux;

import static meet.doctor.ports.DoctorBindings.DOCTOR_CREATE_REQUESTS;
import static meet.doctor.ports.DoctorBindings.DOCTOR_CREATE_RESULTS;

@AllArgsConstructor
@EnableBinding(DoctorBindings.class)
public class DoctorProcessor {

    private final DoctorStorage doctorStorage;

    private final DoctorTransformer doctorTransformer;

    @StreamListener
    @Output(DOCTOR_CREATE_RESULTS)
    public Flux<DoctorDto> insert(@Input(DOCTOR_CREATE_REQUESTS) Flux<DoctorDto> doctorFlux) {
        Flux<Doctor> doctorPublisher = doctorFlux
                .map(doctorTransformer::fromDto)
                .log();
        return doctorStorage.insert(doctorPublisher)
                .map(doctorTransformer::toDto)
                .log();
    }

}
