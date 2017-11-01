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
				<table id="listTable" class="table" cellspacing="0" cellpadding="0"
					width="100%" align="center" border="0">
					<tr>
						<th>ID</th>
						<th>测试名字</th>
						<th>开启亮度</th>
						<th>条件A</th>
						<th>条件B</th>
						<th>开启颜色</th>
						<th>条件A</th>
						<th>条件B</th>
						<th>结果查询</th>
					</tr>
					<tr v-for="data in rulelist">
						<td>{{data.id}}</td>
						<td>{{data.planname}}</td>
						<td>{{data.isbriactivated}}</td>
						<td>{{data.briconditiona}}</td>
						<td>{{data.briconditionb}}</td>
						<td>{{data.iscoloractivated}}</td>
						<td>{{data.colorconditiona}}</td>
						<td>{{data.colorconditionb}}</td>
						<td><a @click="opendetailwindow(data.planname)">详情</a></td>
					</tr>
				</table>
			</div>
			<div id="box_bottom">
				<a href="javascript:openImportWin();">新增</a>
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
			rulelist: [],
		},
		
		created: function () {
			this.getsdcm()
		
		},
		
	    methods: {
		    
		    getsdcm: function () {
		    	var sdcmlist={};
		    	var url1=this.localhost + "/testManage/getTestRuleList";
	            this.$http.get(url1).then(function(data){
	              var json=data.body;
	              this.rulelist = json
	            },function(response){
	              console.info(response);
	            })
	         },
		
	        opendetailwindow: function (planname) {
	        	window.open ('rule_detail.jsp?PlanName='+planname, 'newwindow', 
	        			'height=600, width=500, top=200,left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
	        }
		}		
	})
</script>