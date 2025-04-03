package cz.uhk.pro2_f.service;

import cz.uhk.pro2_f.model.Course;
import cz.uhk.pro2_f.model.Lecturer;
import cz.uhk.pro2_f.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public void saveLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer getLecturer(long id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        lecturerRepository.deleteById(id);
    }
}
