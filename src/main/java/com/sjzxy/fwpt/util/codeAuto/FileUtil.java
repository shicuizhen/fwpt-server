package com.sjzxy.fwpt.util.codeAuto;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * file工具类
 */
@Slf4j
public class FileUtil {
    /**
     * 创建文件
     *
     * @param pathNameAndFileName 路径跟文件名
     * @return File对象
     */
    static File createFile(String pathNameAndFileName) {
        File file = new File(pathNameAndFileName);
        try {
            //获取父目录
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            //创建文件
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            file = null;
            System.err.println("新建文件操作出错");
            log.error(e.getMessage());
        }
        return file;
    }

    /**
     * 字符流写入文件
     *
     * @param file         file对象
     * @param stringBuffer 要写入的数据
     */
    static void fileWriter(File file, StringBuffer stringBuffer) {
        //字符流
        try {
            FileWriter resultFile = new FileWriter(file, false);
            //true,则追加写入 false,则覆盖写入
            PrintWriter myFile = new PrintWriter(resultFile);
            //写入
            myFile.println(stringBuffer.toString());

            myFile.close();
            resultFile.close();
        } catch (Exception e) {
            System.err.println("写入操作出错");
            //输出到日志文件中
            log.error(e.getMessage());
        }
    }
}
