package med.voll.api.model.doctor;

import med.voll.api.model.address.AddressData;

public record DoctorData(
        String name,
        String email,
        String crm,
        Specialty specialty,
        AddressData address
) {
}
