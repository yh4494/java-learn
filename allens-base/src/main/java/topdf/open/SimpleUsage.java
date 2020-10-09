package topdf.open;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.extern.java.Log;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ResourceNotFoundException;
import topdf.model.AbstractEmailModel;
import topdf.model.TestPdfModel;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-29 17:42
 * @Version V1.0
 */
@Log
public class SimpleUsage {

    public static void main(String[] args) throws Exception {
        // String com_path = SimpleUsage.class.getClassLoader().getResource(".").getPath();
        TestPdfModel testPdfModel = new TestPdfModel();
        testPdfModel.setName("PDF TRANSFER TO WORD");
        testPdfModel.setTitle("这是一个Title");
        testPdfModel.setSome("从倩");
        String template = templateProcess(testPdfModel);

        try (OutputStream os = new FileOutputStream("/Users/allens/Documents/package/122112.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            //下面这个方法是要自己指定 字体文件   不然转出的pdf文件中 中文会变成####
            builder.useFont(() -> {
                try {
                    //指定 字体文件
                    return new FileInputStream("/Users/allens/Documents/package/song.ttf");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                return null;
            }, "宋体", 400, BaseRendererBuilder.FontStyle.NORMAL, true);
            builder.withHtmlContent(template, "");
            builder.toStream(os);
            builder.run();
        }
    }

    /**
     * 生成模板
     * @return
     */
    private static String templateProcess(AbstractEmailModel model) throws IllegalAccessException, ResourceNotFoundException {
        Properties p = new Properties();

        // 加载 classpath 目录下的 vm 文件
        p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");

        Velocity.init(p); // 初始化

        String formatString = String.format("%s.vm", model.getClass().getSimpleName());
        Template t = Velocity.getTemplate(formatString);
        VelocityContext context = initializeTemplate(model);

        StringWriter sw = new StringWriter();
        t.merge(context, sw);

        return sw.toString();
    }

    private static VelocityContext initializeTemplate(AbstractEmailModel model) throws IllegalAccessException {
        VelocityContext context = new VelocityContext();
        Class cl = model.getClass();
        Set<Field> fields = new HashSet<>();
        fields.addAll(Arrays.asList(cl.getDeclaredFields()));
        fields.addAll(Arrays.asList(cl.getSuperclass().getDeclaredFields()));
        fields.forEach(e -> {
            try {
                e.setAccessible(true);
                context.put(e.getName(), e.get(model));
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        return context;
    }
}
