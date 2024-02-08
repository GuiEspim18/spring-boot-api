package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.patients.*;
import med.voll.api.domain.patients.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientsRepository repository;

    @GetMapping
    public ResponseEntity<Page<ListPatientData>> getAll(@PageableDefault(size = 10, page = 0, sort = { "name" }) Pageable pageable) {
        Page<ListPatientData> page = repository.findAllByActiveTrue(pageable).map(ListPatientData::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid PatientsData data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        repository.save(patient);
        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientsDetailsData(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id) {
        var patient = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientsDetailsData(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PatientUpdateData data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);
        return ResponseEntity.ok(new PatientsDetailsData(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id) {
        var patient = repository.getReferenceById(id);
        patient.inactive();
        return ResponseEntity.noContent().build();
    }

}
