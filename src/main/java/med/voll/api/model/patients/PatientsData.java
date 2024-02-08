package med.voll.api.model.patients;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record PatientsData(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        String telephone,

        @NotBlank
        @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
        String cpf,

        @NotNull
        Sex sex,

        @NotBlank
        Date birthdate
) {
}
