<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 태그 라이브러리 지시자: jsp페이지 처리 전 알고 있어야 하는 정보  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="test" value="Hello JSTL!" scope="page" />
	<c:set scope="session" var="test" value="admin" />
	<c:out value="${test}" />
	<br>
	<c:out value="${sessionScope.test}" />
	<br>
	<c:remove var="test" scope="session" />
	<br>
	<!-- 해당하는 이름의 모든 영역 객체 삭제 -->
	<c:out value="${test}" />
	<br>
	<c:if test="${5<10}">
		<h3>5는 10보다 작다</h3>
	</c:if>
	<c:choose>
		<c:when test="${5+10 == 50 }">
			<h3>5+10은 50이다</h3>
		</c:when>
		<c:otherwise>
			<h3>5+10은 50이 아니다</h3>
		</c:otherwise>
	</c:choose>
	<c:forEach begin="1" end="10" step="2" var="i">
	${pageScope.i} 
</c:forEach>
	<br>
	<c:forTokens items="a,b,c,d,e,f,g" delims="," var="alphabet">
		<b>${alphabet } </b> &nbsp;
</c:forTokens>
	<br>
	<%
	  List<String> list = new ArrayList<String>();
	  list.add(0, "aaa");
	  list.add(1, "bbb");
	  list.add(2, "ccc");

	  pageContext.setAttribute("strList", list);
	%>
	<%-- <c:set var="strList" value="${list }"/> --%>
	<c:forEach items="${strList }" var="str">
	${str}	&nbsp; 
</c:forEach>
	<br>
</body>
</html>