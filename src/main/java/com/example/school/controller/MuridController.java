package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.repository.MuridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/murid")
public class MuridController {

    @Autowired
    private MuridRepository muridRepository;

    @PostMapping
    public Student createMurid(@RequestBody Student student) {
        return muridRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllMurid() {
        return muridRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getMuridById(@PathVariable String id) {
        return muridRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Murid not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Student updateMurid(@PathVariable String id, @RequestBody Student updatedStudent) {
        return muridRepository.findById(id)
                .map(existingMurid -> {
                    existingMurid.setNama(updatedStudent.getNama());
                    existingMurid.setKelas(updatedStudent.getKelas());
                    existingMurid.setUmur(updatedStudent.getUmur());
                    return muridRepository.save(existingMurid);
                })
                .orElseThrow(() -> new NoSuchElementException("Murid not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteMurid(@PathVariable String id) {
        muridRepository.deleteById(id);
        return "Murid dengan id " + id + " berjaya dipadam.";
    }
}
