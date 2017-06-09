package com.cn.philips.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;

@Controller
@RequestMapping("/import")
public class ImportTestDataController {

	@RequestMapping(value = "/testData", method = RequestMethod.POST)
	@ResponseBody
	public String UploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        long  startUpTime=System.currentTimeMillis();
        //����ǰ�����ĳ�ʼ����  CommonsMutipartResolver ���ಿ�ֽ�������
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
       //���form���Ƿ���enctype="multipart/form-data"
       if(multipartResolver.isMultipart(request))
       {
           //��request��ɶಿ��request
           MultipartHttpServletRequest multiRequest= (MultipartHttpServletRequest) request;
          //��ȡ����
           String planName = multiRequest.getParameter("planname");
           String description = multiRequest.getParameter("description");
           String startTime = multiRequest.getParameter("starttime");
           String operatorName = multiRequest.getParameter("operatorname");
           
          //��ȡmultiRequest �����е��ļ���
           Iterator iter = multiRequest.getFileNames();

           List<String> fileList = new ArrayList();
            
           while(iter.hasNext())
           {
               //һ�α��������ļ�
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(file!=null)
               {
                   String directoryPath="C:/CCDUploadFiles/"+ planName;
                   String filePath = directoryPath + '/' + file.getOriginalFilename();
                   
                   if(!new File(directoryPath).exists())   {
                       new File(directoryPath).mkdirs();
                     } 
                   //�ϴ�
                   if(!(new File(filePath).exists())) {
                	   file.transferTo(new File(filePath));  
                   } else {
                	   return  "file exist";
                   }
                   
                   //��¼�ļ������б�
                   fileList.add(filePath);
               }             
           }       
       }
       long  endTime=System.currentTimeMillis();
       System.out.println("runtime: "+String.valueOf(endTime-startUpTime)+"ms");
       
       return "upload success";
    }
}
