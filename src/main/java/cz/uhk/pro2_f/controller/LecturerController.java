package cz.uhk.pro2_f.controller;

import cz.uhk.pro2_f.model.Lecturer;
import cz.uhk.pro2_f.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    private LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "lecturers_list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        model.addAttribute("edit", false);
        return "lecturers_add";
    }

    @PostMapping("/add")
    public String addSave(@ModelAttribute Lecturer lecturer) {
        lecturerService.saveLecturer(lecturer);
        return "redirect:/lecturers/";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id) {
        model.addAttribute("lecturer", lecturerService.getLecturer(id));
        return "lecturers_detail";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("lecturer", lecturerService.getLecturer(id));
        model.addAttribute("edit", true);
        return "lecturers_add";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("lecturer", lecturerService.getLecturer(id));
        return "lecturers_delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        lecturerService.delete(id);
        return "redirect:/lecturers/";
    }
}
