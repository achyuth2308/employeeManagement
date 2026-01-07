package com.alpha.employeeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.DTO.PayrollResponseDTO;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PayslipPdfService {

    @Autowired
    private PayrollService payrollService;

    public void generatePayslipPdf(int id, String month, int year,
                                   HttpServletResponse response) throws Exception {

        // Fetch payroll data
        PayrollResponseDTO payslip =
                payrollService.generatePayroll(id, month, year);

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        addTitle(document);
        addEmployeeDetails(document, payslip);
        addSalaryDetails(document, payslip);
        addNetSalary(document, payslip);

        document.close();
    }

    // PDF HELPER METHODS

    private void addTitle(Document document) throws Exception {
        Font font = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("MONTHLY PAY SLIP", font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph("\n"));
    }

    private void addEmployeeDetails(Document document, PayrollResponseDTO p) throws Exception {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        table.addCell("Employee Name");
        table.addCell(p.getEmployeeName());

        table.addCell("Employee ID");
        table.addCell(String.valueOf(p.getEmployeeId()));

        table.addCell("Role");
        table.addCell(p.getRole());

        table.addCell("Bank Name");
        table.addCell(p.getBankName());

        table.addCell("IFSC Code");
        table.addCell(p.getIfscCode());

        table.addCell("Month / Year");
        table.addCell(p.getMonth() + " / " + p.getYear());

        document.add(table);
        document.add(new Paragraph("\n"));
    }

    private void addSalaryDetails(Document document, PayrollResponseDTO p) throws Exception {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        table.addCell("Basic Salary");
        table.addCell(String.valueOf(p.getBasicSalary()));

        table.addCell("HRA");
        table.addCell(String.valueOf(p.getHra()));

        table.addCell("Bonus");
        table.addCell(String.valueOf(p.getBonus()));

        table.addCell("Gross Salary");
        table.addCell(String.valueOf(p.getGrossSalary()));

        table.addCell("PF Deduction");
        table.addCell(String.valueOf(p.getPf()));

        table.addCell("Total Deductions");
        table.addCell(String.valueOf(p.getDeductions()));

        document.add(table);
    }

    private void addNetSalary(Document document, PayrollResponseDTO p) throws Exception {
        Font font = new Font(Font.HELVETICA, 14, Font.BOLD);

        Paragraph netPay = new Paragraph(
                "\nNET SALARY : ₹ " + p.getNetSalary(),
                font
        );

        netPay.setAlignment(Element.ALIGN_RIGHT);
        document.add(netPay);
    }
}
