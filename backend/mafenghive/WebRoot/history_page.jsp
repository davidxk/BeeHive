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

<html>
<head>
<meta charset="utf-8">
<title>环境监测控制</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/reset.css" rel="stylesheet" type="text/css">
<script src="./js/screem.js"></script>
<script src="./js/jquery.min.js"></script>
</head>

<body onload="i=0;refreshgraph(i);">
<div class="topdiv">
<p>环境监测系统</p>
</div>

<div class="middiv">
<div class="midcontentdiv">
<p style="font-size:0.1rem; color:#FFFFFF;">123</p>
	<ul class="tabs">  
        <li class="active"><a href="#tab1">温度</a></li>  
        <li><a href="#tab2">湿度</a></li>  
        <li><a href="#tab3">CO1</a></li>
        <li><a href="#tab4">紫外线</a></li>
        <li><a href="#tab5">噪声</a></li>
    </ul>  
     <div class="tab_container">  
        <div id="tab1" class="tab_content" style="display: block; ">  
      	<div class="chartanalyse" id="temper"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=temperature" id="p2" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
        <table class="datatable">
        <tr><th>平均值</th><th>最大值</th><th>最小值</th></tr>
        <tr>
    	<td>28℃</td>
        <td>32℃</td>
        <td>26℃</td>
    	</tr>
        </table>
        <div class="userCount"><span>优于同一城市<span id="userCount" style="font-size:0.2rem">43%</span>的用户
		<span>&nbsp;平均值：<b id="reloadTime">28</b></div>
        </div>  
        <div id="tab2" class="tab_content" style="display: none; ">  
        <div class="chartanalyse" id="humid"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=humidity" id="p3" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
        <table class="datatable">
        <tr><th>平均值</th><th>最大值</th><th>最小值</th></tr>
        <tr>
    	<td>42%</td>
        <td>44%</td>
        <td>39%</td>
    	</tr>
        </table>
        <div class="userCount"><span>优于同一城市<span id="userCount" style="font-size:0.2rem">30%</span>的用户
		<span>&nbsp;平均值：<b id="reloadTime">44</b></div>
        </div>  
        <div id="tab3" class="tab_content" style="display: none; ">  
        <div class="chartanalyse" id="co1"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=co" id="p1" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
        <table class="datatable">
        <tr><th>平均值</th><th>最大值</th><th>最小值</th></tr>
        <tr>
    	<td>0mg/m³</td>
        <td>0mg/m³</td>
        <td>0mg/m³</td>
    	</tr>
        </table>
        <div class="userCount"><span>优于同一城市<span id="userCount" style="font-size:0.2rem">100%</span>的用户
		<span>&nbsp;平均值：<b id="reloadTime">28</b></div>
		<div class="positionwhite"></div>
        </div>  
        <div id="tab4" class="tab_content" style="display: none; ">  
        <div class="chartanalyse" id="uv"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=ultraviolet" id="p5" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>
        <table class="datatable">
        <tr><th>平均值</th><th>最大值</th><th>最小值</th></tr>
        <tr>
    	<td>126</td>
        <td>134</td>
        <td>110</td>
    	</tr>
        </table>
        <div class="userCount"><span>优于同一城市<span id="userCount" style="font-size:0.2rem">23%</span>的用户
		<span>&nbsp;平均值：<b id="reloadTime">28</b></div>
        </div>  
        <div id="tab5" class="tab_content" style="display: none; ">  
        <div class="chartanalyse" id="nois"><img width="400" height="300" src="/display.do?phone=<%=phone%>&device=noise" id="p4" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></div>   
        <table class="datatable">
        <tr><th>平均值</th><th>最大值</th><th>最小值</th></tr>
        <tr>
    	<td>44db</td>
        <td>50db</td>
        <td>40db</td>
    	</tr>
        </table>
        <div class="userCount"><span>优于同一城市<span id="userCount" style="font-size:0.2rem">17%</span>的用户
		<span>&nbsp;平均值：<b id="reloadTime">35</b></div>
		<div class="positionwhite"></div>
        </div>  
    </div>  
    
    
    
</div>
</div>

<div class="bottomdiv">
	<div class="bottomicon" id="bottom_icon1" >		
    <a href="DisplayAction"><img src="./pic/bottom_icon1.png"></a>
    </div>
	<div class="bottomicon" id="bottom_icon2">
    <a href=""><img src="./pic/bottom_icon2_touch.png"></a>
    </div>
	<div class="bottomicon" id="bottom_icon3">
    <a href="StatusAction"><img src="./pic/bottom_icon3.png"></a>
    </div>
</div>


<script type="text/javascript">  
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
    setTimeout("refreshco(i)", 30000);//10s一刷新
  }
  function refresht(i)
  {
    document.getElementById("p2").src="./display.do?phone=<%=phone%>&device=temperature&t="+Math.random();
    setTimeout("refresht(i)", 30000);
  }
  function refreshhumidity(i)
  {
    document.getElementById("p3").src="./display.do?phone=<%=phone%>&device=humidity&t="+Math.random();
    setTimeout("refreshhumidity(i)", 30000);
  }
  function refreshnoise(i)
  {
    document.getElementById("p4").src="./display.do?phone=<%=phone%>&device=noise&t="+Math.random();
    setTimeout("refreshnoise(i)", 30000);
  }
  function refreshuv(i)
  {
    document.getElementById("p5").src="./display.do?phone=<%=phone%>&device=ultraviolet&t="+Math.random();
    setTimeout("refreshuv(i)", 30000);
  }
$(document).ready(function() {  
      
    //On Click Event  
    $("ul.tabs li").click(function() {  
        $("ul.tabs li").removeClass("active"); //Remove any "active" class  
        $(this).addClass("active"); //Add "active" class to selected tab  
        $(".tab_content").hide(); //Hide all tab content  
        var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content  
        $(activeTab).fadeIn(); //Fade in the active content  
        return false;  
    });  
  
});  
</script>  
</body>
</html>
