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
	当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">测试详情</span>
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

<br></br><br></br><br></br><br></br><br></br>
	<table border="1">
		<caption>Test Resault</caption>
		<tr>
			<td>MaxL:</td>
			<td><input type="text" name="maxL" v-model:value="testresault.maxBri" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>AvgX:</td>
			<td><input type="text" name="avgX" v-model:value="testresault.avgX" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>AvgY:</td>
			<td><input type="text" name="avgY" v-model:value="testresault.avgY" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>AvgU:</td>
			<td><input type="text" name="avgU" v-model:value="testresault.avgU" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>AvgV:</td>
			<td><input type="text" name="avgV" v-model:value="testresault.avgV" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>SDCM1:</td>
			<td><input type="text" name="percentSdcm1" v-model:value="percentsdcm1" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>SDCM2:</td>
			<td><input type="text" name="percentSdcm2" v-model:value="percentsdcm2" class="ui_input_txt02"></input></td>
		</tr>
		<tr>
			<td>SDCM3:</td>
			<td><input type="text" name="percentSdcm3" v-model:value="percentsdcm3" class="ui_input_txt02"></input></td>
		</tr>
	</table>
</div>
</body>
</html>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script>
	// 这是我们的Model
	var exampleData = {
		test : 'n',
	}

	// 创建一个 Vue 实例或 "ViewModel"
	// 它连接 View 与 Model
	new Vue(
	{
		el : '#container',
		data : {
			ddd: 'ddd',
			localhost:'${pageContext.request.contextPath}',
			firstTry: 'aaa',
			maxl: '',
			avgx: '',
			avgy:'',
			avgu: '',
			avgv: '',
			testresault:'',
			planname:'' ,
			threshold: 0.3,
			bripath: '',
			xpath: '',
			ypath: '',
			upath: '',
			vpath: '',
			sdcm1: 5,
			sdcm2: 7,
			sdcm3: 10,
			percentsdcm1: '',
			percentsdcm2: '',
			percentsdcm3: '',
			options:[],
			selectedplanname: ''
		},
		
		created: function () {
			
			this.getparam(),
			this.getpercentsdcm()
		
		},
		
	    methods: {
		    
		    getplannamelist: function () {	
		    	var url1=this.localhost + "/test/getPlanNameList"; 
	            this.$http.get(url1).then(function(data){
	              var json=JSON.parse(data.body);
	              this.options=json;
	            },function(response){
	              console.info(response);
	            })
		    },
		    
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
		    
		    getpercentsdcm: function () {
		    	var url1=this.localhost + "/test/getTestResault?planName="+ this.planname+ "&threshold=" + this.threshold + "&scdmStep=" + this.sdcm1; 
		    	var url2=this.localhost + "/test/getTestResault?planName="+ this.planname+ "&threshold=" + this.threshold + "&scdmStep=" + this.sdcm2;
		    	var url3=this.localhost + "/test/getTestResault?planName="+ this.planname+ "&threshold=" + this.threshold + "&scdmStep=" + this.sdcm3;
		    	var url4=this.localhost + "/test/getAvg?planName="+ this.planname+ "&threshold=" + this.threshold; 

	            this.$http.get(url1).then(function(data){
	              var json=data.body;
	              this.percentsdcm1= eval("(" + json +")");
	            },function(response){
	              console.info(response);
	            })
	            this.$http.get(url2).then(function(data){
	              var json=data.body;
	              this.percentsdcm2=eval("(" + json +")");
	            },function(response){
	              console.info(response);
	            })
	            this.$http.get(url3).then(function(data){
	              var json=data.body;
	              this.percentsdcm3=eval("(" + json +")");
	            },function(response){
	              console.info(response);
	            })
	            this.$http.get(url4).then(function(data){
	              var json=JSON.parse(data.body);
	              this.testresault = json;
	            },function(response){
	              console.info(response);
	            })
	         }
		}		
	})
</script>

