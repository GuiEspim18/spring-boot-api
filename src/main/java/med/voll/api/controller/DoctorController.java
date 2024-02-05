package med.voll.api.controller;

import med.voll.api.model.doctor.DoctorData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void post(@RequestBody DoctorData json) {
        System.out.println(json);
    }

}
