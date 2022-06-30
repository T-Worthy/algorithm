package _USEFUL.pdf;


import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;

    public class pdf_word2 {

        public static void main(String[] args) {
            String pdfPath =  "D:\\myCode\\output\\pic\\c.doc";

            try {
                PDDocument document = Loader.loadPDF(FileUtils.readFileToByteArray( new File("C:\\Users\\61434\\Desktop\\b.pdf")));
                int pageNum = document.getNumberOfPages();
                pdfPath = pdfPath.substring(0, pdfPath.lastIndexOf("."));
                String fileName = pdfPath+".doc";
                File file = new File(fileName);
                if(!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(file);
                Writer writer = new OutputStreamWriter(fos,"UTF-8");
                PDFTextStripper stripper = new PDFTextStripper();
                PDFTextStripper textStripper = new PDFTextStripper();
                textStripper.setSortByPosition(true);
                textStripper.setStartPage(1);
                textStripper.setEndPage(pageNum);
                textStripper.writeText(document,writer);
                writer.close();
                document.close();

                System.out.println("转换成功");

            } catch (IOException e) {
                e.printStackTrace();
            }


        }



}
