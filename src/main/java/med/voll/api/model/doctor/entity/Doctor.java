package med.voll.api.model.doctor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.address.entity.Address;
import med.voll.api.model.doctor.DoctorData;
import med.voll.api.model.doctor.DoctorUpdateData;
import med.voll.api.model.doctor.Specialty;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter // setting the getters methods
@NoArgsConstructor // creating a constructor without args
@AllArgsConstructor // creating a constructor with all args
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String crm;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded // we use embedded to add a class address in database without needing to create an address class.
    private Address address;

    public Doctor(DoctorData data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void updateData(DoctorUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.telephone() != null) {
            this.telephone = data.telephone();
        }
        if (data.address() != null) {
            this.address.updateData(data.address());
        }
    }

    public void inactive() {
        this.active = false;
    }
}
