<html>
<head lang="en">
<meta charset="UTF-8">
<title>CCD Test</title>
<style type="text/css">

select{width:110px;}

div#container {
	width: 100%;
	hight: 4000px;
}

div#header {
	width: 100%;
	hight: 30%;
}

div#left {
	width: 30%;
	hight: 60%;
	float: left;
}

div#middle {
	width: 30%;
	hight: 60%;
	float: left;
}

div#right {
	width: 40%;
	hight: 60%;
	float: left;
}

div#bottom {
	width: 100%;
	hight: 10%;
	float: left;
}

</style>

</head>
<body v-on:onload="load()">
	<div id="container">
	 	
		<div id="header">
		<br></br>
		<br></br>
			<span> 
				<br></br>
				<button id="GetPlanNameList" @click="getplannamelist">Get Plan Name List</button> 
				<br></br> 
				Select one plan Name
				<select id="SelectPlanName" v-model="selectedplanname">
				<option></option>
				<option v-for="option in options" v-model:value="options">{{option}}</option>
				</select>
				<br></br> 
				Plan Name: <input name="PlanName" v-model:value="planname"></input>
				<br></br>
				
				<span v-if="  this.planname =='' || this.selectedplanname =='' " style="color:#F00;display:true">*please select or input the planName</span>
				
			</span>
		<br></br>
		<br></br>
		</div>
		<div id="Left">

			<table border="1">
				<caption>INPUT</caption>
				<tr>
					<th>Threshold(L/maxL):</th>
				</tr>
				<tr>
					<td><input name="Threshold" v-model:value="threshold"></input></td>
				</tr>

			</table>
			<table border="1">
				<tr>
					<th>SDCM:</th>
				</tr>
				<tr>
					<td><input name="sdcm1" v-model:value="sdcm1"></input></td>
				</tr>
				<tr>
					<td><input name="sdcm2" v-model:value="sdcm2"></input></td>
				</tr>
				<tr>
					<td><input name="sdcm3" v-model:value="sdcm3"></input></td>
				</tr>
			</table>

		</div>
		<div id="Middle">
			<table border="1">
				<caption>OUTPUT</caption>
				<tr>
					<td>MaxL:</td>
					<td><input name="maxL" v-model:value="maxl"></input></td>
				</tr>
				<tr>
					<td>AvgX:</td>
					<td><input name="avgX" v-model:value="avgx"></input></td>
				</tr>
				<tr>
					<td>AvgY:</td>
					<td><input name="avgY" v-model:value="avgy"></input></td>
				</tr>
				<tr>
					<td>AvgU:</td>
					<td><input name="avgU" v-model:value="avgu"></input></td>
				</tr>
				<tr>
					<td>AvgV:</td>
					<td><input name="avgV" v-model:value="avgv"></input></td>
				</tr>
				<tr>
					<td>SDCM1:</td>
					<td><input name="percentSdcm1" v-model:value="percentsdcm1"></input></td>
				</tr>
				<tr>
					<td>SDCM2:</td>
					<td><input name="percentSdcm2" v-model:value="percentsdcm2"></input></td>
				</tr>
				<tr>
					<td>SDCM3:</td>
					<td><input name="percentSdcm3" v-model:value="percentsdcm3"></input></td>
				</tr>
			</table>
			<button id="Get" @click="getpercentsdcm">Analyze Data</button>
				&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button id="Clean" @click="cleandata">clean Data</button>

		</div>
		<div id="Right">
			<form id="submitForm" name="submitForm" action="${pageContext.request.contextPath}/import/testData" enctype="multipart/form-data" method="post">
				<table border="1">
					<caption>Test Data Import</caption>
					<tr>
						<th>file Object</th>
						<th>file path</th>
					</tr>
					<tr>
						<td>Plan Name:</td>
						<td><input type="text" name="planname"></input></td>
					</tr>
					<tr>
						<td>Description:</td>
						<td><input type="text" name="description"></input></td>
					</tr>
					<tr>
						<td>startTime:</td>
						<td><input type="text" name="starttime"></input></td>
					</tr>
					<tr>
						<td>operatorName:</td>
						<td><input type="text" name="operatorname"></input></td>
					</tr>
					<tr>
						<td>Bri:</td>
						<td><input type="file" name="file1"></input></td>
					</tr>
					<tr>
						<td>X:</td>
						<td><input type="file" name="file2"></input></td>
					</tr>
					<tr>
						<td>Y:</td>
						<td><input type="file" name="file3"></input></td>
					</tr>
					<tr>
						<td>U:</td>
						<td><input type="file" name="file4"></input></td>
					</tr>
					<tr>
						<td>V:</td>
						<td><input type="file" name="file5"></input></td>
					</tr>

				</table>
				<input type="submit" value="UpLoad Files">
			</form>
			<br></br>
		</div>

		<br></br>
		<div id="bottom">

		</div>
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
	    methods: {
		    reverseMessage: function () {
		      this.ddd = this.threshold;
		    },
		    
		    cleandata: function () {
	              this.maxl='';
	              this.avgx='';
	              this.avgy='';
	              this.avgu='';
	              this.avgv='';
	              this.percentsdcm1='';
	              this.percentsdcm2='';
	              this.percentsdcm3='';
	              
		    },
		    
		    getplannamelist: function () {	
		    	var url1=this.localhost + "/test/getPlanNameList"; 
	            this.$http.get(url1).then(function(data){
	              var json=JSON.parse(data.body);
	              this.options=json;
	            },function(response){
	              console.info(response);
	            })
		    },
		    
		    
		    getpercentsdcm: function () {
	    		var tem_planname;
	    		var tem_threshold;
	    		if (this.selectedplanname != '') {
	    			tem_planname = this.selectedplanname;
	    		} else if (this.planname != '') {
	    			tem_planname = this.planname;
	    		} else {
	    			alert("test plan name can't be null");
	    			return null;
	    		}
	    		if (this.threshold != '') {
	    			tem_threshold = this.threshold;
	    		} else {
	    			alert("threshold can't be null");
	    			return null;
	    		}
		    	var url1=this.localhost + "/test/getTestResault?planName="+ tem_planname+ "&threshold=" + tem_threshold + "&scdmStep=" + this.sdcm1; 
		    	var url2=this.localhost + "/test/getTestResault?planName="+ tem_planname+ "&threshold=" + tem_threshold + "&scdmStep=" + this.sdcm2;
		    	var url3=this.localhost + "/test/getTestResault?planName="+ tem_planname+ "&threshold=" + tem_threshold + "&scdmStep=" + this.sdcm3;
		    	var url4=this.localhost + "/test/getAvg?planName="+ tem_planname+ "&threshold=" + tem_threshold; 

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
	              this.maxl=json.maxBri;
	              this.avgx=json.avgX;
	              this.avgy=json.avgY;
	              this.avgu=json.avgU;
	              this.avgv=json.avgV;
	            },function(response){
	              console.info(response);
	            })
	         }
		}		
	})
</script>


