<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Topper Students</title>
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
            min-height: 120vh;
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
        .container {
            flex-grow: 1;
            background-color: #b0afac;
            text-align: center;
            color: white;
            padding: 10px 10px;
        }
        .table-header {
            text-align: center;
        }
        .table-container {
            overflow-x: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: auto;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .back-button {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }
        .tablehead1{
        margin-top: 10px;
        margin-bottom:10px;
        color: black;
        }
        .tablehead2{
        margin-top: 10px;
        margin-bottom:10px;
        color: black;        
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
        input {
            background: none;
            border: none;
            font-family: math;
            font-size: 15;
            width: 60px;
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
            <div class="tablehead1"><h2>Overall Topper</h2></div>
            <table>
                <tr>
                    <th>Student Name</th>
                    <th>Total Marks</th>
                    <th>Rank</th>
                </tr>
                <c:forEach var="overallTopper" items="${overallToppers}" varStatus="loop">
                    <tr>
                        <td>${overallTopper.fullName}</td>
                        <td>${overallTopper.totalMarks}</td>
                        <td>${loop.index + 1}</td>
                    </tr>
                </c:forEach>
            </table>

           <div class="tablehead2"> <h2>Subject-wise Toppers</h2></div>
            <table>
                <tr>
                    <th>Subject</th>
                    <th>Student Name</th>
                    <th>Subject Mark</th>
                </tr>
                <c:forEach var="subjectTopper" items="${subjectToppers}">
                    <tr>
                        <td>${subjectTopper.subject}</td>
                        <td>${subjectTopper.fullName}</td>
                        <td>${subjectTopper.totalMarks}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="back-button">
            <form action="adminlanding.jsp" method="GET">
                <button type="submit">Back</button>
            </form>
        </div>
    </div>
    <footer>
        <p>© 2024 Admin Dashboard. All rights reserved.</p>
    </footer>
</div>
</body>
</html>
