package meet.doctor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
@Slf4j
@EnableReactiveCassandraRepositories(basePackages = "meet.doctor.ports")
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpaceName;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    public String[] getEntityBasePackages() {
        return new String[]{"meet.doctor.model"};
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return singletonList(getKeySpaceSpecification());
    }

    private CreateKeyspaceSpecification getKeySpaceSpecification() {
        log.info("Creating {} key space", keySpaceName);
        var createKeyspaceSpecification = CreateKeyspaceSpecification.createKeyspace(keySpaceName);
        var dcr = DataCenterReplication.of("DC1", 1L); // 3L
//        createKeyspaceSpecification.ifNotExists(true).withNetworkReplication(dcr);
        createKeyspaceSpecification.ifNotExists(true).withSimpleReplication(1L);
        return createKeyspaceSpecification;
    }


}
