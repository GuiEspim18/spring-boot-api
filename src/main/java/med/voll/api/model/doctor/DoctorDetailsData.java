package med.voll.api.model.doctor;

import med.voll.api.model.address.entity.Address;
import med.voll.api.model.doctor.entity.Doctor;

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
