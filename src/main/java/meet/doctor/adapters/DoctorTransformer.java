package meet.doctor.adapters;

import meet.doctor.dto.DoctorDto;
import meet.doctor.dto.Specialization;
import meet.doctor.model.Doctor;
import meet.doctor.model.DoctorKey;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DoctorTransformer {

    public DoctorDto toDto(Doctor doctor) {

        Set<String> specializationsText = doctor.getSpecializations();
        List<Specialization> specializations = specializationsText == null ? Collections.emptyList() :
                specializationsText.stream()
                        .map(Specialization::valueOf)
                        .collect(Collectors.toList());

        DoctorKey key = doctor.getKey();

        return DoctorDto.builder()
                .id(key.getId())
                .country(key.getCountry())
                .city(key.getCity())
                .district(key.getDistrict())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .specializations(specializations)
                .build();
    }

    public Doctor fromDto(DoctorDto doctorDto) {

        Set<Specialization> specializations = doctorDto.getSpecializations();
        List<String> specializationsText = specializations == null ? Collections.emptyList() :
                specializations.stream()
                        .map(Enum::toString)
                        .collect(Collectors.toList());

        DoctorKey doctorKey = DoctorKey.builder()
                .id(doctorDto.getId())
                .country(doctorDto.getCountry())
                .city(doctorDto.getCity())
                .district(doctorDto.getDistrict())
                .build();

        return Doctor.builder()
                .key(doctorKey)
                .firstName(doctorDto.getFirstName())
                .lastName(doctorDto.getLastName())
                .specializations(specializationsText)
                .build();
    }
}
