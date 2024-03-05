<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Time Table</title>
    <style>
    
    *{
margin:0;
padding:0;
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

.container {
    flex-grow: 1; 
    background-color: #b0afac;
    text-align: center;
    color: white;
    padding: 10px 10px;
}
.table-header{

text-align: center;
}

.table-container {
margin-top:
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
							<a href="ProfileServlet?username=${username}"><img
								src="Profile.png" draggable="false" alt="Profile Image"></a>
						</div>
					</div>
				</div>
			</div>
    <div class="container">
        <h2>Timetable</h2>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Day</th>
                        <th>Period 1</th>
                        <th>Period 2</th>
                        <th>Period 3</th>
                        <th>Period 4</th>
                        <th>Period 5</th>
                        <th>Period 6</th>
                        <th>Period 7</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${timetableEntries}" var="entry">
                        <tr>
                            <td>${entry.day}</td>
                            <td>${entry.period1}</td>
                            <td>${entry.period2}</td>
                            <td>${entry.period3}</td>
                            <td>${entry.period4}</td>
                            <td>${entry.period5}</td>
                            <td>${entry.period6}</td>
                            <td>${entry.period7}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
 <div class="back-button">
            <button onclick="goBack()">Go Back</button>
        </div>
    </div>
    <footer>
        <p>© 2024 ${role} Dashboard. All rights reserved.</p>
    </footer>
</div>
</body>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</html>
