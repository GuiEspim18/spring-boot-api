package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.doctor.*;
import med.voll.api.model.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired // dependencies injection
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid DoctorData data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        repository.save(doctor);
        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailsData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListDataDoctor>> getAll (@PageableDefault(size = 10, page = 0, sort = { "name" }) Pageable pageable) {
        Page<ListDataDoctor> page = repository.findAllByActiveTrue(pageable).map(ListDataDoctor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update (@RequestBody @Valid DoctorUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);

        return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.inactive();

        return ResponseEntity.noContent().build();
    }

}
