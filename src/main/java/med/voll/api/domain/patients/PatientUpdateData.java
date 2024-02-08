package med.voll.api.domain.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String telephone,
        AddressData address
) {
}
