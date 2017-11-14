<!DOCTYPE html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %> 
<html>
<head>
<title>Philips CCD Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/css/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/css/common_style.css" rel="stylesheet" type="text/css">
</head>
<body>
	当前位置：测试数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">本地数据导入</span>
<form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/import/testDataLocal" 
		enctype="multipart/form-data" method="post">
	<div id="container">
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt">测试名称</td>
					<td class="ui_text_lt">
						<input type="text" id="planname" name="planname" value=""  class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">描述</td>
					<td class="ui_text_lt">
						<input type="text" id="description" name="description"  value="" class="ui_input_txt02" />
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">测试时间</td>
					<td class="ui_text_lt">
						<input type="text" id="starttime" name="starttime"  value="" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">操作人</td>
					<td class="ui_text_lt">
						<input type="text" id="operatorname" name="operatorname" value="" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">文件夹存放位置</td>
					<td class="ui_text_lt">
						<input type="text" id="filepath" name="filepath"  value="" class="ui_input_txt02"/>
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="submit" value="提交" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
</html>