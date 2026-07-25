package org.example.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.BondInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BondExcelExporter {

    public static void export(
            List<BondInfo> bonds,
            String fileName
    ) throws IOException {


        Workbook workbook = new XSSFWorkbook();

        Sheet sheet =
                workbook.createSheet("Bonds");


        String[] headers = {
                "Ticker",
                "Название",
                "ISIN",
                "FIGI",
                "Валюта",
                "Номинал",
                "Цена без НКД",
                "Полная цена",
                "НКД",
                "Купонов в год",
                "Дата погашения",
                "Страна риска",
                "Сектор",
                "Риск"
        };


        Row header = sheet.createRow(0);


        for (int i = 0; i < headers.length; i++) {
            header.createCell(i)
                    .setCellValue(headers[i]);
        }


        int rowIndex = 1;


        for (BondInfo bond : bonds) {

            Row row =
                    sheet.createRow(rowIndex++);


            row.createCell(0)
                    .setCellValue(bond.getTicker());

            row.createCell(1)
                    .setCellValue(bond.getName());

            row.createCell(2)
                    .setCellValue(bond.getIsin());

            row.createCell(3)
                    .setCellValue(bond.getFigi());

            row.createCell(4)
                    .setCellValue(bond.getCurrency());

            row.createCell(5)
                    .setCellValue(bond.getNominal());

            row.createCell(6)
                    .setCellValue(bond.getCleanPrice());

            row.createCell(7)
                    .setCellValue(bond.getDirtyPrice());

            row.createCell(8)
                    .setCellValue(bond.getAccruedCoupon());

            row.createCell(9)
                    .setCellValue(bond.getCouponsPerYear());

            row.createCell(10)
                    .setCellValue(
                            bond.getMaturityDate()
                                    .toString()
                    );

            row.createCell(11)
                    .setCellValue(
                            bond.getCountryOfRisk()
                    );

            row.createCell(12)
                    .setCellValue(
                            bond.getSector()
                    );

            row.createCell(13)
                    .setCellValue(
                            bond.getRiskLevel()
                    );
        }


        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }


        try (FileOutputStream out =
                     new FileOutputStream(fileName)) {

            workbook.write(out);
        }

        workbook.close();
    }

}
