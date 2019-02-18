
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tra Cứu Điểm</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/css/style.css">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
	<script type="text/javascript">
         $(document).ready(function () {
         	$("#msg").hide();
             var x_timer;
             $("#repeatPass").keyup(function (e) {
                 clearTimeout(x_timer);
                 var repeat_Pass = $(this).val();
                 x_timer = setTimeout(function () {
                     check_repeatPass_ajax(repeat_Pass);
                 }, 1000);
             });
             function check_repeatPass_ajax(repeatPass) {
            	 var new_Pass = $("#newPass").val();
            	 if(repeatPass != new_Pass){
            		 $("#button_register").removeAttr('disabled');
              		$("#button_register").prop("disabled", true);
              		$("#msg").show();
              		$('#repeatPass').css({ border: "2px solid red"});
            	 }else{
            		 $("#button_register").removeAttr('disabled');
              		$("#button_register").prop("disabled", false);
              		$("#msg").hide();
              		$('#repeatPass').css({ border: "1px solid #dcdcdc"});
            	 }                
             }
         });
	</script>
</head>
<body>
	<div class="login-form">		
		<form:form 
			action="${root}/jsp/changePassword" 
			method="POST" 
			autocomplete="off" 
			name='loginForm' >		
			<h2 class="text-center">Change Password</h2>
			<c:if test="${not empty error}">
				<div style="text-align: center;color: red;">${error}</div>
			</c:if>			
			<div class="form-group">
            	<input type="password" class="form-control" name="newPass" placeholder="New Password" id="newPass"/>
        	</div>
        	<div class="form-group">
            	<input type="password" class="form-control" name="repeatPass" placeholder="Repeat Password" id="repeatPass"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block" id="button_register">Change Password</button>
            	<div >
            		<label id="msg" style="float: left;color: red;">Passwords Match!</label>
            		<a href="${root}/jsp/index" style="float: right;color: blue;"><label>Back</label></a>
            	</div>
            </div>				
		</form:form>
		
	</div>
</body>
</html>