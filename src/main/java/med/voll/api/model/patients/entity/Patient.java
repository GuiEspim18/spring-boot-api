package med.voll.api.model.patients.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.address.entity.Address;
import med.voll.api.model.patients.PatientUpdateData;
import med.voll.api.model.patients.PatientsData;
import med.voll.api.model.patients.Sex;

import java.util.Date;

@Entity(name = "Patients")
@Table(name = "patients")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String telephone;
    private Date birthdate;
    private boolean active;

    @Embedded
    private Address address;

    public Patient (PatientsData patient) {
        this.name = patient.name();
        this.email = patient.email();
        this.telephone = patient.telephone();
        this.cpf = patient.cpf();
        this.sex = patient.sex();
        this.birthdate = patient.birthdate();
        this.active = true;
        this.address = new Address(patient.address());
    }

    public void updateData(PatientUpdateData patient) {
        if (patient.name() != null) {
            this.name = patient.name();
        }
        if (patient.email() != null) {
            this.email = patient.email();
        }
        if (patient.telephone() != null) {
            this.telephone = patient.telephone();
        }
        if (patient.address() != null) {
            this.address.updateData(patient.address());
        }
    }

    public void inactive() {
        this.active = false;
    }
}
