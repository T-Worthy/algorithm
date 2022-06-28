package _USEFUL;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import net.coobird.thumbnailator.Thumbnails;



public class pdf_tras
{
    @Test
    void test(String pdfSavePath,String imagePath) throws IOException {
        File newFile = new File(pdfSavePath);
        byte[] bytes = FileUtils.readFileToByteArray(newFile);
        List<byte[]> listByte = pdfToImage(bytes,imagePath);
//        OutputStream oute = new FileOutputStream(new File(imagePath));
//        oute.write(listByte.get(0));
//        oute.flush();
//        oute.close();
    }

    /**
     * PDF转图片
     * @param fileContent PDF文件的二进制流
     * @return 图片文件的二进制流
     */
    public  List<byte[]> pdfToImage(byte[] fileContent,String imagePath) throws IOException {
        // dpi越大转换后越清晰，相对转换速度越慢
        Integer DPI = 300;
        //转换后的图片类型
        String IMG_TYPE = "jpg";
        List<byte[]> result = new ArrayList<>();
        PDDocument document = Loader.loadPDF(fileContent);
        ByteArrayOutputStream out =null;
        try  {
            PDFRenderer renderer = new PDFRenderer(document);
            for (int i = 0; i < document.getNumberOfPages(); ++i) {
                BufferedImage bufferedImage = renderer.renderImageWithDPI(i, DPI);
                out = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, IMG_TYPE, out);
                result.add(out.toByteArray());
                //=----------------------------------------------图片按页输出路径
                 String path=imagePath+"p"+(char)('0'+i)+".jpg";
                System.out.println(path);
                OutputStream oute = new FileOutputStream(new File(path));
                oute.write(result.get(0));
                oute.flush();
                oute.close();
                result = new ArrayList<>();
            }
        }finally {
            out.close();
            document.close();
        }
        return result;
    }
//     <!--pdfbox依赖-->
//        <dependency>
//            <groupId>org.apache.pdfbox</groupId>
//            <artifactId>pdfbox</artifactId>
//            <version>2.0.20</version>
//        </dependency>

//void yasuo() throws IOException {
//        String  from="C:\\Users\\LZW\\Desktop\\1.jpg";
//        String to ="C:\\Users\\LZW\\Desktop\\new.jpg";
//    //输入文件
//    byte[] bytes = FileUtils.readFileToByteArray(new File(from));
//    //根据文件大小调整压缩质量 200*1024=200kb大小
//    Float quality = 0.5f;
//    if (bytes.length > 200 * 1024 && bytes.length < 2000 * 1024) {
//        quality = 0.25f;
//    }
//    if (bytes.length > 4000 * 1024) {
//        quality = 0.2f;
//    }
//    if (bytes.length > 6000 * 1024) {
//        quality = 0.1f;
//    }
//    if (bytes.length > 10000 * 1024) {
//        quality = 0.1f;
//    }
//    //压缩处理
//    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//    //输出文件
//    Thumbnails.of(byteArrayInputStream).scale(1f).outputQuality(quality).toFile(to);
//}
public static void main(String[] args) throws IOException {
    pdf_tras pp= new pdf_tras();

    pp.test("C:\\Users\\61434\\Desktop\\a.pdf","D:\\myCode\\output\\pic\\");
}




}
