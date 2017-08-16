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
					<th>SDCM1</th>
					<th>SDCM2</th>
					<th>SDCM3</th>
				</tr>
				<tr v-for="data in configlist">
					<td>{{data.planName}}</td>
					<td>{{data.threshold}}</td>
					<td>{{data.sdcm1}}</td>
					<td>{{data.sdcm2}}</td>
					<td>{{data.sdcm3}}</td>
				</tr>
			</table>
		</div>
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