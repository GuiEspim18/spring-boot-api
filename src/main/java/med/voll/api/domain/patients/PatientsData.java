package med.voll.api.domain.patients;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

import java.util.Date;

public record PatientsData(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String telephone,

        @NotBlank
//        @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
        String cpf,

        @NotNull
        Sex sex,

        @NotBlank
        Date birthdate,

        @NotNull
        @Valid
        AddressData address
) {
}
