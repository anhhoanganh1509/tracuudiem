
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
             $("#email").keyup(function (e) {
                 clearTimeout(x_timer);
                 var email_name = $(this).val();
                 x_timer = setTimeout(function () {
                     check_emailname_ajax(email_name);
                 }, 1000);
             });
             function check_emailname_ajax(emailname) {
                 $.post('checkEmail', {'emailname': emailname}, function (data) {
                 	if(data.length > 11){
                 		$("#button_register").removeAttr('disabled');
                 		$("#button_register").prop("disabled", true);
                 		$("#msg").show();
                 		$('#email').css({ border: "2px solid red"});
                 	}else{
                 		$("#button_register").removeAttr('disabled');
                 		$("#button_register").prop("disabled", false);
                 		$("#msg").hide();
                 		$('#email').css({ border: "1px solid #dcdcdc"});
                 	}                        
                 });                 
             }
         });
	</script>
</head>
<body>
	<div class="login-form">		
		<form:form 
			action="${root}/createNewUser" 
			modelAttribute="createNewUser" 
			method="POST" 
			autocomplete="off" 
			name='loginForm' >		
			<h2 class="text-center">Register</h2>
			<c:if test="${not empty error}">
				<div style="text-align: center;color: red;">${error}</div>
			</c:if>			
			<div class="form-group">
            	<form:input type="text" class="form-control" path="email" placeholder="Email" />
        	</div>
        	<div class="form-group">
            	<form:input type="text" class="form-control" path="username" placeholder="Mã số sinh viên" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block" id="button_register">Register</button>
            	<div >
            		<label id="msg" style="float: left;color: red;">Invalid email!</label>
            		<a href="${root}/login" style="float: right;color: blue;"><label>Go to login</label></a>
            	</div>
            </div>				
		</form:form>
		
	</div>
</body>
</html>