<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>

<aside class="main-sidebar">
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="index">
				<a href="${pageContext.request.contextPath}/jump/jumpindex">
					<i class="fa fa-list-alt"></i>
					<span>首页</span>
				</a>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-cogs"></i>
					<span>系统管理</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li id="allUser">
						<a href="${pageContext.request.contextPath}/user/allUser">
							<i class="fa fa-circle-o"></i> 用户管理</a>
					</li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-cube"></i>
					<span>商城管理</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li id="allProduct">
						<a href="${pageContext.request.contextPath}/product/allProduct?page=1&size=4">
							<i class="fa fa-circle-o"></i> 商品管理</a>
					</li>
				</ul>
			</li>
		</ul>
	</section>
</aside>