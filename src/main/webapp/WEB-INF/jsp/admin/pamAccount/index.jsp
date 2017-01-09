<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/projects.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 项目</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/resource/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/resource/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="/resource/css/animate.min.css" rel="stylesheet">
    <link href="/resource/css/style.min862f.css?v=4.1.0" rel="stylesheet">


</head>

<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInUp">
    <div class="row">
        <div class="col-sm-12">

            <div class="ibox">
                <div class="ibox-title">
                    <h5>所有项目</h5>
                    <div class="ibox-tools">
                        <a href="<%=basePath%>admin/pamAccount/add.html" class="btn btn-primary btn-xs">创建用户</a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-md-1">
                            <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i
                                    class="fa fa-refresh"></i> 刷新
                            </button>
                        </div>
                        <div class="col-md-11">
                            <div class="input-group">
                                <input type="text" placeholder="请输入项目名称" class="input-sm form-control"> <span
                                    class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
                            </div>


                        </div>
                    </div>

                    <div class="project-list">

                        <table class="table table-hover">
                            <tbody>
                            <c:forEach var="obj" items="${accountVoList}">
                                <tr>
                                    <td class="project-status">
                                            <span class="label label-primary">${obj.getAccountType()}
                                    </td>
                                    <td class="project-title">
                                        <a href="project_detail.html">${obj.getLoginName()}</a>
                                        <br/>
                                        <jsp:setProperty name="dateValue" property="time" value="${obj.getCreatetime()}000"/>
                                        <small>创建于<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:mm:ss" type="both"/></small>
                                    </td>
                                    <td class="project-completion">
                                        <small>Email：${obj.getEmail()} </small>
                                        <%--<div class="progress progress-mini">
                                            <div style="width: 48%;" class="progress-bar"></div>
                                        </div>--%>
                                    </td>
                                    <td class="project-people">
                                       ${obj.getAddr()}
                                    </td>
                                    <td class="project-actions">
                                        <a href="<%=basePath%>admin/pamAccount/delete.html?accountId=${obj.getAccountId()}" class="btn btn-white btn-sm"><i
                                                class="fa fa-folder"></i>删除 </a>
                                        <a href="<%=basePath%>admin/pamAccount/edit.html?accountId=${obj.getAccountId()}" class="btn btn-white btn-sm"><i
                                                class="fa fa-pencil"></i> 编辑 </a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resource/js/jquery.min.js?v=2.1.4"></script>
<script src="/resource/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/resource/js/content.min.js?v=1.0.0"></script>
<script>
    $(document).ready(function () {
        $("#loading-example-btn").click(function () {
            btn = $(this);
            simpleLoad(btn, true);
            simpleLoad(btn, false)
        })
    });
    function simpleLoad(btn, state) {
        if (state) {
            btn.children().addClass("fa-spin");
            btn.contents().last().replaceWith(" Loading")
        } else {
            setTimeout(function () {
                btn.children().removeClass("fa-spin");
                btn.contents().last().replaceWith(" Refresh")
            }, 2000)
        }
    }
    ;
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

<!-- Mirrored from www.zi-han.net/theme/hplus/projects.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
</html>
