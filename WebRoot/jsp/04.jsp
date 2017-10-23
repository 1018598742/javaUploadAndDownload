<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".thumbs a").click(function(){
				var largePath=$(this).attr("href");
				var largeAlt = $(this).attr("title");
				$("#largeImg").attr({
					src:largePath,
					alt:largeAlt
				});
				return false;
			});
			
			/* IE 浏览器图片预览start */
			/*
			$("#myfile").change(function(){
				$("#previewImg").attr("src","file:///"+$("#myfile").val());
			}); */
			/* IE 浏览器图片预览end */
			
			
			/* goolge 浏览器图片预览start */
			$("#myfile").change(function(){
				
				var file = this.files[0];
				var reader = new FileReader();
				reader.onload = function(){
					var url = reader.result;
					setImageURL(url);
				}
				reader.readAsDataURL(file);
			});
			var image = $("#previewImg")[0];
			function setImageURL(url){
				image.src = url;
			}
			/* goolge 浏览器图片预览end */
			
			
			var la=$("#large");
			la.hide();
			
			$("#previewImg").mouseenter(function(e){
				la.css({
					top:e.pageY,
					left:e.pageX
				}).html('<img src="'+this.src+'"/>').show();
				
			}).mouseout(function(){
				la.hide();
			});
			
		});
		/*使用js方式实现上传
		function showPreview(obj){
			var str = obj.value;
			document.getElementById("previewImg").innerHTML = 
				"<img src='"+str+"'/>";
		}
		*/
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>   
  	<h2>&nbsp;文件下载</h2>
  	<a href="download.action?filename=img3-lg.jpg">文件下载</a>
  	<hr>
    <h2>图片预览</h2>
    <p><img alt="LargeImage" src="images/img1-lg.jpg" id="largeImg"/></p>
    <p class="thumbs">
    	<a href="images/img2-lg.jpg" title="Image2"><img src="images/img2-thumb.jpg"></a>
    	<a href="images/img3-lg.jpg" title="Image3"><img src="images/img3-thumb.jpg"></a>
    	<a href="images/img4-lg.jpg" title="Image4"><img src="images/img4-thumb.jpg"></a>
    	<a href="images/img5-lg.jpg" title="Image5"><img src="images/img5-thumb.jpg"></a>
    	<a href="images/img6-lg.jpg" title="Image6"><img src="images/img6-thumb.jpg"></a>   	
    </p>
    
  </body>
</html>
