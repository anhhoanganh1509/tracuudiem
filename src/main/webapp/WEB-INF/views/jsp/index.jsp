<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tra Cứu Điểm</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmd" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page session="true"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/lumen/bootstrap.min.css">
<link rel="stylesheet"
	href="https://daneden.github.io/animate.css/animate.min.css">
<link rel="stylesheet" type="text/css" href="${root}/css/style.css">

</head>
<body style="font-family: Helvetica, Arial, sans-serif;">
	<div class="container" style="margin-top: 20px;">		
		<div class="row">
			<div id="user" class="col-md-12">
				<div class="panel panel-primary panel-table animated slideInDown">
					<div class="panel-heading " style="padding: 5px;">
						<c:if test="${not empty infoStudent}">
							<div class="row">
								<div class="col col-xs-4 text-left">
									<a href="#" class="btn btn-default" aria-controls="list"
										role="tab" data-toggle="tab" style="text-transform: capitalize;" onclick="formSubmit()">
										<i class="fa fa-list-alt"></i>Sign out
									</a>
								</div>
								<div class="col col-xs-2 text-left">Bảng ghi điểm học phần</div>
								<div class="col col-xs-6 text-left">
									<a href="#"
										class="btn btn-default" aria-controls="thumb" role="tab"
										id="abc" data-toggle="tab"
										style="text-transform: capitalize; float: right;"
										onclick="myFunctionChange()"> <i class="fa fa-picture-o"
										aria-hidden="true"></i>change pass
									</a>
									<form id="myFunctionChange"
										action="${root}/jsp/changePass"
										method="POST">
									</form>
								</div>
							</div>								
							<div class="row">
								<div class="col col-xs-4 text-left">
									<form id="logoutForm"
										action="<c:url value='/j_spring_security_logout' />"
										method='POST'>
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
								</div>
								<div class="col col-xs-2 text-left">Mã sinh viên</div>
								<div class="col col-xs-6 text-left">${infoStudent.masinhvien}</div>
							</div>
							<div class="row">
								<div class="col col-xs-4 text-left"></div>
								<div class="col col-xs-2 text-left">Tên sinh viên</div>
								<div class="col col-xs-6 text-left">${infoStudent.hosinhvien}&nbsp;${infoStudent.tensinhvien}</div>
							</div>
							<div class="row">
								<div class="col col-xs-4 text-left"></div>
								<div class="col col-xs-2 text-left">Ngày sinh</div>
								<div class="col col-xs-6 text-left">
									<fmd:formatDate pattern="dd-MM-yyyy" value="${infoStudent.ngaysinh}" />
								</div>
							</div>
							<div class="row">
								<div class="col col-xs-4 text-left"></div>
								<div class="col col-xs-2 text-left">Tên Lớp</div>
								<div class="col col-xs-6 text-left">${infoStudent.lop}</div>
							</div>								
						</c:if>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="list">
								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên môn học</th>
											<th>Mã môn học/mã nhóm</th>
											<th>Số tín chỉ</th>
											<th>Quá trình</th>
											<th>Giữa kỳ</th>
											<th>Thi</th>
											<th>Ghi chú</th>
											<th>Học kỳ</th>
											<th>Năm học</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty infoMonHoc}">
											<c:forEach var="c" items="${infoMonHoc}" varStatus="itr">
												<tr>
													<td>${itr.index+1}</td>
													<td>${c.tenmonhoc}</td>
													<td>${c.mamonhoc}</td>
													<td>${c.sotinchi}</td>
													<td>${c.quatrinh}</td>
													<td>${c.giuaky}</td>
													<td>${c.thi}</td>
													<td>${c.ghichu}</td>
													<td>${c.hocky}</td>
													<td>${c.namhoc}</td>
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
<script>
	function myFunctionChange() {
		document.getElementById("myFunctionChange").submit();
	}
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}	
</script>
</html>