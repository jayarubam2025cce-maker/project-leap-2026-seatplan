package com.example.seatplan.service;

import com.example.seatplan.entity.Exam;
import com.example.seatplan.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    public Exam updateExam(Long id, Exam exam) {
        Exam existingExam = examRepository.findById(id).orElse(null);

        if (existingExam != null) {
            existingExam.setExamName(exam.getExamName());
            existingExam.setExamDate(exam.getExamDate());

            return examRepository.save(existingExam);
        }

        return null;
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}