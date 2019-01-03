
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tra Cứu Điểm</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmd" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<script type="text/javascript" src="${root}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${root}/css/animate.min.css">
<link rel="stylesheet" type="text/css" href="${root}/css/style.css">
</head>
<body style="font-family: Helvetica,Arial,sans-serif;">
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div id="user" class="col-md-12">
				<div class="panel panel-primary panel-table animated slideInDown">
					<div class="panel-heading " style="padding: 5px;">
						<c:if test="${not empty infoStudent}">
							
							<div class="row">
								<div class="col col-xs-4 text-left">
									<a href="javascript:formSubmit()" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
										<i class="fa fa-list-alt"></i>logout
									</a> 
									<script>
										function formSubmit() {
											document.getElementById("logoutForm").submit();
										}
									</script>
									<c:if test="${not empty admin}">
										<form id="logoutForm" action="<c:url value='/j_spring_security_logout' />" method='POST'>					
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										</form>
									</c:if>									
								</div>
								<div class="col col-xs-2 text-left">Bảng ghi điểm học phần</div>
								<div class="col col-xs-6 text-left">Học kỳ 1 - Năm học 2018-2019
									<a href="${root}/changePass" class="btn btn-default" aria-controls="thumb" role="tab" data-toggle="tab" style="text-transform: capitalize;float: right;"> 
										<i class="fa fa-picture-o" aria-hidden="true"></i>change pass
									</a>
								</div>
							</div>
							<c:forEach var="c" items="${infoStudent}" varStatus="itr">
							<c:if test="${empty admin}">
							<div class="row">
								<div class="col col-xs-4 text-left">								
									<form id="logoutForm" action="<c:url value='/j_spring_security_logout' />" method='POST'>					
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									</form>
								</div>
								<div class="col col-xs-2 text-left">Mã sinh viên</div>
								<div class="col col-xs-6 text-left">${c.studentma}</div>
							</div>
							<div class="row">
								<div class="col col-xs-4 text-left"></div>
								<div class="col col-xs-2 text-left">Tên sinh viên</div>
								<div class="col col-xs-6 text-left">${c.lastname}&nbsp;${c.firstname}</div>
							</div>
							<div class="row">
								<div class="col col-xs-4 text-left"></div>
								<div class="col col-xs-2 text-left">Ngày sinh</div>
								<div class="col col-xs-6 text-left"><fmd:formatDate pattern="dd-MM-yyyy" value="${c.dayofbirth}" /></div>
							</div>
							<div class="row">
								<div class="col col-xs-4 text-left"></div>
								<div class="col col-xs-2 text-left">Tên Lớp</div>
								<div class="col col-xs-6 text-left">${c.classname}</div>
							</div>
							</c:if>
							</c:forEach>
						</c:if>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="list">
								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>
											<th>STT</th>
											<c:if test="${empty admin}">
												<th>Tên môn học</th>
												<th>Mã môn học/mã nhóm</th>
												<th>Số tín chỉ</th>
											</c:if>
											<c:if test="${not empty admin}">
												<th>Mã sinh viên</th>
												<th>Tên sinh viên</th>
												<th>Ngày sinh</th>
												<th>Tên Lớp</th>
											</c:if>
											<th>Quá trình</th>
											<th>Giữa kỳ</th>
											<th>Thi</th>
											<th>Ghi chú</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty infoStudent}">
											<c:forEach var="c" items="${infoStudent}" varStatus="itr">
												<tr>
													<td>${itr.index+1}</td>
													<c:if test="${empty admin}">
														<td>Toán Rời Rạc</td>
														<td>DTN0100/01</td>
														<td>3</td>
													</c:if>
													<c:if test="${not empty admin}">
														<td>${c.studentma}</td>
														<td>${c.lastname}&nbsp;${c.firstname}</td>
														<td><fmd:formatDate pattern="dd-MM-yyyy" value="${c.dayofbirth}" /></td>
														<td>${c.classname}</td>
													</c:if>
													<td>${c.process}</td>
													<td>${c.midterm}</td>
													<td>${c.exam}</td>
													<td>${c.note}</td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>
							</div>
							<!-- END id="list" -->
						</div>
						<!-- END tab-content -->
					</div>

				</div>
				<!--END panel-table-->
			</div>
		</div>
	</div>
</body>
</html>