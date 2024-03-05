<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Edit Profile</title>
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

input[type="text"],  input[type="date"]  {
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
				<h2>Edit Profile</h2>
				<div class="form-container">
					<form action="EditStudentServlet" method="POST">
						<div class="image1">
							<img src="Profile.png" alt="Profile Image">
						</div>
						<input type="hidden" name="userid" value="${userid}">
						
						<label for="rollnumber" class="username">Roll Number:</label> 
						<input
							type="text" id="rollnumber" name="rollnumber" value="${rollnumber}"
							readonly> 
						
						<label for="firstname">First Name:</label> 
						<input
							type="text" id="firstname" name="firstname" value="${firstname}"
							required> 
							
							<label for="lastname">Last Name:</label> 
							<input
							type="text" id="lastname" 
							name="lastname" value="${lastname}"required>
							
							 <label
							for="dob">D.O.B:</label> 
							<input type="date" id="dob"
							name="dob" value="${dob}" required> 
							
							<label
							for="email">Email:</label> 
							<input type="text"
							id="email" name="email" value="${email}" required> 
							
							<label
							for="address">Address:</label> 
							<input type="text" id="address"
							name="address" value="${address}" required> 
							
							<label
							for="about">About:</label> 
							<input type="text"
							id="about" name="about"value="${about}"  required>
						<button type="submit">Save Changes</button>
					</form>
				</div>
			</div>
		</div>
		<footer>
			<p>© 2024 ${role} Dashboard. All rights reserved.</p>
		</footer>
	</div>
</body>
</html>
