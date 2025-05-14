package com.example.demo.controller;

import com.example.demo.service.NumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Tag(name = "Number Operations", description = "API для работы с числами из XLSX файлов")
public class NumberController {

    private final NumberService numberService;

    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping(value = "/findNthMin", consumes = "multipart/form-data")
    @Operation(summary = "Найти N-ное минимальное число из XLSX файла")
    public ResponseEntity<?> findNthMin(
            @RequestPart("file") MultipartFile file,
            @RequestParam("n") int n) {
        try {
            int result = numberService.findNthMinFromXlsx(file, n);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}