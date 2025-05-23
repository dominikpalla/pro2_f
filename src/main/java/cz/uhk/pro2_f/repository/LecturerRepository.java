package cz.uhk.pro2_f.repository;

import cz.uhk.pro2_f.model.Lecturer;
import cz.uhk.pro2_f.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

}
