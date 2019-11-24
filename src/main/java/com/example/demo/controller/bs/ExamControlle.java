package com.example.demo.controller.bs;

import com.example.demo.entity.Exam;
import com.example.demo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bs")
public class ExamControlle {
    @Autowired
    private ExamService examService;
    @RequestMapping("exam")
    public String exam(Model model){
        List<Exam> exams=examService.selectAll();
        model.addAttribute("exam",exams);
        return "bs/exam";
    }
}
