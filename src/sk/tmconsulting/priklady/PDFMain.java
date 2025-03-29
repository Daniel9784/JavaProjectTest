package sk.tmconsulting.priklady;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class PDFMain
{
    public static void main(String[] args)
    {
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();

            // novy format som nastavil

            BaseFont baseFont = BaseFont.createFont("resources/fonts/FreeSans.otf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 12, Font.NORMAL);

            document.add(new Paragraph("A Hello World PDF document.", font));
            document.add(new Paragraph("ľščťžýáíé", font));
            document.close();
            writer.close();

        // upravil som vynimky
        } catch (DocumentException | IOException e)
        {
            e.printStackTrace();
        }
    }
}