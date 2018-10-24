package meet.doctor.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@PrimaryKeyClass
public class DoctorKey {

    @PrimaryKeyColumn(type = PARTITIONED)
    private String id;

    @PrimaryKeyColumn(type = CLUSTERED, ordinal = 0)
    private String country;

    @PrimaryKeyColumn(type = CLUSTERED, ordinal = 1)
    private String city;

    @PrimaryKeyColumn(type = CLUSTERED, ordinal = 2)
    private String district;

}