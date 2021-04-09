//package com.sjzxy.fwpt.common.upload;
//
//import com.sjzxy.fwpt.common.response.BaseResponse;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import jdk.nashorn.internal.runtime.logging.Logger;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Api(tags = "图片上传")
//@Slf4j
//@RestController
//@RequestMapping(value = "/imgUpload")
//public class ImgUpload {
//
//    @Value("${fileUploadPath}")
//    private String fileUploadPath;
//
//    @ApiOperation(value = "图片上传")
//    @PostMapping
//    @ResponseBody
//    public BaseResponse imgUpload(@ApiParam("实体对象") @Valid @RequestParam("file") MultipartFile file) throws IOException {
//
//        FileOutputStream out = null;
//        try {
//            String fileName = file.getOriginalFilename();
//            System.out.println("fileName:"+fileName);
//            if (fileName.indexOf("\\") != -1) {
//                fileName = fileName.substring(fileName.lastIndexOf("\\"));
//            }
//            // 获取文件存放地址
//            String filePath = fileUploadPath;
//            System.out.println("filePath:"+filePath);
//            File f = new File(filePath);
//            if (!f.exists()) {
//                f.mkdirs();// 不存在路径则进行创建
//            }
//            // 重新自定义文件的名称
//            filePath = filePath + fileName;
//            System.out.println("filePath=====:"+filePath);
//            out = new FileOutputStream(filePath);
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//            //将文件路径返回
//            return BaseResponse.ok().data(filePath);
//        } catch (Exception e) {
//            return BaseResponse.error();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
