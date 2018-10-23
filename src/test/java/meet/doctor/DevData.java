package meet.doctor;

import meet.doctor.dto.DoctorDto;
import meet.doctor.dto.Specialization;
import meet.doctor.model.Doctor;
import meet.doctor.model.DoctorKey;

public class DevData {

    public static final DoctorDto DOCTOR_DTO = DoctorDto.builder()
            .id("123")
            .lastName("Smith")
            .firstName("Robert")
            .country("Poland")
            .city("Krakow")
            .district("District1")
            .specialization(Specialization.IMMUNOLOGIST)
            .build();

    public static final Doctor DOCTOR = Doctor.builder()
            .key(DoctorKey.builder()
                    .id("123")
                    .country("Poland")
                    .city("Krakow")
                    .district("District1")
                    .build())
            .lastName("Smith")
            .firstName("Robert")
            .specialization(Specialization.IMMUNOLOGIST.toString())
            .build();

}
