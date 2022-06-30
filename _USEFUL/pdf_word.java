package _USEFUL;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.PDFBox;


public class pdf_word {
    public static void main(String[] args) throws IOException {
        PDDocument document = Loader.loadPDF(FileUtils.readFileToByteArray( new File("C:\\Users\\61434\\Desktop\\b.pdf")));
        int pagenumber = document.getNumberOfPages();


        //      String dirName = "D:\pdf\";// 创建目录D:\pdf\a.doc

        String fileName ="D:\\myCode\\output\\pic\\b.txt" ;// 创建文件



        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
        PDFTextStripper stripper = new PDFTextStripper();

        //      doc.addSignature(arg0, arg1, arg2);

        stripper.setSortByPosition(true);//排序
        //stripper.setWordSeparator("");//pdfbox对中文默认是用空格分隔每一个字，通过这个语句消除空格（视频是这么说的）
        stripper.setStartPage(1);//设置转换的开始页
        stripper.setEndPage(pagenumber);//设置转换的结束页
        stripper.writeText(document,writer);
        writer.close();
        document.close();
        System.out.println("pdf转换word成功！");
    }


}
