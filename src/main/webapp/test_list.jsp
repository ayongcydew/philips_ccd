<!DOCTYPE html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %> 
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/css/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/css/common_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<title>Philips CCD Test</title>

</head>
<body onload="init()">
<div id="container">
	<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container1">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							测试名称
							<select name="test" id="test" class="ui_select01">
                                <option value=""
                                >请选择</option>
                                <option value="6">Hue</option>
                                <option value="77">Tone</option>
                                <option value="83">LUX</option>
                            </select>
							手动输入&nbsp;&nbsp;
							<input type="text" id="test" name="test" class="ui_input_txt02" />
						</div>
						<div id="box_bottom">
							<a href="javascript:openImportWin();" >数据导入</a>
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table id="listTable" class="table" cellspacing="0" cellpadding="0" width="100%"
						align="center" border="0">
						<tr>
							<th>测试名称</th>
							<th>描述</th>
							<th>测试结果</th>
							<th>测试时间</th>
							<th>测试人</th>
							<th>操作</th>
						</tr>
						<tr v-for="data in planlist">
							<td>{{data.planName}}</td>
							<td>{{data.description}}</td>
							<td>PASS</td>
							<td>{{data.startTime}}</td>
							<td>{{data.operatorName}}</td>
							<td><a @click="opendetailwindow(data.planName)">详情</a></td>
						</tr>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span class="ui_txt_bold04">10</span>
						条记录，当前第
						<span class="ui_txt_bold04">1
						/
						2</span>
						页
					</div>
					<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
						
							<input type="button" value="首页" class="ui_input_btn01" @click="getplanlist(0,10)"/>
							<input type="button" value="上一页" class="ui_input_btn01" @click="getlastpageplanlist()" />
							<input type="button" value="下一页" class="ui_input_btn01" @click="getnextpageplanlist()" />
							<input type="button" value="尾页" class="ui_input_btn01"
								onclick="jumpNormalPage(9);" />
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />页
							 <input type="button" class="ui_input_btn01" value="跳转" onClick="jumpInputPage(9);" />
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
</body>


<script language="javascript">

function openImportWin(){
	window.open ('test_import.jsp', 'newwindow', 'height=600, width=500, top=200,left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
}

function checkBox(obj) {
	if (obj.is(":checked")) {
		$('input.mybox').prop('checked', false);
		obj.prop('checked',true);
		}
	}
	
function init() {
	   var table =document.getElementById("listTable");
	   var rows = table.rows.length;
	   var colums = table.rows[0].cells.length;
}
</script>

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
			localhost:'${pageContext.request.contextPath}',
			planlist:[] ,
			page: 1,
			start: 0,
			limit: 10
		},	
		
		created: function () {			
			this.getplanlist(this.start, this.limit)		
		},
		
		
	    methods: {

		    getplanlist: function (start,limit) {	
		    	var url1=this.localhost + "/test/getPlanList" + "?start=" + start + "&limit=" + limit; 
	            this.$http.get(url1).then(function(data){
	              var tmpplanlist=data.body;
	              this.planlist=tmpplanlist;
	            },function(response){
	              console.info(response);
	            })
		    },
		    
		    getlastpageplanlist: function () {
		    	if (this.page > 1) {
		    		this.page = this.page - 1;
		    		this.start = this.start - 10;
		    	}
		    	
		    	this.getplanlist(this.start, this.limit);
		    },
		    
		    getnextpageplanlist: function () {
		    	this.page = this.page + 1;
		    	this.start = this.start + 10;
		    	this.getplanlist(this.start, this.limit);
		    },
		    
            opendetailwindow: function (planname) {
            	window.open ('test_detail_new.jsp?PlanName='+planname, 'newwindow', 
            			'height=600, width=500, top=200,left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
            },
		}		
	})
</script>

</html>
