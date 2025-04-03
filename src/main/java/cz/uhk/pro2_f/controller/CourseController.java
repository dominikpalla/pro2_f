package cz.uhk.pro2_f.controller;

import cz.uhk.pro2_f.model.Course;
import cz.uhk.pro2_f.service.CourseService;
import cz.uhk.pro2_f.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;
    private LecturerService lecturerService;

    @Autowired
    public CourseController(CourseService courseService, LecturerService lecturerService) {
        this.courseService = courseService;
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses_list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        model.addAttribute("course", new Course());
        model.addAttribute("edit", false);
        return "courses_add";
    }

    @PostMapping("/add")
    public String addSave(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses/";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id) {
        model.addAttribute("course", courseService.getCourse(id));
        return "courses_detail";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("edit", true);
        return "courses_add";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("course", courseService.getCourse(id));
        return "courses_delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        courseService.delete(id);
        return "redirect:/courses/";
    }
}
