<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 마이 페이지</title>
<link rel="stylesheet" type="text/css" href="css/myPage.css">
</head>
<body>
    <div class="container">
        <header>
            <nav>
                <ul>
                    <li><a href="main.jsp">메인 화면</a></li>
                    <li><a href="reservation.jsp">예약 화면</a></li>
                    <li><a href="notifications.jsp">알림 화면</a></li>
                    <li><a href="myPage.jsp" class="active">마이 페이지</a></li>
                </ul>
            </nav>
        </header>
        <section class="profile">
            <div class="profile-pic">
                <!-- User profile picture -->
                <img src="user_pic.jpg" alt="User Profile Picture">
            </div>
            <div class="profile-info">
                <!-- User ID and Name -->
                <h2>${requestScope.userId}</h2>
                <p>${requestScope.userName}</p>
                <button onclick="location.href='editProfile.jsp'">프로필 수정</button>
            </div>
        </section>
        <section class="history">
            <!-- User's used store history -->
            <h3>사용한 매장 내역</h3>
            <form method="post" action="MyPage">
            	<button type="submit" value="test"></button>
            </form>
            식당 이름: ${history.restaurant_name }<br>
            인원 수: ${history.a_count + history.k_count }<br>
            예약 상태: ${history.status } 
        </section>
        <button onclick="location.href='logout.jsp'">로그아웃</button>
    </div>
</body>
</html>