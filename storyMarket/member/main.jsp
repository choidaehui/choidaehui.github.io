<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./view/assets/css/main.css" rel="stylesheet">
</head>
<body>


<%
	// * 스클립틀릿의 코드는 (java/jsp)한번에 실행 가장먼저
	String id = (String)session.getAttribute("id");

	//id의 정보가 없을때, (로그인을 안한경우 다시 로그인 페이지로 이동)
	if(id == null){
		response.sendRedirect("./MemberLogin.me");
	}
%>

<h1 id="h1">로그인 회원 : <%=id%></h1>
<input type="button" value="로그아웃" onclick="location.href='./MemberLogout.me';">


<h1><a href="./MyInfo.me">내 정보 보기</a></h1>

</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./view/assets/css/main.css" rel="stylesheet">
</head>
<body>


<%
	// * 스클립틀릿의 코드는 (java/jsp)한번에 실행 가장먼저
	String id = (String)session.getAttribute("id");

	//id의 정보가 없을때, (로그인을 안한경우 다시 로그인 페이지로 이동)
	if(id == null){
		response.sendRedirect("./MemberLogin.me");
	}
%>

<h1 id="h1">로그인 회원 : <%=id%></h1>
<input type="button" value="로그아웃" onclick="location.href='./MemberLogout.me';">


<h1><a href="./MyInfo.me">내 정보 보기</a></h1>

</body>
>>>>>>> e6cecd277d83b652e245977eca674e0288ab266c
</html>