<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Admin Dashboard</title>
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

.header {
	background-color: #f0f0f0;
	display: flex;
	justify-content: end;
	padding: 5px 10px;
	align-items: center;
	box-shadow: 5px 10px #888888;
}

.user-info {
	padding: 2px 30px;
	font-size: 17px;
	color: initial;
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

.container {
	flex-grow: 1;
	background-color: #b0afac;
	text-align: center;
	color: white;
}

ul {
	list-style: none;
	padding: 40px;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

ul li {
	margin: 40px;
}

ul li a {
	text-decoration: none;
	color: white;
	background-color: #4951a6;
	padding: 100px 60px;
	border-radius: 5px;
	display: block;
	font-family: cursive;
}

footer {
	width: 100%;
	margin: auto;
	text-align: center;
	background-color: #d6d5d2;
    padding: 10px 0; 
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

				<ul>
					<li><a href='StudentListServlet'>Student Details</a></li>
					<li><a href='ViewTimeTableServlet'>Time Table</a></li>
					<li><a href='ViewAttendanceServlet'>Attendance</a></li>
					<li><a href='AddUserServlet'>Add User</a></li>
					<li><a href='TopperServlet'>Topper Details</a></li>
				</ul>

			</div>
		</div>
		<footer>
			<p>© 2024 Admin Dashboard. All rights reserved.</p>
		</footer>
	</div>
</body>
</html>
