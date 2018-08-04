<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title></title>
<style>
	*{padding:0;margin:0;}
	.content {
		margin:50px auto 0;
		width:300px;
		min-height: 500px;
	}

	.form-group {
		width:100%;
		float:left;
		margin:5px 0;
	}

	label{
		margin-bottom:10px;
		float:left;			
	}

	.field-input, select{
		width:calc(100% - 20px);
		float:left;
		padding:10px;
		font-family:inherit;
	}		
</style>

<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#parentC").change(function(){
			var parentId=$("#parentC").val();
			$.ajax({
				"url":"CategoryFindChildByParent.Action",
				"type":"post",
				"data":"parentId="+parentId,
				"success":function(result){
							var str="<select name='childC' id='childC' placeholder='下拉显示更多'>";
							for(var i=0;i<result.length;i++){
								str+="<option value='"+result[i].id+"'>"+result[i].name+"</option>";
							}
								str+="</select>";
								$("#childC").html(str);
							}
			})
		})
		
		
		$("#grade").live("change",function(e){
			var parentC = $("#parentC").val();
			var childC = $("childC").val();
			if(parentC!=""){
				e.preventDefault();
				window.opener.location.href="CategoryShowAll1.Action?gradeC="+$("#grade").val();
				window.close();
			}
		})
		
	})
		
</script>
</head>
<body>
<div class="zzsc-container">
	<div class="content -bg">		
		<form action="makeDecision.Action" method="post">	
			<div class="form-group">
				<label>一级目录</label>
				<select id="parentC">
					<option value="-1">请选择</option>
					<c:forEach items="${li }" var="c">
						<option value="${c.id }">${c.name }</option>
					</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label>二级目录</label>
				<select name="childC" id="childC">
				</select>			
			</div>
			<div class="form-group">
				<label for="state">请选择添加分类级数：</label>
				<select name="grade" id="grade" placeholder="下拉显示更多">
					<option value="p1" selected="selected"></option>
					<option value="pe">添加一级分类</option>
					<option value="pb">添加二级分类</option>
				</select>			
			</div>		
		</form>
	</div>
</div>
</body>

</html>