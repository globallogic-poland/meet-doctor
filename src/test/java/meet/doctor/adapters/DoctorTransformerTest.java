package meet.doctor.adapters;

import meet.doctor.dto.DoctorDto;
import meet.doctor.model.Doctor;
import org.junit.jupiter.api.Test;

import static meet.doctor.DevData.DOCTOR;
import static meet.doctor.DevData.DOCTOR_DTO;
import static org.assertj.core.api.Assertions.assertThat;

class DoctorTransformerTest {

    private final DoctorTransformer doctorTransformer = new DoctorTransformer();

    @Test
    void shouldTransformToDto() {
        DoctorDto result = doctorTransformer.toDto(DOCTOR);
        assertThat(result)
                .isEqualTo(DOCTOR_DTO);
    }

    @Test
    void shouldTransformFromDto() {
        Doctor result = doctorTransformer.fromDto(DOCTOR_DTO);
        assertThat(result)
                .isEqualTo(DOCTOR);
    }
}