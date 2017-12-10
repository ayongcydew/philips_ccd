package com.cn.philips.controller;

import java.io.IOException;
import java.io.FileNotFoundException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String UploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startUpTime = System.currentTimeMillis();
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			CcdTestPlan ccdTestPlan = new CcdTestPlan();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 获取参数
			ccdTestPlan.setPlanName(multiRequest.getParameter("planname"));
			ccdTestPlan.setDescription(multiRequest.getParameter("description"));
			ccdTestPlan.setStartTime(sdf.parse(multiRequest.getParameter("starttime")));
			ccdTestPlan.setOperatorName(multiRequest.getParameter("operatorname"));

			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();

			List<String> fileList = new ArrayList<>();

			String directoryPath = "C:/CCDUploadFiles/" + ccdTestPlan.getPlanName() + "_" + new Date().getTime();

			if (!new File(directoryPath).exists()) {
				new File(directoryPath).mkdirs();
			}

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String filePath = directoryPath + '/' + file.getOriginalFilename();
					// 上传
					if (!(new File(filePath).exists())) {
						file.transferTo(new File(filePath));
					} else {
						return "file exist";
					}

					// 记录文件名字列表
					fileList.add(filePath);
				}
			}
			importTestDataService.InsertTestData(ccdTestPlan.getPlanName(), ccdTestPlan.getDescription(),
					ccdTestPlan.getStartTime(), ccdTestPlan.getOperatorName(), "color", fileList);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("runtime: " + String.valueOf(endTime - startUpTime) + "ms");

		return "upload success";
	}

	@RequestMapping(value = "/testDataLocal", method = RequestMethod.POST)
	@ResponseBody
	public String UploadFileLocal(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String requestBody) throws Exception {
		String filePath = request.getParameter("filepath");
		String planName = request.getParameter("planname");
		String type = request.getParameter("type");
		Integer testNums = Integer.parseInt(request.getParameter("testnums"));

		File file = new File(filePath);
		ArrayList<List<String>> insertFileList = new ArrayList<List<String>>();
		if (!file.isDirectory()) {
			throw new Exception("文件路径不存在");
		} else if (file.isDirectory()) {
			System.out.println("上传文件夹");
			if (planName == null) {
				throw new Exception("测试名称不能为空");
			}

			String[] filelist = file.list();

			for (int num = 1; num <= testNums; num++) {
				ArrayList<String> insertFileListtmp = new ArrayList<String>();

				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filePath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {

						String profixName = readfile.getName().split("_")[0];

						if (Integer.parseInt(readfile.getName().split("_")[1]) == num) {

							switch (profixName) {
							case ("L"): {
								insertFileListtmp.add(readfile.getAbsolutePath());
								break;
							}
							case ("X"): {
								insertFileListtmp.add(readfile.getAbsolutePath());
								break;
							}
							case ("Y"): {
								insertFileListtmp.add(readfile.getAbsolutePath());
								break;
							}
							case ("U"): {
								insertFileListtmp.add(readfile.getAbsolutePath());
								break;
							}
							case ("V"): {
								insertFileListtmp.add(readfile.getAbsolutePath());
								break;
							}
							}
						}
					}
				}

				if (insertFileListtmp.size() != 5) {
					throw new Exception("文件个数不对");
				}

				insertFileList.add(insertFileListtmp);
			}
			CcdTestPlan ccdTestPlan = new CcdTestPlan();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 获取参数
			ccdTestPlan.setPlanName(request.getParameter("planname"));
			ccdTestPlan.setDescription(request.getParameter("description"));
			ccdTestPlan.setStartTime(sdf.parse(request.getParameter("starttime")));
			ccdTestPlan.setOperatorName(request.getParameter("operatorname"));

			for (List<String> tmpList : insertFileList) {
				importTestDataService.InsertTestData(ccdTestPlan.getPlanName(), ccdTestPlan.getDescription(),
						ccdTestPlan.getStartTime(), ccdTestPlan.getOperatorName(), type, tmpList);
			}

		}
		return planName + " is " +"upload successfully";
	}
}
