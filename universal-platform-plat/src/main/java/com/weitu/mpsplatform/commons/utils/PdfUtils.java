package com.weitu.mpsplatform.commons.utils;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import com.weitu.mpsplatform.commons.exception.JudicialException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * pdf工具类
 */
public class PdfUtils {
    private PdfUtils(){}

    private static Logger logger = LoggerFactory.getLogger(PdfUtils.class);

    /**
     * iText转各种图片为pdf
     *
     * @param imageBytesList
     * @param mOutputPdfFileName
     * @return
     */
    public static File imgBytesToPdf(List<byte[]> imageBytesList, String mOutputPdfFileName) {
        if (null == imageBytesList) {
            return null;
        }
        long beginTime = System.nanoTime();
        Document doc = new Document(PageSize.A4, 20, 20, 20, 20);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(mOutputPdfFileName));
            doc.open();
            for (int i = 0; i < imageBytesList.size(); i++) {
                doc.newPage();
                // doc.add(new Paragraph("简单使用iText"));
                Image png1 = Image.getInstance(imageBytesList.get(i));
                float height = png1.getHeight();
                float width = png1.getWidth();
                int percent = getPercent2(height, width);
                png1.setAlignment(Image.MIDDLE);
                png1.scalePercent(percent + 3);// 表示是原来图像的比例;
                doc.add(png1);
            }
        } catch (Exception e) {
            logger.error("转换异常{}", e);
            throw new JudicialException(e);
        } finally {
            doc.close();
        }

        File mOutputPdfFile = new File(mOutputPdfFileName);
        if (!mOutputPdfFile.exists()) {
            mOutputPdfFile.deleteOnExit();
            return null;
        }

        try {
            mOutputPdfFile.createNewFile();
        } catch (IOException e) {
            logger.error("转换异常{}", e);
            throw new JudicialException(e);
        }
        long endTime = System.nanoTime();
        System.out.println("图片转pdf耗时: " + (endTime - beginTime) / 1000000000 + " 秒  " + imageBytesList.toString());
        return mOutputPdfFile;
    }


    /**
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的
     *
     * @param
     */
    private  static int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }
}
