<%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/3/1
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>四川话语音数据采集平台</title>
    <!--
    <link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/style.css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/userpanel.css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/jquery.ui.all.css" />
    -->
    <link rel="stylesheet" href="./Wopop_files/css/bootstrap.min.css">
    <link rel="stylesheet" href="./Wopop_files/css/main.css">
    <script type="text/javascript">
      function register()
      {
        document.LoginForm.action="/page/register.jsp";
        document.LoginForm.submit();
      }
    </script>
  </head>

  <body class="login">
  <!--导航条-->
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">
        <!--img alt="Brand" src="./Wopop_files/pic/logo-square1.png"-->
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="./index.jsp">登录</a>
        </li>
        <li>
          <button class="iregister btn btn-info" onClick="javascript:window.location.href='./page/register.jsp'">注册</button>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

  <div class="container login_m">
    <div class="login_logo">
      <h1>马蜂窝</h1>
    </div><!--login_logo-->

    <div class="login_padding" id="login_model">

      <form action="/servlet/LoginAction" name="LoginForm" method="post">

          <!--<p style="font-size: 18px">用户登录</p>-->
          <div class="form-group">
            <!--input pattern="([a-z]|[A-Z])+[0-9]*" type="text" name="username" class="form-control"
             placeholder="用户名（字母开头）" title="只支持以英文字符开头加数字的形式" required /-->
            <input pattern="[0-9]*" type="text" name="phone" class="form-control"
                   placeholder="手机号" required />
          </div>

          <div class="form-group">
            <input type="password" name="password"  class="form-control"
             placeholder="密码" required />
          </div>
        <div class="form-group">
            <input type="submit" value="登录" onclick="login();" 
            class="btn btn-info btn-signup" />
          </div>

      </form>
    </div><!--login_model-->
  </div><!--login_m end-->

  <footer>
    <div class="container">
      <p>Copyright © 2016 Mafenghiv | All Rights Reserved
      <span><a href="http://www.machineilab.org/" target="_blank" title="机器智能实验室" class="link_lab">马蜂窝组</a></span>
      </p>
    </div>
  </footer>

<script type="text/javascript" src="./Wopop_files/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="./Wopop_files/bootstrap.min.js"></script>

  </body>
</html>
