<%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/3/1
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>用户注册</title>
    <!--
    <link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/style.css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/userpanel.css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/jquery.ui.all.css" />
    -->
    <link rel="stylesheet" href="../Wopop_files/css/bootstrap.min.css">
    <link rel="stylesheet" href="../Wopop_files/css/main.css">
    <link rel="stylesheet" href="../Wopop_files/css/register.css">
</head>
<!--body>
<form action="/SignupAction" method="post">
    用户名:<input type="text" name="username" required/><br/>
		性别:<input type="text" name="nickname" required/><br>
    密码:<input type="password" name="password" required/><br/>
    <%--年龄:<input type="text" name="age" required/><br>--%>
    <%--出生所在地:<input type="text" name="birthPlace" required/><br>--%>
    <%--注册口令:<input type="text" name="userType" required/><br>--%>
    <input type="submit" value="注册" />
</form>
</body-->
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
        <!--img alt="Brand" src="..."-->
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="../index.jsp">登录</a>
        </li>
        <li>
          <button class="iregister btn btn-info" onClick="javascript:window.location.href='./register.jsp'">注册</button>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="login_m">
    <div class="login_logo">
        <h1>蚂蜂窝</h1>
    </div>

    <div class="login_padding" id="login_model">
        <form action="/SignupAction" method="post">
            <div class="form-group">
                <!--input type="text" name="username" class="form-control" placeholder="请输入用户名（必须以字母开头）"required /-->
                <input type="text" name="phone" class="form-control" placeholder="请输入手机号"required />
            </div>

            <div class="form-group">
                <input type="text" name="nickname" class="form-control" placeholder="请输入昵称" />
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="请输入密码" />
            </div>

            <!--div class="form-group select_list">
                <!--input type="text" name="age" class="form-control" placeholder="请输入年龄" required /-->
                <!--span>年龄区间</span>
                <select name="age">
                    <option value="0-5">0-5岁</option>
                    <option value="6-10">6-10岁</option>
                    <option value="11-15">11-15岁</option>
                    <option value="16-25">16-25岁</option>
                    <option value="21-25">21-25岁</option>
                    <option value="26-30">26-30岁</option>
                    <option value="31-35">31-35岁</option>
                    <option value="26-30">26-30岁</option>
                    <option value="31-35">31-35岁</option>
                    <option value="36-40">36-40岁</option>
                    <option value="41-45">41-45岁</option>
                    <option value="46-50">46-50岁</option>
                    <option value="51-55">51-55岁</option>
                    <option value="56-60">56-60岁</option>
                    <option value="61-65">61-65岁</option>
                    <option value="66-70">66-70岁</option>
                    <option value="71-75">71-75岁</option>
                    <option value="76-80">76-80岁</option>
                    <option value="81-85">81-85岁</option>
                    <option value="86-90">86-90岁</option>
                    <option value="91-95">91-95岁</option>

                </select>
            </div>

            <div class="form-group select_list">
                <span>性别</span>
                <select name="gender">
                    <option value="male">男性</option>
                    <option value="female">女性</option>
                </select>
            </div>

            <div class="form-group select_list">
                <span>籍贯</span>
                <select name="birthplace">
                    <option value="成都">成都</option>
                    <option value="重庆">重庆</option>
                    <option value="乐山">乐山</option>
                    <option value="内江">内江</option>
                </select>
            </div-->
            
            <div class="form-group">
                <input type="submit" value="注册" class="btn btn-info btn-signup" />
            </div>
        </form>
    </div><!--login_model-->
</div><!--login_m end-->

  <footer>
    <div class="container">
      <p>Copyright © 2016 Mafenghive | All Rights Reserved
      <span><a href="http://www.machineilab.org/" target="_blank" title="机器智能实验室" class="link_lab">马蜂窝</a></span>
      </p>
    </div>
  </footer>

<script type="text/javascript" src="../Wopop_files/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../Wopop_files/bootstrap.min.js"></script>
</body>
</html>
