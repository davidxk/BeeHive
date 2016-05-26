<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/2/18
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beehive.bean.User"%>
<% User user = (User) request.getAttribute("user");
if(user == null)
	out.println("User get fail -_-");
String phone = user.getPhone();%>

<html>
<head>
  <title>Insert title here</title>
</head>
<body onload="i=0;refreshgraph(i);">

<a href="#col">一氧化碳</a>
<a href="#temper">温度</a>
<a href="#humid">湿度</a>
<a href="#nois">噪音</a>
<a href="#uv">紫外线</a>

<p id="co1"><img width="800" height="600" src="/display.do?phone=<%=phone%>&device=co" id="p1" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></p>
<p id="temper"><img width="800" height="600" src="/display.do?phone=<%=phone%>&device=temperature" id="p2" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></p>
<p id="humid"><img width="800" height="600" src="/display.do?phone=<%=phone%>&device=humidity" id="p3" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></p>
<p id="nois"><img width="800" height="600" src="/display.do?phone=<%=phone%>&device=noise" id="p4" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></p>
<p id="uv"><img width="800" height="600" src="/display.do?phone=<%=phone%>&device=ultraviolet" id="p5" style="cursor:pointer;" onload="return imgzoom(this,600);" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/></p>

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
</script>

</body>
</html>
