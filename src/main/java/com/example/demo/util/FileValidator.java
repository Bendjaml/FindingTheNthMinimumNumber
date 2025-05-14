package com.example.demo.util;

import org.springframework.web.multipart.MultipartFile;

public class FileValidator {
    public static void validate(MultipartFile file, int n) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Файл не был загружен");
        }

        if (!file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            throw new IllegalArgumentException("Поддерживаются только файлы XLSX формата");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("N должно быть положительным числом");
        }
    }
}