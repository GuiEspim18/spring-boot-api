package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentDetailsData(
        Long id,
        Long doctor_id,
        Long patient_id,
        LocalDateTime appointment_date
) {
}
