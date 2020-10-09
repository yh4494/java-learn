package topdf;

import com.itextpdf.text.Font;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-29 16:14
 * @Version V1.0
 */
public class MyFontsProvider extends XMLWorkerFontProvider {

    public MyFontsProvider(){
        super(null, null);
    }

    @Override
    public Font getFont(final String fontname, String encoding, float size, final int style) {
        String fntname = fontname;
        if (fntname == null) {
            fntname = "宋体";//windows下
            //fntname = "fontFile/simsun.ttf";//linux系统下
        }
        if (size == 0) {
            size = 4;
        }
        return super.getFont(fntname, encoding, size, style);
    }
}
