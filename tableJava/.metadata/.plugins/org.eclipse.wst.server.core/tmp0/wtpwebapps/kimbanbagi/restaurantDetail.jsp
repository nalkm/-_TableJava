<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="restaurantDetail">
		<input type="submit" value="submit">
	</form>
	<h1>Restaurant Details</h1>
  <p>Restaurant Name: ${restaurant.r_name}</p>
  <p>Restaurant Head: ${restaurant.r_head}</p>
  <p>Restaurant City: ${restaurant.r_city}</p>
  <p>Restaurant Address: ${restaurant.r_address}</p>
  <p>Restaurant Number: ${restaurant.r_number}</p>
  <p>Restaurant Status: ${restaurant.r_status}</p>
  <p>Waiting Status: ${restaurant.w_status}</p>
</body>
</html>