package com.itextpdf.kernel.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

public class PdfDocument {

    private PdfWriter writer;

    public PdfDocument(PdfWriter writer) {
        this.writer = writer;
    }

    // Other methods and properties...
}