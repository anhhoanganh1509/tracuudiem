<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Tra Cứu Điểm</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmd" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@page session="true"%>
	<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap.min.css">
	<script src="${root}/js/jquery.min.js"></script>
	<script src="${root}/js/bootstrap.min.js"></script>
	<script src="${root}/js/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${root}/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${root}/css/animate.min.css">
	<link rel="stylesheet" type="text/css" href="${root}/css/style.css">
</head>
<body style="font-family: Helvetica, Arial, sans-serif;">
	<div class="container" style="margin-top: 20px;">
		<!--start them mon -->
		<div id="popupAddNewMonHoc" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Thông tin môn học</h4>
					</div>
					<div class="modal-body">
						<form:form class="form-horizontal" role="form" modelAttribute="popupAddNewMonHoc"
							action="${root}/jsp/popupAddNewMonHoc" method="POST">
							<div class="row">
								<div class="col-sm-6 col-lg-6">
									<div class="form-group">
										<label for="inputEmail" class="col-md-4 control-label"
											style="font-weight: bold;">Mã môn</label>
										<div class="col-md-8">
											<input type="hidden" name="mamonhocChoose" value="${mamonhocChoose}">
											<input type="hidden" name="hockyChoose" value="${hockyChoose}">
											<input type="hidden" name="namhocChoose" value="${namhocChoose}">
											<form:input type="text" class="form-control" path="mamonhoc" required="required"/>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-lg-6">
									<div class="form-group">
										<label for="inputPassword" class="col-md-4 control-label"
											style="font-weight: bold;">Tên môn</label>
										<div class="col-md-8">
											<form:input type="text" class="form-control" path="tenmonhoc" required="required"/>
										</div>
									</div>
								</div>
							</div>							
							<button type="submit" class="btn btn-lg btn-success btn-block"
								id="btnContactUs">submit &rarr;</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!--end them mon -->
		<!--start them sinh vien -->
		<div id="popupAddNewSinhVien" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Thông tin sinh viên</h4>
					</div>
					<div class="modal-body">
						<form:form class="form-horizontal" role="form" modelAttribute="popupAddNewSinhVien"
						action="${root}/jsp/popupAddNewSinhVien" 
						method="POST" >
							<div class="row">
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Học kỳ</label>
										<div class="col-md-9">
											<form:select path="hocky" class="form-control" style="cursor:pointer;">
											  <form:option value="1">Kỳ 1</form:option>
											  <form:option value="2">Kỳ 2</form:option>
											</form:select>
										</div>										
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Năm học</label>
										<div class="col-md-9">
											<form:select path="namhoc" class="form-control" style="cursor:pointer;" >
											  <form:option value="2018-2019">2018-2019</form:option>
											  <form:option value="2019-2020">2019-2020</form:option>
											  <form:option value="2020-2021">2020-2021</form:option>
											</form:select>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">TC</label>
										<div class="col-md-8">
											<form:input type="text" class="form-control" path="sotinchi" required="required"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Môn</label>
										<div class="col-md-9">
											<form:select path="mamonhoc" class="form-control" style="cursor:pointer;">                   
												<c:forEach items="${finbyMonHocList}" var="c">
													<form:option value="${c.mamonhoc}">${c.tenmonhoc}</form:option>
												</c:forEach>
											</form:select>
										</div>										
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Lớp</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" path="lop"/>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Mã SV</label>
										<div class="col-md-8">
											<input type="hidden" name="mamonhocChoose" value="${mamonhocChoose}">
											<input type="hidden" name="hockyChoose" value="${hockyChoose}">
											<input type="hidden" name="namhocChoose" value="${namhocChoose}">
											<form:input type="text" class="form-control" path="masinhvien" required="required"/>
										</div>
									</div>
								</div>
							</div>	
							<div class="row">
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Họ</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" path="hosinhvien" required="required"/>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Tên</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" path="tensinhvien" required="required"/>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Ng sinh</label>										
										<div id="datepicker" class="col-md-8 input-group date" data-date-format="dd/mm/yyyy"> 
											<input class="form-control" readonly type="text" name="ngaysinhNew"> 
											<span class="input-group-addon"></span> 
										</div>
									</div>
								</div>
							</div>	
							<div class="row">
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">QT</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" path="quatrinh"/>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">GK</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" path="giuaky"/>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Thi</label>										
										<div class="col-md-8">
											<form:input type="text" class="form-control" path="thi"/>
										</div>
									</div>
								</div>
							</div>							
							<button type="submit" class="btn btn-lg btn-success btn-block" id="btnContactUs">submit &rarr;</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!--end them sinh vien -->
		<!--start import sinh vien -->
		<div id="popupImportStudent" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Thông tin sinh viên</h4>
					</div>
					<div class="modal-body">
						<form:form class="form-horizontal" role="form" modelAttribute="popupAddNewSinhVien"
						action="${root}/jsp/popupImportStudent" 
						enctype="multipart/form-data"
						method="POST" >
							<div class="row">
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Học kỳ</label>
										<div class="col-md-8">
											<form:select path="hocky" class="form-control" style="cursor:pointer;">
											  <form:option value="1">Kỳ 1</form:option>
											  <form:option value="2">Kỳ 2</form:option>
											</form:select>
										</div>										
									</div>
								</div>
								<div class="col-sm-5 col-lg-5">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Năm học</label>
										<div class="col-md-8">
											<form:select path="namhoc" class="form-control" style="cursor:pointer;" >
											  <form:option value="2018-2019">2018-2019</form:option>
											  <form:option value="2019-2020">2019-2020</form:option>
											  <form:option value="2020-2021">2020-2021</form:option>
											</form:select>
										</div>
									</div>
								</div>
								<div class="col-sm-3 col-lg-3">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">TC</label>
										<div class="col-md-8">
											<form:input type="text" class="form-control" path="sotinchi" required="required"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4 col-lg-4">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Môn</label>
										<div class="col-md-8">
											<form:select path="mamonhoc" class="form-control" style="cursor:pointer;">                   
												<c:forEach items="${finbyMonHocList}" var="c">
													<form:option value="${c.mamonhoc}">${c.tenmonhoc}</form:option>
												</c:forEach>
											</form:select>
										</div>										
									</div>
								</div>
								<div class="col-sm-5 col-lg-5">
									<div class="form-group">
										<label class="col-md-4 control-label" style="font-weight: bold;">Import SV</label>
										<div class="col-md-8">
											<input type="hidden" name="mamonhocChoose" value="${mamonhocChoose}">
											<input type="hidden" name="hockyChoose" value="${hockyChoose}">
											<input type="hidden" name="namhocChoose" value="${namhocChoose}"> 
											<input type="file" class="form-control" name="fileUpload" >											
										</div>
									</div>
								</div>
								<div class="col-sm-3 col-lg-3">
								</div>
							</div>		
							<button type="submit" class="btn btn-lg btn-success btn-block" id="btnContactUs" >submit &rarr;</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!--end import sinh vien -->
		<!--start cap nhat diem -->
		<div id="popupCapNhatDiem" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Cập nhật điểm</h4>
					</div>
					<div class="modal-body">
						<form:form class="form-horizontal" role="form" modelAttribute="popupCapNhatDiem"
						action="${root}/jsp/popupCapNhatDiem" 
						method="POST" >
							<div class="row">
								<div class="col-sm-3 col-lg-3">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Mã</label>
										<div class="col-md-9">
											<input type="hidden" id="mamonhoc" name="mamonhoc" value="${mamonhocChoose}">
											<input type="hidden" id="hocky" name="hocky" value="${hockyChoose}">
											<input type="hidden" id="namhoc" name="namhoc" value="${namhocChoose}">
											<input type="text" class="form-control" id="masinhvienDiem" name="masinhvien" readonly/>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-lg-6">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Tên</label>
										<div class="col-md-9">
											<input type="text" class="form-control" id="tensv" readonly>
										</div>
									</div>
								</div>
								<div class="col-sm-3 col-lg-3">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Lớp</label>
										<div class="col-md-9">
											<input type="text" class="form-control" id="lopsv" readonly>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3 col-lg-3">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">QT</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" id="quatrinhsv" path="quatrinh" />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-lg-6">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">G.kỳ</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" id="giuakysv" path="giuaky"/>
										</div>
									</div>
								</div>
								<div class="col-sm-3 col-lg-3">
									<div class="form-group">
										<label class="col-md-3 control-label" style="font-weight: bold;">Thi</label>
										<div class="col-md-9">
											<form:input type="text" class="form-control" id="thisv" path="thi"/>
										</div>
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-lg btn-success btn-block" id="btnContactUs">submit &rarr;</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!--end cap nhat diem -->
		<div class="row">
			<div id="user" class="col-md-12">
				<div class="panel panel-primary panel-table animated slideInDown">
					<div class="panel-heading " style="padding: 5px;">
						<c:if test="${not empty admin}"><br>
							<div class="row">
								<div class="col col-xs-6 text-left">
									<div class="col col-xs-3 text-left">
										<a href="#" class="btn btn-default" aria-controls="list"
											role="tab" data-toggle="tab"
											style="text-transform: capitalize;" onclick="formSubmitViewStudent()">
											<i class="fa fa-list-alt"></i>Hiển thị
										</a>
									</div>
									<form:form id="formSubmitViewStudent"
											action="${root}/jsp/formSubmitViewStudent" modelAttribute="popupAddNewMonHoc"
											method="POST">		
										<div class="col col-xs-3 text-left">
											<form:select path="mamonhoc" id="mamonhoc" class="form-control" style="cursor:pointer;">
												<form:option value="0">Chọn Môn</form:option>                   
												<c:forEach items="${finbyMonHocList}" var="c">
													<c:choose>
														<c:when test="${c.mamonhoc == mamonhocChoose}">
															<form:option value="${c.mamonhoc}" selected="true">${c.tenmonhoc}</form:option>
														</c:when>
														<c:otherwise>
															<form:option value="${c.mamonhoc}">${c.tenmonhoc}</form:option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</form:select>
										</div>	
										<div class="col col-xs-3 text-left">
											<select name="hocky" id="hocky" class="form-control" style="cursor:pointer;">
											  <option value="0">Chọn Kỳ</option>
											  <option value="1" <%=request.getAttribute("hockyChoose").equals("1") ? "selected" : ""%>>Kỳ 1</option>
											  <option value="2" <%=request.getAttribute("hockyChoose").equals("2") ? "selected" : ""%>>Kỳ 2</option>
											</select>
										</div>
										<div class="col col-xs-3 text-left">
											<select name="namhoc" id="namhoc" class="form-control" style="cursor:pointer;" >
											  <option value="0">Chọn Năm</option>
											  <option value="2018-2019" <%=request.getAttribute("namhocChoose").equals("2018-2019") ? "selected" : ""%>>2018-2019</option>
											  <option value="2019-2020" <%=request.getAttribute("namhocChoose").equals("2019-2020") ? "selected" : ""%>>2019-2020</option>
											  <option value="2020-2021" <%=request.getAttribute("namhocChoose").equals("2020-2021") ? "selected" : ""%>>2020-2021</option>
											</select>
										</div>
									</form:form>
									<!--  -->
									<form id="formSubmitFormReady"
											action="${root}/jsp/formSubmitViewStudent" 
											method="POST">		
										<input type="hidden" id="adminChooseReadyAction" value="${adminChooseReadyAction}">
										<input type="hidden" id="mamonhoc" name="mamonhoc" value="${mamonhocChooseReadyAction}">
										<input type="hidden" id="hocky" name="hocky" value="${hockyChooseReadyActionAction}">
										<input type="hidden" id="namhoc" name="namhoc" value="${namhocChooseReadyActionAction}">
									</form>
									<!--  -->
								</div>
								<div class="col col-xs-6 text-left">
									<div class="col col-xs-3 text-left">
										<button type="button" class="btn btn-default" style="text-transform: capitalize;"
												data-toggle="modal" data-target="#popupAddNewMonHoc" >
												Thêm Môn</button>	
									</div>
									<div class="col col-xs-3 text-left">
										<button type="button" class="btn btn-default" style="text-transform: capitalize;"
												data-toggle="modal" data-target="#popupAddNewSinhVien" >
												Thêm SV</button>
									</div>
									<div class="col col-xs-3 text-left">
										<button type="button" class="btn btn-default" style="text-transform: capitalize;"
												data-toggle="modal" data-target="#popupImportStudent" >
												Import SV</button>
									</div>
									<div class="col col-xs-3 text-left">
										<a href="#" class="btn btn-default" aria-controls="list"
											role="tab" data-toggle="tab" 
											style="text-transform: capitalize;" onclick="formSubmit()">
												Thoát
										</a>
										<form id="logoutForm"
											action="<c:url value='/j_spring_security_logout' />"
											method='POST'>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</div>
									<%-- <div class="col col-xs-3 text-left">
										<a href="#" class="btn btn-default" aria-controls="list"
											role="tab" data-toggle="tab"
											style="text-transform: capitalize;" onclick="myFunctionChange()">
												Đổi Pas
										</a>
										<form id="myFunctionChange"
											action="${root}/jsp/changePass"
											method="POST">
										</form>
									</div> --%>
								</div>
							</div><br>													
						</c:if>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="list">
								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>
											<th>STT</th>
											<th>Mã sinh viên</th>
											<th>Tên sinh viên</th>
											<th>Ngày sinh</th>
											<th>Tên Lớp</th>
											<th>Quá trình</th>
											<th>Giữa kỳ</th>
											<th>Thi</th>
											<th>Ghi chú</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody style="cursor:pointer;">
										<c:if test="${not empty finbyViewMonHocList}">
											<c:forEach var="c" items="${finbyViewMonHocList}" varStatus="itr">
												<tr>
													<td>${itr.index+1}</td>
													<td>${c.masinhvien}</td>
													<td>${c.hosinhvien} ${c.tensinhvien}</td>
													<td><fmd:formatDate pattern="dd-MM-yyyy" value="${c.ngaysinh}" /></td>
													<td>${c.lop}</td>
													<td>${c.quatrinh}</td>
													<td>${c.giuaky}</td>
													<td>${c.thi}</td>
													<td>${c.ghichu}</td>
													<td>
														<button type="button" class="btn btn-info btn-lg" style="text-transform: capitalize;"
															data-toggle="modal" data-target="#popupCapNhatDiem" title="Sửa">
															Sửa</button>
													</td>
													<td>
														<button type="button" class="btn btn-info btn-lg btn-warning" style="text-transform: capitalize;"
															data-toggle="modal" data-target="#" title="Xóa" onclick="myFunctionDelete()">
															Xóa</button>
														<form id="myFunctionDelete"
															action="${root}/jsp/myFunctionDelete"
															method="POST">
															<input type="hidden" id="mamonhoc" name="mamonhoc" value="${mamonhocChoose}">
															<input type="hidden" id="hocky" name="hocky" value="${hockyChoose}">
															<input type="hidden" id="namhoc" name="namhoc" value="${namhocChoose}">
															<input type="hidden" id="myFunctionDelete" name="myFunctionDelete" value="${c.masinhvien}">
														</form>
														
													</td>
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

	jQuery(document).ready(function() {		
		if(document.getElementById("adminChooseReadyAction").value.length > 0){
			document.getElementById("formSubmitFormReady").submit();
		}		
		
	});
	
	function formSubmitViewStudent() {
		document.getElementById("formSubmitViewStudent").submit();
	}

	function myFunctionChange() {
		document.getElementById("myFunctionChange").submit();
	}
	
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}

	var table = document.getElementsByTagName("table")[0];
	var tbody = table.getElementsByTagName("tbody")[0];
	tbody.onclick = function (e) {
	    e = e || window.event;
	    var data = [];
	    var target = e.srcElement || e.target;
	    while (target && target.nodeName !== "TR") {
	        target = target.parentNode;
	    }
	    if (target) {
	        var cells = target.getElementsByTagName("td");
	        for (var i = 0; i < cells.length; i++) {
	            data.push(cells[i].innerHTML);
	        }
	    }
	    for (var i=0; i<data.length; i++) {
	    	data.push(data.slice(i,i++));
	    }
	    document.getElementById("masinhvienDiem").value = data[1];
	    document.getElementById("tensv").value = data[2];
	    document.getElementById("lopsv").value = data[4];
	    document.getElementById("quatrinhsv").value = data[5];
	    document.getElementById("giuakysv").value = data[6];
	    document.getElementById("thisv").value = data[7];
	};		
	
	function myFunctionDelete() {
		document.getElementById("myFunctionDelete").submit();
	}
	
	$(function () {  
		$("#datepicker").datepicker({         
		autoclose: true,         
		todayHighlight: true 
		}).datepicker('update', new Date());
		});
	 
</script>
<link rel="stylesheet prefetch" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
</html>