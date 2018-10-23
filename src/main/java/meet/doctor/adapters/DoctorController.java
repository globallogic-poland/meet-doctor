package meet.doctor.adapters;

import lombok.AllArgsConstructor;
import meet.doctor.dto.DoctorDto;
import meet.doctor.ports.DoctorStorage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
public class DoctorController {

    private final DoctorStorage doctorStorage;

    private final DoctorTransformer doctorTransformer;

    @GetMapping(path = "/doctors", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<DoctorDto> getAll() {
        return doctorStorage.findAll()
                .map(doctorTransformer::toDto);
    }
}
