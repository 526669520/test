package com.liu.zxing;

/**
 * Created by liu on 2017/2/4.
 */


import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


/**
 * 生成二维码
 *
 * @author Administrator
 * @date 2016年7月29日
 */
public class CreateQRCode {


    public static void main(String[] args) {

        int width = 300;//二维码图片的宽度
        int height = 300;//二维码图片的高度
        String format = "png";//二维码格式
        String content = "http://www.imooc.com";//二维码内容

        //定义二维码内容参数
        HashMap hints = new HashMap();
        //设置字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //设置容错等级，在这里我们使用M级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置边框距
        hints.put(EncodeHintType.MARGIN, 2);

        //生成二维码
        try {
            //指定二维码内容
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            //指定生成图片的保存路径
            Path file = new File("D:/code/imooc.png").toPath();
            //生成二维码
//            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}