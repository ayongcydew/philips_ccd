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
	当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">数据导入</span>
<form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/import/testData" 
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
					<td class="ui_text_rt">Bri</td>
					<td class="ui_text_lt">
						<input type="file" id="file1" name="file1"  value="" class="ui_input_txt03"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">X</td>
					<td class="ui_text_lt">
						<input type="file" id="file2" name="file2"  value="" class="ui_input_txt03"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">Y</td>
					<td class="ui_text_lt">
						<input type="file" id="file3" name="file3"  value="" class="ui_input_txt03"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">U</td>
					<td class="ui_text_lt">
						<input type="file" id="file4" name="file4"  value="" class="ui_input_txt03"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">V</td>
					<td class="ui_text_lt">
						<input type="file" id="file5" name="file5"  value="" class="ui_input_txt03"/>
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