package meet.doctor.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DoctorBindings {

    String DOCTOR_CREATE_REQUESTS = "doctor-create-requests";
    String DOCTOR_CREATE_RESULTS = "doctor-create-results";

    @Input(DOCTOR_CREATE_REQUESTS)
    SubscribableChannel createDoctorRequests();

    @Output(DOCTOR_CREATE_RESULTS)
    MessageChannel createDoctorResults();
}