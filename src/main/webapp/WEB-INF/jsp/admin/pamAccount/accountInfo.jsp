<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_validate.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/resource/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/resource/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/resource/css/animate.min.css" rel="stylesheet">
    <link href="/resource/css/style.min862f.css?v=4.1.0" rel="stylesheet">

    <link href="/resource/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="/resource/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>添加新的用户</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="signupForm" action="<%=basePath%>admin/pamAccount/save.json"
                          method="post">
                        <input value="${account.getAccountId()}" name="accountId"  type="hidden">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登录名称：</label>
                            <div class="col-sm-8">
                                <input <%--id="username"--%> name="username" value="${account.getLoginName()}"
                                       class="form-control" type="text" <%--aria-required="true" aria-invalid="true"--%>
                                       class="error">
                            </div>
                        </div>
                        <c:if test="${account.getAccountId()==null}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-8">
                                    <input id="password" name="password" class="form-control" type="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">确认密码：</label>
                                <div class="col-sm-8">
                                    <input id="confirm_password" name="confirm_password" class="form-control"
                                           type="password">
                                    <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>
                                </div>
                            </div>
                         </c:if>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">E-mail：</label>
                            <div class="col-sm-8">
                                <input id="email" name="email"  class="form-control" type="email" value="${account.getEmail()}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别：</label>
                            <div class="radio">

                                    <label>
                                        <input type="radio" value="1" id="optionsRadios2" name="sex" <c:if test="${account.getSex()=='1'}">checked="checked" </c:if>>女</label>
                                <label>
                                    <input type="radio"  value="0" id="optionsRadios1" name="sex" <c:if test="${!account.getSex()=='0'}">checked="checked" </c:if>>男</label>

                            </div>

                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">地址：</label>
                            <div class="col-sm-8">
                                <input id="address" name="addr"  class="form-control" type="address" value="${account.getAddr()}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" class="checkbox" id="agree" name="agree">
                                        我已经认真阅读并同意《H+使用协议》
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resource/js/jquery.min.js?v=2.1.4"></script>
<script src="/resource/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/resource/js/content.min.js?v=1.0.0"></script>
<script src="/resource/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/resource/js/plugins/validate/messages_zh.min.js"></script>
<%--<script src="/resource/js/demo/form-validate-demo.min.js"></script>--%>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--弹出框-->
<script src="/resource/js/plugins/sweetalert/sweetalert.min.js"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_validate.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:16 GMT -->
</html>
<script>
    $.validator.setDefaults({
            //后台提交
        submitHandler:function(form){
            $.ajax({
                url: $("#signupForm").attr("action"),
                dataType: 'json',
                data: $("#signupForm").serialize(),
                type: 'POST',
                success: function (result) {
                    if (result.success == true) {
                        window.location = "/admin/pamAccount/index.html";
                    } else {
                        //弹出框显示警告信息
                        swal({
                            title: result.message,
                            text: "请点击ok，重新填写",
                        });
                    }

                },
            });
        }
    });
    /*验证数据*/
    $().ready(function () {
        var e = "<i class='fa fa-times-circle'></i> ";
        $("#signupForm").validate({
            rules: {
                username: {required: !0, minlength: 4},
                password: {required: !0, minlength: 5},
                confirm_password: {required: !0, minlength: 5, equalTo: "#password"},
                email: {required: !0, email: !0},
                agree: "required"
            },
            messages: {
                username: {required: e + "请输入您的用户名", minlength: e + "用户名必须4个字符以上"},
                password: {required: e + "请输入您的密码", minlength: e + "密码必须5个字符以上"},
                confirm_password: {required: e + "请再次输入密码", minlength: e + "密码必须5个字符以上", equalTo: e + "两次输入的密码不一致"},
                email: e + "请输入您的E-mail",
                agree: {required: e + "必须同意协议后才能注册", element: "#agree-error"}
            }
        })
    });
</script>