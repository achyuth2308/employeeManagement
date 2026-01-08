package com.alpha.employeeManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.DTO.PayrollResponseDTO;
import com.alpha.employeeManagement.Entity.Payroll;
import com.alpha.employeeManagement.Repository.PayrollRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PayslipPdfService {

    @Autowired
    private PayrollService payrollService;
    
    @Autowired
    private PayrollRepository payrollRepository;

    // ================= SINGLE MONTH =================

    public void generatePayslipPdf(
            int employeeId,
            String month,
            int year,
            HttpServletResponse response) throws Exception {

        PayrollResponseDTO p =
                payrollService.generatePayroll(employeeId, month, year);

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        addCompanyHeader(document);
        addMonthTitle(document, p);
        addEmployeeDetails(document, p);
        addSalaryTable(document, p);
        addNetPaySection(document, p);
        addFooter(document);

        document.close();
    }

    // ================= MULTI MONTH =================

    public void generateMultiMonthPayslipPdf(
            int employeeId,
            HttpServletResponse response) throws Exception {

        List<PayrollResponseDTO> payrolls =
                payrollService.getWorkedMonthsPayroll(employeeId);

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        addCompanyHeader(document);

        for (PayrollResponseDTO p : payrolls) {

            addMonthTitle(document, p);
            addEmployeeDetails(document, p);
            addSalaryTable(document, p);
            addNetPaySection(document, p);

            document.add(new Paragraph("\n\n"));
        }

        addFooter(document);
        document.close();
    }

    // ================= HEADER =================

    private void addCompanyHeader(Document document) throws Exception {

        Font companyFont = new Font(Font.HELVETICA, 14, Font.BOLD);
        Font subFont = new Font(Font.HELVETICA, 10);

        Paragraph company = new Paragraph(
                "PRIYANSH TECHNOLOGIES",
                companyFont
        );
        company.setAlignment(Element.ALIGN_CENTER);

        Paragraph address = new Paragraph(
                "Hyderabad, Telangana, India",
                subFont
        );
        address.setAlignment(Element.ALIGN_CENTER);

        Paragraph title = new Paragraph(
                "PAY SLIP",
                new Font(Font.HELVETICA, 12, Font.BOLD)
        );
        title.setAlignment(Element.ALIGN_CENTER);

        document.add(company);
        document.add(address);
        document.add(new Paragraph("\n"));
        document.add(title);
        document.add(new Paragraph("\n"));
    }

    // ================= MONTH TITLE =================

    private void addMonthTitle(Document document,
                               PayrollResponseDTO p) throws Exception {

        Font font = new Font(Font.HELVETICA, 12, Font.BOLD);

        Paragraph title = new Paragraph(
                "Payslip for " + p.getMonth() + " - " + p.getYear(),
                font
        );
        title.setAlignment(Element.ALIGN_CENTER);

        document.add(title);
        document.add(new Paragraph("\n"));
    }

    // ================= EMPLOYEE DETAILS =================

    private void addEmployeeDetails(Document document,
                                    PayrollResponseDTO p) throws Exception {

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);

        addCell(table, "Employee Name", true);
        addCell(table, p.getEmployeeName(), false);
        addCell(table, "Employee ID", true);
        addCell(table, String.valueOf(p.getEmployeeId()), false);

        addCell(table, "Designation", true);
        addCell(table, p.getRole(), false);
        addCell(table, "Department", true);
        addCell(table, p.getRole(), false);

        addCell(table, "Bank Name", true);
        addCell(table, p.getBankName(), false);
        addCell(table, "IFSC Code", true);
        addCell(table, p.getIfscCode(), false);

        addCell(table, "Month / Year", true);
        addCell(table, p.getMonth() + " / " + p.getYear(), false);
        addCell(table, "Account No", true);
        addCell(table, p.getPfUanNumber(), false);

        document.add(table);
        document.add(new Paragraph("\n"));
    }

    // ================= SALARY TABLE =================

    private void addSalaryTable(Document document,
                                PayrollResponseDTO p) throws Exception {

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);

        addHeaderCell(table, "EARNINGS");
        addHeaderCell(table, "AMOUNT (₹)");
        addHeaderCell(table, "DEDUCTIONS");
        addHeaderCell(table, "AMOUNT (₹)");

        addCell(table, "Basic Salary", false);
        addCell(table, String.valueOf(p.getBasicSalary()), false);
        addCell(table, "Provident Fund", false);
        addCell(table, String.valueOf(p.getPf()), false);

        addCell(table, "HRA", false);
        addCell(table, String.valueOf(p.getHra()), false);
        addCell(table, "Other Deductions", false);
        addCell(table, String.valueOf(p.getDeductions()), false);

        addCell(table, "Bonus", false);
        addCell(table, String.valueOf(p.getBonus()), false);
        addCell(table, "", false);
        addCell(table, "", false);

        addHeaderCell(table, "GROSS SALARY");
        addHeaderCell(table, String.valueOf(p.getGrossSalary()));
        addHeaderCell(table, "TOTAL DEDUCTIONS");
        addHeaderCell(table, String.valueOf(p.getDeductions()));

        document.add(table);
    }

    // ================= NET PAY =================

    private void addNetPaySection(Document document,
                                  PayrollResponseDTO p) throws Exception {

        Font font = new Font(Font.HELVETICA, 14, Font.BOLD);

        Paragraph netPay = new Paragraph(
                "\nNET PAY : ₹ " + p.getNetSalary(),
                font
        );
        netPay.setAlignment(Element.ALIGN_RIGHT);

        document.add(netPay);
    }

    // ================= FOOTER =================

    private void addFooter(Document document) throws Exception {

        Font font = new Font(Font.HELVETICA, 9, Font.ITALIC);

        Paragraph footer = new Paragraph(
                "\nThis is a system generated payslip. No signature required.",
                font
        );
        footer.setAlignment(Element.ALIGN_CENTER);

        document.add(footer);
    }

    // ================= COMMON CELLS =================

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

    private void addHeaderCell(PdfPTable table,
                               String text) {

        Font font = new Font(Font.HELVETICA, 10, Font.BOLD);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(6);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }
    
    

}
