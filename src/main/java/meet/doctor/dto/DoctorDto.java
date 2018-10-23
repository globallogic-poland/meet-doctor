package meet.doctor.dto;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class DoctorDto {

    String id;

    String firstName;

    String lastName;
    
    String district;

    String city;

    String country;

    @Singular
    Set<Specialization> specializations;

}
