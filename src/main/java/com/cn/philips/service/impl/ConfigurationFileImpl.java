package com.cn.philips.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 这是个配置文件操作类，用来读取和设置ini配置文件
 * @author Colin Chen
 * @version 2017-08-18
 */
public final class ConfigurationFileImpl {
 /**
  * 从ini配置文件中读取变量的值
  * @param file 配置文件的路径
  * @param section 要获取的变量所在段名称
  * @param variable 要获取的变量名称
  * @param defaultValue 变量名称不存在时的默认值
  * @return 变量的值
  * @throws IOException 抛出文件操作可能出现的io异常
  */
 public static String getProfileString(
  String file,
  String section,
  String variable,
  String defaultValue)
  throws IOException {
  String strLine, value = "";
  BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
  boolean isInSection = false;
  try {
   while ((strLine = bufferedReader.readLine()) != null) {
    strLine = strLine.trim();  
    
    if (strLine.matches("\\[.*\\]")) {
    	if (strLine.matches("\\[" + section + "\\]")) {
    		isInSection = true;
    	} else{
    		isInSection = false;
    	}	
    }
    
    if (isInSection == true) {
     strLine = strLine.trim();
     String[] strArray = strLine.split("=");
     if (strArray.length == 1) {
      value = strArray[0].trim();
      if (value.equalsIgnoreCase(variable)) {
       value = "";
       return value;
      }
     } else if (strArray.length == 2) {
      value = strArray[0].trim();
      if (value.equalsIgnoreCase(variable)) {
       value = strArray[1].trim();
       return value;
      }
     } else if (strArray.length > 2) {
      value = strArray[0].trim();
      if (value.equalsIgnoreCase(variable)) {
       value = strLine.substring(strLine.indexOf("=") + 1).trim();
       return value;
      }
     }
    }
   }
  } finally {
   bufferedReader.close();
  }
  return defaultValue;
 }
 /**
 * 修改ini配置文件中变量的值
 * @param file 配置文件的路径
 * @param section 要修改的变量所在段名称
 * @param variable 要修改的变量名称
 * @param value 变量的新值
 * @throws IOException 抛出文件操作可能出现的io异常
 */
 public static boolean setProfileString(
  String file,
  String section,
  String variable,
  String value)
  throws IOException {
  String fileContent, allLine,strLine, newLine, remarkStr;
  String getValue;
  BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
  boolean isInSection = false;
  fileContent = "";
  try {
   while ((allLine = bufferedReader.readLine()) != null) {
    allLine = allLine.trim();
    if (allLine.split("[;]").length > 1)
     remarkStr = ";" + allLine.split(";")[1];
    else
     remarkStr = "";
    strLine = allLine.split(";")[0];
    
    if (strLine.matches("\\[.*\\]")) {
    	if (strLine.matches("\\[" + section + "\\]")) {
    		isInSection = true;
    	} else{
    		isInSection = false;
    	}	
    }
    
    if (isInSection == true) {
     strLine = strLine.trim();
     String[] strArray = strLine.split("=");
     getValue = strArray[0].trim();
     if (getValue.equalsIgnoreCase(variable)) {
      newLine = getValue + "=" + value + " " + remarkStr;
      fileContent += newLine + "\r\n";
      while ((allLine = bufferedReader.readLine()) != null) {
    	  fileContent += allLine + "\r\n";  
      }
      bufferedReader.close();
      BufferedWriter bufferedWriter =
       new BufferedWriter(new FileWriter(file, false));
      bufferedWriter.write(fileContent);
      bufferedWriter.flush();
      bufferedWriter.close();
      return true;
     }
    }
    fileContent += allLine + "\r\n";
   }
  }catch(IOException ex){
   throw ex;
  } finally {
   bufferedReader.close();
  }
  return false;
 }
}