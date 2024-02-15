package med.voll.api.domain.appointment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentData(
        Long doctor_id,

        @NotNull
        Long patient_id,

        @NotNull
        @Future
        LocalDateTime appointment_date
) {
}
