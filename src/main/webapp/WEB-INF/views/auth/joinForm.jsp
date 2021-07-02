<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<!-- ﻿username=머시기&password=머시기&email=머시기&address=머시기 -->
	<form action="/auth/join" method="post">
		<div class="form-group">
			<label for="Username">Username:</label> <input type="text" class="form-control" placeholder="Enter Username" name="username">
		</div>
		<div class="form-group">
			<label for="Password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" name="password">
		</div>
		<div class="form-group">
			<label for="Email">Email :</label> <input type="email" class="form-control" placeholder="Enter email" name="email">
		</div>
		<div class="form-group">
			<label for="Addr">Address :</label> <input type="text" class="form-control" placeholder="Enter address" name="address">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		
	</form>

</div>



<%@ include file="../layout/footer.jsp"%>