<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<header class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="${pageContext.request.contextPath}/jump/jumpindex" class="navbar-brand"><b>SSM</b>商城</a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                    <i class="fa fa-bars"></i>
                </button>
            </div>

            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/jump/jumpindex">首页 <span class="sr-only">(current)</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jump/jumpfront-allproduct">所有商品</a></li>
                    <!--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">所有分类<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Basketball</a></li>
                                <li class="divider"></li>
                            <li><a href="#">Running</a></li>
                                <li class="divider"></li>
                            <li><a href="#">Football</a></li>
                                <li class="divider"></li>
                            <li><a href="#">Training</a></li>
                        </ul>
                    </li>-->
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <!--<li><a href="#"><span
                            class="fa fa-shopping-bag"></span> 我的订单</a></li>-->
                    <li><a href="${pageContext.request.contextPath}/jump/jumpcart"><span
                            class="fa fa-shopping-cart"></span> 购物车</a>
                    </li>
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                            <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                                 class="user-image" alt="User Image">
                            <span class="hidden-xs">
                                ${username}
                            </span></a>
                        <ul class="dropdown-menu">
                            <li class="user-header"><img
                                    src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                                    class="img-circle" alt="User Image">
                                <a><span class="hidden-xs">${username}</span></a>
                            </li>
                            <li class="user-footer">
                                <div class="pull-right">
                                    <a href="${pageContext.request.contextPath}/user/logout"
                                       class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

