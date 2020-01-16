package base;

import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public class Test extends SXSSFWorkbook {

    public Test(int i) {
        super(i);
    }

    @Override
    public void write(OutputStream stream) throws IOException {
        flushSheets();

        //Save the template
        File tmplFile = TempFile.createTempFile("poi-sxssf-template", ".xlsx");
        boolean deleted;
        try {
            FileOutputStream os = new FileOutputStream(tmplFile);
            try {
                //  _wb.write(os);
            } finally {
                os.close();
            }

            //Substitute the template entries with the generated sheet data files
            final ZipEntrySource source = new ZipFileZipEntrySource(new ZipFile(tmplFile));
            injectData(source, stream);
        } finally {
            deleted = tmplFile.delete();
        }
        if(!deleted) {
            throw new IOException("Could not delete temporary file after processing: " + tmplFile);
        }
    }
}
