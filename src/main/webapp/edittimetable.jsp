<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Edit Time Table</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-shadow: 0;
}

.main-container {
	margin: auto;
	border: 1px solid black;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}
.ssm {
	width: 60px;
	height: 60px;
	border-radius: 30px;
	background-color: #919499;
}

.ssm img {
	max-width: 100%;
	border-radius: 30px;
}

.header {
	background-color: #f0f0f0;
	display: flex;
	justify-content: end;
	padding: 5px 10px;
	align-items: center;
}

.user-info {
	padding: 2px 30px;
	font-size: 17px;
	color: initial;
}

.image {
	width: 60px;
	height: 60px;
	border-radius: 30px;
	background-color: #919499;
}

.image img {
	max-width: 100%;
	border-radius: 30px;
}

.image1 {
	align-items: center;
	width: 100%;
	height: 60px;
	border-radius: 30px;
	display: flex;
	justify-content: center;
}

.image1 img {
	max-width: 100%;
	border-radius: 50px;
	height: 80px;
	background-color: #919499;
}

.container {
	flex-grow: 1;
	background-color: #b0afac;
	text-align: center;
	color: white;
	padding: 10px 10px;
}

.content{
margin-top: 30px;
}

.form-container {
	margin-top: 20px;
	display: flex;
	justify-content: center;
}

form {
	width: 25%;
	height: 100vh;
}

label {
	display: flex;
	margin-bottom: 5px;
	font-family: cursive;
}

.username {
	margin-top: 20px;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

button {
	padding: 10px 20px;
	border: none;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: #0056b3;
}

footer {
	width: 100%;
	text-align: center;
	background-color: #d6d5d2;
	padding: 10px 0;
	border-top: 1px solid #ccc;
	position: fixed;
	bottom: 0;
}
</style>
</head>
<body>
	<div class="main-container">
		<div class="container">
			           <div class="header" style="display: flex; justify-content: space-between;">
				<div>
					<div class="ssm">
						<img src="SSM.png" draggable="false" alt="SSM Image">
					</div>
				</div>
				<div>
					<div style="display: flex;align-items: center">
						<div class="user-info">
							<p>Username: ${username}</p>
							<p>Role: ${role}</p>
						</div>

						<div class="image">
							<a href="EditProfileServlet?username=${username}"><img
								src="Profile.png" draggable="false" alt="Profile Image"></a>
						</div>
					</div>
				</div>
			</div>
			<div class="content">
				<h2>Edit Time Table</h2>
				<div class="form-container">
					<form action="EditTimeTableServlet" method="POST">
						<input type="hidden" name="day" value="${timetableEntry.day}">
						
						<label for="period1" class="username">Period 1:</label> 
						<input
							type="text" id="period1" name="period1" value="${timetableEntry.period1}"
							required> 
						
						<label for="period2">Period 2:</label> 
						<input
							type="text" id="period2" name="period2" value="${timetableEntry.period2}"
							required> 
							
							<label for="period3">Period 3:</label> 
							<input
							type="text" id="period3" 
							name="period3" value="${timetableEntry.period3}"required>
							
							 <label
							for="period4">Period 4:</label> 
							<input type="text" id="period4"
							name="period4" value="${timetableEntry.period4}" required> 
							
							<label
							for="period5">Period 5:</label> 
							<input type="text"
							id="period5" name="period5" value="${timetableEntry.period5}" required> 
							
							<label
							for="period6">Period 6:</label> 
							<input type="text" id="period6"
							name="period6" value="${timetableEntry.period6}" required> 
							
							<label
							for="period7">Period 7:</label> 
							<input type="text"
							id="period7" name="period7"value="${timetableEntry.period7}"  required>
							
							
						<button type="submit">Save Changes</button>
					</form>
				</div>
			</div>
		</div>
		<footer>
			<p>© 2024 Admin Dashboard. All rights reserved.</p>
		</footer>
	</div>
</body>
</html>
