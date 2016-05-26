<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/2/18
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beehive.bean.User"%>
<%@ page import="beehive.bean.Report"%>
<% User user = (User) request.getSession().getAttribute("user");
if(user == null)
	out.println("User get fail -_-");
String phone = user.getPhone();%>

<% List<Report> reports = (List) request.getSession().getAttribute("reports");
Report report = null;
if(reports == null)
	out.println("Report get fail -_-");

if(!reports.isEmpty())
	 report = reports.get(0);

%>



<html>
<head>
<meta http-equiv="refresh" content="20">
<meta charset="utf-8">
<title>环境监测控制</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/reset.css" rel="stylesheet" type="text/css">
<script src="./js/screem.js"></script>
    <script src="./js/jquery.min.js"></script>
</head>

<body onload="i=0;refreshgraph(i);">
<div class="topdiv">
<p>环境监测系统</p>
</div>


<div class="middiv" >
<div class="midcontentdiv">
	<div class="refreshtable">
	<span>总计：<span id="totalCount">5</span>
	<span>&nbsp;上次更新：<b id="reloadTime">1</b>秒前
	</div>
	<table class="datatable">
    <tr><th>传感器</th><th>数值</th><th>是否正常</th></tr>
    <tr>
    	<td>温度℃</td>
        <td id="tempvalue" style="text-align:center;"><%out.print(report.getTemperature()); %></td>
        <td class="normal" style="text-align:center;" id="temperature">正常</td>
    </tr>
    <tr>
    	<td>湿度%</td>
        <td style="text-align:center;"><%out.print(report.getHumidity()); %></td>
        <td class="normal" style="text-align:center;" id="humidity">正常</td>
    </tr>
    <tr>
    	<td>CO mg/m³</td>
        <td style="text-align:center;">0</td>
        <td class="normal" style="text-align:center;" id="co">——</td>
    </tr>

    <tr>
    	<td>噪声 db</td>
        <td style="text-align:center;"><%out.print(report.getNoise()); %></td>
        <td class="normal" style="text-align:center;" id="noise">正常</td>
    </tr>
     <tr>
    	<td>紫外线 lux</td>
        <td style="text-align:center;"><%out.print(report.getUltraviolet()); %></td>
        <td class="normal" style="text-align:center;" id="ultraviolet">正常</td>
    </tr>
    </table>
    <div style="position:relative;margin-top:0.2rem;">
    
    <!--移植过来的内容-->
    <a href="#col">一氧化碳</a>
<a href="#temper">温度</a>
<a href="#humid">湿度</a>
<a href="#nois">噪音</a>
<a href="#uv">紫外线</a>

<div class="chartdiv" id="co1"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=co" id="p1" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
<div class="chartdiv" id="temper"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=temperature" id="p2" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
<div class="chartdiv" id="humid"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=humidity" id="p3" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>

<div class="chartdiv" id="uv"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=ultraviolet" id="p5" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
<div class="chartdiv" id="nois"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=noise" id="p4" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>   
<div class="chartdiv"></div>
</div>
</div>
</div>




<div class="bottomdiv">
	<div class="bottomicon" id="bottom_icon1" >		
    <img src="./pic/bottom_icon1_touch.png">
    </div>
	<div class="bottomicon" id="bottom_icon2">
    <a href="./history_page.jsp"><img src="./pic/bottom_icon2.png"></a>
    </div>
	<div class="bottomicon" id="bottom_icon3">
    <a href=""><img src="./pic/bottom_icon3.png"></a>
    </div>
</div>

<script>
var i;

  function refreshgraph(i)
  {
    //if(i==0)
    refreshco(i);
    //else if(i==1)
    refreshhumidity(i);
    //else if (i==2)
    refreshnoise(i);
    //else if(i==3)
    refresht(i);
    //else if(i==4)
    refreshuv(i);
  }
  function refreshco(i)
  {
    document.getElementById("p1").src="./display.do?phone=<%=phone%>&device=co&t="+Math.random();
    setTimeout("refreshco(i)", 10000);//10s一刷新
  }
  function refresht(i)
  {
    document.getElementById("p2").src="./display.do?phone=<%=phone%>&device=temperature&t="+Math.random();
    setTimeout("refresht(i)", 10000);
  }
  function refreshhumidity(i)
  {
    document.getElementById("p3").src="./display.do?phone=<%=phone%>&device=humidity&t="+Math.random();
    setTimeout("refreshhumidity(i)", 10000);
  }
  function refreshnoise(i)
  {
    document.getElementById("p4").src="./display.do?phone=<%=phone%>&device=noise&t="+Math.random();
    setTimeout("refreshnoise(i)", 10000);
  }
  function refreshuv(i)
  {
    document.getElementById("p5").src="./display.do?phone=<%=phone%>&device=ultraviolet&t="+Math.random();
    setTimeout("refreshuv(i)", 10000);
  }
   
 var lastUpdateTime = new Date();
      function updateTime() {
      	if((new Date().getTime() - lastUpdateTime.getTime()) / 1000>10)
      	lastUpdateTime = new Date();
        $("#reloadTime").text(parseInt((new Date().getTime() - lastUpdateTime.getTime()) / 1000));

    }
  $(function(){
        setInterval(updateTime,1000);
    });


$(document).ready(function() {  
      
    var value = $("#tempvalue").text();
    if(value>=30)
	{
		$("#temperature").removeClass("nomorl").addClass("abnormal").text("温度高");
	}
	
});  
 
</script>
</body>
</html>
