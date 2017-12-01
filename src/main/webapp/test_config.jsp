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
	<div class="ui_content">
		<div class="ui_tb">
			<table id="listTable" class="table" cellspacing="0" cellpadding="0" width="100%"
				align="center" border="0">
				<tr>
					<th>测试名称</th>
					<th>THRESHOLD</th>
					<th>SDCM_A</th>
					<th>SDCM_B</th>
					<th>SDCM_C</th>
					<th>SDCM_D</th>
					<th>SDCM_E</th>
				</tr>
				<tr v-for="data in configlist">
					<td>{{data.planName}}</td>
					<td>{{data.threshold}}</td>
					<td>{{data.sdcm1}}</td>
					<td>{{data.sdcm2}}</td>
					<td>{{data.sdcm3}}</td>
					<td>{{data.sdcm4}}</td>
					<td>{{data.sdcm5}}</td>
				</tr>
			</table>
		</div>
		<div id="box_bottom">
			<a href="javascript:openImportWin();" >添加配置</a>
		</div>
</div>
</body>
</html>

<script language="javascript">

function openImportWin(){
	window.open ('test_import.jsp', 'newwindow', 'height=600, width=500, top=200,left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
}
</script>

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
			sdcm4: '',
			sdcm5: '',
			configlist: [],
		},
		
		created: function () {
			this.getsdcm()
		
		},
		
	    methods: {
		    
		    getsdcm: function () {
		    	var sdcmlist={};
		    	var url1=this.localhost + "/testManage/getTestConfigList";
	            this.$http.get(url1).then(function(data){
	              var json=data.body;
	              this.configlist = json
	            },function(response){
	              console.info(response);
	            })
	         }
		}		
	})
</script>