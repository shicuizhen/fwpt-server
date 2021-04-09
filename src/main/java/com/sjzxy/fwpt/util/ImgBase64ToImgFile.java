package com.sjzxy.fwpt.util;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Administrator
 */
public class ImgBase64ToImgFile {

    public static void getImgBase64ToImgFile(String imgBase64, String imgPath) throws IOException {

        imgBase64 = URLDecoder.decode(imgBase64, "UTF-8");

        //将base64编码中的空格转换成+号
        imgBase64 = imgBase64.replaceAll(" ", "+");

        //如果传进来的base64数据含有"data:image/jpeg;base64,"部分，需要去掉
        imgBase64 = imgBase64.substring(imgBase64.indexOf(",") + 1);

        BASE64Decoder decoder = new BASE64Decoder();
        Path path = Paths.get(imgPath);
        byte[] imageContents = decoder.decodeBuffer(imgBase64);
        try {
            // 将图片写入指定的路径
            Files.write(path, imageContents, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
