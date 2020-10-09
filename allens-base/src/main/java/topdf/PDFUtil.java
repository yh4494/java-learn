package topdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfBody;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.head.Title;
import org.apache.commons.codec.digest.Md5Crypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-29 16:13
 * @Version V1.0
 */
public class PDFUtil {

    public static void htmlToPDF(String htmlString, String pdfPath) {
        try {
            InputStream htmlFileStream = new FileInputStream(htmlString);

             byte[] bytes = new byte[htmlFileStream.available()];
             htmlFileStream.read(bytes);
             System.out.println(new String(bytes));

            // 创建一个document对象实例
            Document document = new Document(PageSize.A4);
            // 为该Document创建一个Writer实例
            PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
            // 打开当前的document
            document.open();
            document.add(new Chunk(new String(bytes)));
            InputStreamReader isr = new InputStreamReader(htmlFileStream, StandardCharsets.UTF_8);
            XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document, htmlFileStream, null, Charset.forName("UTF-8"), new MyFontsProvider());
            //XMLWorkerHelper.getInstance().p
            isr.close();
            htmlFileStream.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void main(String[] args) throws Exception {
        String md5Crypt = Md5Crypt.md5Crypt("123456".getBytes());
        PDFUtil.htmlToPDF("/Users/allens/Documents/package/index.html", String.format("/Users/allens/Documents/package/%s.pdf", "a"));
    }

}
