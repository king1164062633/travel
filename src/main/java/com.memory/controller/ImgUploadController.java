package com.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/13.
 */
@Controller
public class ImgUploadController {
        private File uploadify;
        public File getUploadify() {
            return uploadify;
        }
        public void setUploadify(File uploadify) {
            this.uploadify = uploadify;
        }
        private String uploadifyFileName;
        public String getUploadifyFileName() {
            return uploadifyFileName;
        }
        public void setUploadifyFileName(String uploadifyFileName) {
            this.uploadifyFileName = uploadifyFileName;
        }

        /**
         * 上传图片
         * @throws IOException
         */
        @RequestMapping("uploadImg")
        public void uploadImg(HttpServletRequest request, HttpServletResponse response){
            String savePath = request.getSession().getServletContext().getRealPath("");
            PrintWriter out = null;
            String resultStr = "";
            String extName = "";// 扩展名
            String newFileName = "";// 新文件名
            try {
                response.setCharacterEncoding("utf-8");
                out = response.getWriter();

                //获取文件的扩展名
                if (uploadifyFileName.lastIndexOf(".") >= 0) {
                    extName = uploadifyFileName.substring(uploadifyFileName.lastIndexOf("."));
                }
                //根据当前时间生成新的文件名称
                String nowTime = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());// 当前时间
                newFileName = nowTime + extName;

                //设置文件保存路径
                String param = request.getParameter("param");
                savePath = savePath + "/ImgUpload/"+param+"/";
                File file = new File(savePath);
                if(!file.exists()){
                    file.mkdirs();
                }
                uploadify.renameTo(new File(savePath+newFileName));
                resultStr = uploadifyFileName+","+"/ImgUpload/"+param+"/"+newFileName;
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                out.print(resultStr);
            }
        }

    }
