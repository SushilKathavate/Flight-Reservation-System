package com.org.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

public class PdfService {

    public void generateTicketPdf(String filePath, String ticketDetails) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Ticket Details"));
        document.add(new Paragraph(ticketDetails));
        document.close();
    }
}
