package meet.doctor.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table
public class Doctor {

    @PrimaryKey
    private DoctorKey key;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Singular
    @Column
    private Set<String> specializations;

}
