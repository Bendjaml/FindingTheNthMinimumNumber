package com.example.demo.service;

import com.example.demo.util.FileValidator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.PriorityQueue;

@Service
public class NumberService {

    public int findNthMinFromXlsx(MultipartFile file, int n) throws IOException {
        FileValidator.validate(file, n);

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    int num = (int) cell.getNumericCellValue();

                    if (maxHeap.size() < n) {
                        maxHeap.offer(num);
                    } else if (num < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(num);
                    }
                }
            }

            if (maxHeap.size() < n) {
                throw new IllegalArgumentException("Файл содержит меньше " + n + " чисел");
            }

            return maxHeap.peek();
        }
    }
}