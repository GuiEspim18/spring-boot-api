package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.doctor.DoctorData;
import med.voll.api.model.doctor.DoctorRepository;
import med.voll.api.model.doctor.DoctorUpdateData;
import med.voll.api.model.doctor.ListDataDoctor;
import med.voll.api.model.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired // dependencies injection
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid DoctorData data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<ListDataDoctor> getAll (@PageableDefault(size = 10, page = 0, sort = { "name" }) Pageable pageable) {
        return repository.findAll(pageable).map(ListDataDoctor::new);
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid DoctorUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
