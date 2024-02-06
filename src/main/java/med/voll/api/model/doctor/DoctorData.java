package med.voll.api.model.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.address.AddressData;

public record DoctorData(
        @NotBlank // verify if name is blank or null
        String name,

        @NotBlank
        @Email // validate if is an email
        String email,

        @NotBlank
        String telephone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // verify if contains digits and if contains if contains 4 or 6 digits
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid // validating a address dto
        AddressData address
) {
}
