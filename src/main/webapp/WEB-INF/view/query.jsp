<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<title>部门管理显示页面</title>
</head>
<body>
	<div align="center">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th>编号</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
			<tbody id="link"></tbody>
		</table>
	</div>
</body>
<script type="text/javascript">

	$(document).ready(function(){ // 页面加载完成后出现
		query();
	}); 
	
	function query() {
		$.ajax({
			type : "get",
			url : '<%=request.getContextPath()%>/department',
			dataType:"json",
			success : function(list) {
				var dataObj = list;
				var html = "";
				for(var i in dataObj){
					html += "<tr><td align='center'>"+dataObj[i].id+"</td>"+
					"<td  align='center'>"+dataObj[i].name+"</td>"+
					"<td  align='center'>"+
					"<button><a href='javascript:void(0)' onclick='postMethod()'>测试</a></button>"+
					"</td></tr>"
				}
				$('#link').append(html);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status+","+XMLHttpRequest.readyState+","+textStatus);
            }
		})
	}
	
	function postMethod(){
		var url="<%=request.getContextPath()%>/department";
	    var tempForm = document.createElement("form");
	    tempForm.method = "post";
	    tempForm.action = url;
	    
	    document.body.appendChild(tempForm);
	    tempForm.submit();
	    document.body.removeChild(tempForm);
	}
	
</script>
</html>