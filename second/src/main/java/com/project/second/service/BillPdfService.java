package com.project.second.service;

import com.project.second.entity.Order;
import org.springframework.stereotype.Service;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.project.second.entity.OrderItems;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class BillPdfService {

    public String generatePdf(Order order)
    {
        if (order == null) {
            return "Order cannot be null";
        }

            String fileName;
        try {
            fileName = "bill_" + order.getId() + ".pdf";
        } catch (Exception e) {
            return "error creating filename" + e.getMessage();
        }

            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileName));
            }
            catch(DocumentException e)
            {
                return "error initializing pdf writer "+ e.getMessage();
            } catch (FileNotFoundException e) {
                return "file not found" + e.getMessage();
            }

            try {
                document.open();
            }
            catch(Exception e)
            {
                return "Error opening document "+e.getMessage();
            }

            try {
                Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);

                Paragraph title = new Paragraph("Restaurant Bill", font);

                title.setAlignment(Paragraph.ALIGN_CENTER);

                document.add(title);

                document.add(new Paragraph(" "));

                document.add(new Paragraph("Table No: " + order.getTable_no()));

                document.add(new Paragraph("Waiter: " + order.getWaiter()));

                document.add(new Paragraph(" "));
            } catch (DocumentException e) {
                return "error adding order details" + e.getMessage();
            }

            try {
                for (OrderItems item : order.getItems()) {

                    document.add(new Paragraph("Dish: " + item.getDish().getDish_name()));

                    document.add(new Paragraph("Quantity: " + item.getQuantity()));

                    document.add(new Paragraph("Price: " + item.getPrice()));

                    document.add(new Paragraph(" "));
                }
            } catch (Exception e) {
                return "error adding item details " + e.getMessage();
            }

            try {
                document.add(new Paragraph("Total Bill: " + order.getTotal()));
            } catch (DocumentException e) {
                return "error adding the total bill" + e.getMessage();
            }

            try {
                document.close();
            } catch (Exception e) {
                return "error closing the document "+e.getMessage();
            }

            return "PDF Generated Successfully";


    }
}
