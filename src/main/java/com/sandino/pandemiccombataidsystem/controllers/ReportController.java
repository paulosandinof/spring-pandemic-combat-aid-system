package com.sandino.pandemiccombataidsystem.controllers;

import com.sandino.pandemiccombataidsystem.dtos.ReportDTO;
import com.sandino.pandemiccombataidsystem.services.ReportService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/reports")
public class ReportController {
    
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ReportDTO index() {
        return reportService.generate();
    }
}
