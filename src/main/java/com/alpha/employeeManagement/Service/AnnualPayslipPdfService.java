package com.alpha.employeeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.DTO.AnnualSalaryDTO;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class AnnualPayslipPdfService {

    @Autowired
    private AnnualSalaryService annualSalaryService;

    public void generateAnnualPayslipPdf(int id,
                                         int year,
                                         HttpServletResponse response) throws Exception {

        AnnualSalaryDTO annual = annualSalaryService
                .calculateAnnualSalary(id, year);

        response.setContentType("application/pdf");
        response.setHeader(
                "Content-Disposition",
                "inline; filename=annual-payslip-" + year + ".pdf"
        );

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        addHeader(document, year);
        addAnnualSummary(document, annual);
        addNetPay(document, annual);
        addFooter(document);

        document.close();
    }

    // ---------------- HEADER ----------------
    private void addHeader(Document document, int year) throws Exception {
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);

        Paragraph title = new Paragraph(
                "ANNUAL PAY SLIP - " + year,
                titleFont
        );
        title.setAlignment(Element.ALIGN_CENTER);

        document.add(title);
        document.add(new Paragraph("\n"));
    }

    // ---------------- SUMMARY TABLE ----------------
    private void addAnnualSummary(Document document,
                                  AnnualSalaryDTO a) throws Exception {

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        addCell(table, "Year", true);
        addCell(table, String.valueOf(a.getYear()), false);

        addCell(table, "Total Gross Salary", true);
        addCell(table, "₹ " + a.getTotalGrossSalary(), false);

        addCell(table, "Total Deductions", true);
        addCell(table, "₹ " + a.getTotalDeductions(), false);

        document.add(table);
        document.add(new Paragraph("\n"));
    }

    // ---------------- NET PAY ----------------
    private void addNetPay(Document document,
                            AnnualSalaryDTO a) throws Exception {

        Font font = new Font(Font.HELVETICA, 14, Font.BOLD);

        Paragraph netPay = new Paragraph(
                "NET ANNUAL SALARY : ₹ " + a.getTotalNetSalary(),
                font
        );
        netPay.setAlignment(Element.ALIGN_RIGHT);
        document.add(netPay);
    }

    // ---------------- FOOTER ----------------
    private void addFooter(Document document) throws Exception {
        Font font = new Font(Font.HELVETICA, 9, Font.ITALIC);

        Paragraph footer = new Paragraph(
                "\nThis is a system generated annual payslip.",
                font
        );
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);
    }

    // ---------------- COMMON CELL ----------------
    private void addCell(PdfPTable table,
                         String text,
                         boolean bold) {

        Font font = bold
                ? new Font(Font.HELVETICA, 10, Font.BOLD)
                : new Font(Font.HELVETICA, 10);

        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(6);
        table.addCell(cell);
    }
}
