package med.voll.api.controller;

import med.voll.api.model.patients.ListPatientData;
import med.voll.api.model.patients.PatientsData;
import med.voll.api.model.patients.PatientsDetailsData;
import med.voll.api.model.patients.PatientsRepository;
import med.voll.api.model.patients.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientsRepository repository;

    @GetMapping
    public List<Patient> getAll() {
        List<Patient> page = repository.findAll();
        System.out.println(page);
        return page;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody PatientsData data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        repository.save(patient);
        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientsDetailsData(patient));
    }

}
