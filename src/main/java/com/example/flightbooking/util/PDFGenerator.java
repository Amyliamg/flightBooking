package com.example.flightbooking.util;

import com.example.flightbooking.entities.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {
    public void generatePDF(Reservation reservation, String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));  // add elements to the page, find paths
            // write something to the pdf
            document.open();
            document.add(generateTable(reservation));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private PdfPTable generateTable(Reservation reservation) { // helper function to create the format of PDF
        PdfPTable table = new PdfPTable(2);

        // Flight Details
        PdfPCell cell = new PdfPCell(new Phrase("Flight Details")); // I need to use a phrase object
        cell.setColspan(2); // two columns
        table.addCell(cell);

        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());
        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());
        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());
        table.addCell("Departure Date");
        table.addCell(reservation.getFlight().getDateOfDeparture().toString());
        table.addCell("Departure Time");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        // Passenger Details
        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirstName());
        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLastName());
        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());
        table.addCell("Phone");
        table.addCell(reservation.getPassenger().getPhone());

        return table;
    }
}