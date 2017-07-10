package com.cn.philips.controller;

import java.io.IOException;

import javax.annotation.Resource;
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

import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.service.ImportTestDataService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	@Resource
	private ImportTestDataService importTestDataService;

	@RequestMapping(value = "/testData", method = RequestMethod.POST)
	@ResponseBody
	public String UploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        long  startUpTime=System.currentTimeMillis();
        //����ǰ�����ĳ�ʼ����  CommonsMutipartResolver ���ಿ�ֽ�������
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
       //���form���Ƿ���enctype="multipart/form-data"
       if(multipartResolver.isMultipart(request))
       {
           //��request��ɶಿ��request
           MultipartHttpServletRequest multiRequest= (MultipartHttpServletRequest) request;
           CcdTestPlan ccdTestPlan = new CcdTestPlan();
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
          //��ȡ����
           ccdTestPlan.setPlanName(multiRequest.getParameter("planname"));
           ccdTestPlan.setDescription(multiRequest.getParameter("description"));
           ccdTestPlan.setStartTime(sdf.parse(multiRequest.getParameter("starttime")));
           ccdTestPlan.setOperatorName(multiRequest.getParameter("operatorname"));
           
          //��ȡmultiRequest �����е��ļ���
           Iterator iter = multiRequest.getFileNames();

           List<String> fileList = new ArrayList();
            
           while(iter.hasNext())
           {
               //һ�α��������ļ�
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(file!=null)
               {
                   String directoryPath="C:/CCDUploadFiles/"+ ccdTestPlan.getPlanName();
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
           importTestDataService.InsertTestData(
        		   ccdTestPlan.getPlanName(),
        		   ccdTestPlan.getDescription(),
        		   ccdTestPlan.getStartTime(),
        		   ccdTestPlan.getOperatorName(),
        		   fileList.get(0),
        		   fileList.get(1),
        		   fileList.get(2),
        		   fileList.get(3),
        		   fileList.get(4));
       }
       long  endTime=System.currentTimeMillis();
       System.out.println("runtime: "+String.valueOf(endTime-startUpTime)+"ms");
       
       return "upload success";
    }
}
