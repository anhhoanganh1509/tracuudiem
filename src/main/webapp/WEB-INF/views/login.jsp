
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
</head>
<body>
	<div class="login-form">		
		<form:form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST' autocomplete="off">			
			<h2 class="text-center">Log in</h2>
			<c:if test="${not empty error}">
				<div style="text-align: center;color: red;">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div style="text-align: center;color: blue;">${msg}</div>
			</c:if>
			<div class="form-group">
            	<input type="text" class="form-control" name="username" placeholder="Username" >
        	</div>
        	<div class="form-group">
            	<input type="password" class="form-control" name="password" placeholder="Password">
			</div>
			<div class="form-group">
            	<button type="submit" class="btn btn-primary btn-block">Log in</button>
            	<div style="text-align: right;color: black;">
            		Don’t have an account? <a href="${root}/registerAccount"><label>register</label></a>
            	</div>
            </div>				
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
		
	</div>
</body>
</html>