package med.voll.api.model.doctor;

import med.voll.api.model.address.Address;

public record DoctorData(
        String name,
        String email,
        String crm,
        Specialty specialty,
        Address address
) {
}
