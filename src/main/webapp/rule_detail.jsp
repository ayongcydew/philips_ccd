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
	当前位置：规则设定&nbsp;>&nbsp;<span style="color: #1A5CC6;">测试详情</span>
<div id="container">
	<table border="1">
		<caption>Test Resault</caption>
		<tr>
			<td class="ui_input_txt01">TestName:</td>
			<td class="ui_input_txt02">{{planname}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">亮度条件A:</td>
			<td class="ui_input_txt02">{{toPercent(testresault.briConditionAResault)}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">亮度条件B:</td>
			<td class="ui_input_txt02">{{toPercent(testresault.briConditionBResault)}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">颜色条件A:</td>
			<td class="ui_input_txt02">{{toPercent(testresault.colorConditionAResault)}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">颜色条件B:</td>
			<td class="ui_input_txt02">{{toPercent(testresault.colorConditionAResault)}}</td>
		</tr>									
	</table>
</div>
</body>
</html>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
<script>

	var exampleData = {
		test : 'n',
	}
	new Vue(
	{
		el : '#container',
		data : {
			ddd: 'ddd',
			localhost:'${pageContext.request.contextPath}',
			testresault:'',
			planname:'' ,
			point: ''

		},
		
		created: function () {
			
			this.getparam(),
			this.gettestresault()
		
		},
		
	    methods: {
		    		    
		    getparam: function () {	
	        	var query = location.search.substring(1);
	        	var values= query.split("&");
	        	for(var i = 0; i < values.length; i++) {
	        		var pos = values[i].indexOf('=');
		        	if (pos == -1) continue;
		        	var paramname = values[i].substring(0,pos);
		        	var value = values[i].substring(pos+1);
		        	this.planname = value;
		        	}
	        },
		    
		    gettestresault: function () {
		    	var sdcmlist={};
		    	var url1=this.localhost + "/testManage/getRuleResault?planName="+ this.planname; 

	            this.$http.get(url1).then(function(data){
	              var json=data.body;
	              this.testresault = json;
	            },function(response){
	              console.info(response);
	            })
	         },
	         
	         //change value to percentage format
	         toPercent: function (point){
	        	  var str=Number(point*100).toFixed(2);
	        	  str+="%";
	        	    return str;
	        	}
		}		
	})
</script>

