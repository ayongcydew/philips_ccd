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
	<table border="1">
		<caption>Test Resault</caption>
		<tr>
			<td class="ui_input_txt01">MaxL:</td>
			<td class="ui_input_txt02">{{testresault.avgBri}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">AvgX:</td>
			<td class="ui_input_txt02">{{testresault.avgX}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">AvgY:</td>
			<td class="ui_input_txt02">{{testresault.avgY}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">AvgU:</td>
			<td class="ui_input_txt02">{{testresault.avgU}}</td>
		</tr>
		<tr>
			<td class="ui_input_txt01">AvgV:</td>
			<td class="ui_input_txt02">{{testresault.avgV}}</td>
		</tr>
								
		<tr border="1" v-for="percentsdcm in percentsdcmlist">
		<td class="ui_input_txt01">SDCM:</td>
		<td class="ui_input_txt02">{{percentsdcm}}</td>
		</tr>
	
	</table>
</div>
</body>
</html>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
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
			percentsdcmlist: [],
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
		    	var sdcmlist={};
		    	var url1=this.localhost + "/test/getTestResault?planName="+ this.planname; 
		    	var url4=this.localhost + "/test/getAvg?planName="+ this.planname; 

	            this.$http.post(url1, sdcmlist).then(function(data){
	              var json=data.body;
	              this.percentsdcmlist= json;
	            },function(response){
	              console.info(response);
	            })

	            this.$http.get(url4).then(function(data){
	              var json=data.body;
	              this.testresault = json;
	            },function(response){
	              console.info(response);
	            })
	         }
		}		
	})
</script>

