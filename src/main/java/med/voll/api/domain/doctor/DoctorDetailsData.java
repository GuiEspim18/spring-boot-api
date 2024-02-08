package med.voll.api.domain.doctor;

import med.voll.api.domain.address.entity.Address;
import med.voll.api.domain.doctor.entity.Doctor;

public record DoctorDetailsData(
        Long id,
        String name,
        String email,
        String telephone,
        String crm,
        Specialty specialty,
        Address address
) {

    public DoctorDetailsData (Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelephone(), doctor.getCrm(), doctor.getSpecialty(), doctor.getAddress());
    }

}
