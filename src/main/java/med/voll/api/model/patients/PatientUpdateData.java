package med.voll.api.model.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.address.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String telephone,
        AddressData address
) {
}
