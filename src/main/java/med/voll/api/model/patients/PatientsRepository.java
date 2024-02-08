package med.voll.api.model.patients;

import med.voll.api.model.patients.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patient, Long> {
}
