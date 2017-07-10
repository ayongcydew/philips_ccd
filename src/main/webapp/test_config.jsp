<!DOCTYPE html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %> 
<html lang="zh-CN">
<head>
<title>Philips CCD Test System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/css/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/css/common_style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="container">
	<table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
		<tr>
			<td>Threshold(L/maxL):</td>
		</tr>
		<tr>
			<td><input type="text" name="Threshold" v-model:value="threshold" class="ui_input_txt02"></input></td>
		</tr>

		<tr><td>SDCM:</td></tr>
		<tr>
			<td><input type="text" name="sdcm1" v-model:value="sdcm1" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td><input type="text" name="sdcm2" v-model:value="sdcm2" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td><input type="text" name="sdcm3" v-model:value="sdcm3" class="ui_input_txt02"></input></td>
		</tr>
	</table>
</div>
</body>
</html>

<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
<script>
	new Vue(
	{
		el : '#container',
		data : {
			localhost:'${pageContext.request.contextPath}',
			threshold: '',
			sdcm1: '',
			sdcm2: '',
			sdcm3: '',
		},
		
		created: function () {
			this.getsdcm()
		
		},
		
	    methods: {
		    
		    getsdcm: function () {
		    	var sdcmlist={};
		    	var url1=this.localhost + "/test/getTestConfig";
	            this.$http.get(url1).then(function(data){
	              var json=data.body;
	              this.threshold= json.threshold;
	              this.sdcm1= json.sdcm1;
	              this.sdcm2= json.sdcm2;
	              this.sdcm3= json.sdcm3;
	            },function(response){
	              console.info(response);
	            })
	         }
		}		
	})
</script>