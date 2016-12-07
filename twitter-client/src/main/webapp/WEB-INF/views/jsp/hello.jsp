<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Twitter Connection ----CPSC 476 Grad Project</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Twitter Connection ----CPSC 476 Grad Project</a>
	</div>
  </div>
</nav>
<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>

		<c:if test="${empty name}">
			About Twitter API
		</c:if>
    </p>
    <p>
	<a class="btn btn-default" href="https://dev.twitter.com/docs" role="button">Learn more</a>
    </p>
  </div>
</div>

<div class="container">

  <div class="row">
	<div class="col-md-4">
		<h2>Search by Hashtag</h2>
		<input id="searchHashTag" placeholder="#hashTag"/>	
		<input id= "searchBtn" class="btn btn-primary" type="submit">
	
	</div>
	<div class="col-md-4">
		<h2>Search by Timeline</h2>
  		<form method="POST" action="http://localhost:8080/timeline">
		<input name="username" id="username" type="text" placeholder="Twitter handle">
		<input type="submit" class="btn btn-primary">
		</form>
	</div>
	<div class="col-md-4">
		<h2>Search by User</h2>
		<form method="POST" action="http://localhost:8080/profile">
		<input name="username" id="username" type="text" placeholder="username">
		<input type="submit" class="btn btn-primary">
		</form>
	</div>
  </div>
  <hr>
  <div id="resultArea">
  <ul id="result" class="container">
	<c:forEach items="${tweets}" var="tweet">
        <li>
            <c:out value="${tweet}"/>
        </li>
    </c:forEach>
 </ul>
 </div>
 <div>

  <c:if test="${error}!=null">
  <c:out value="Error:+${error}"/><p>
  </c:if>
         <c:out value="${usernamae}"/>
         <img src="${image}">
         <p>${image}<p>
            <p>${frindCount}<p>
            <p>${followerCount}<p>           
   

  </div>
  <div class="container">
  	<footer>
    	<hr>
		<p>© CPSC-476-Yuting Zhang 2016</p>
  	</footer>
  </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>