package com.ssm.webapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import com.ssm.webapp.model.Student;
import com.ssm.webapp.dao.StudentDAO;

public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useridStr = request.getParameter("userid");
        if (useridStr != null && !useridStr.isEmpty()) {
            try {
                int userid = Integer.parseInt(useridStr);
                StudentDAO studentDAO = new StudentDAO();
                Student student = studentDAO.getStudentById(userid);
                if (student != null) {
                    request.setAttribute("userid", student.getUserId());
                    request.setAttribute("rollnumber", student.getRollNumber());
                    request.setAttribute("firstname", student.getFirstName());
                    request.setAttribute("lastname", student.getLastName());
                    request.setAttribute("dob", student.getDob());
                    request.setAttribute("email", student.getEmail());
                    request.setAttribute("address", student.getAddress());
                    request.setAttribute("about", student.getAbout());
                    System.out.println("request------------->>>>>>>>"+student);
                    request.getRequestDispatcher("editstudent.jsp").forward(request, response);
                } else {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		String role = (String) session.getAttribute("role");
		PrintWriter out = response.getWriter();
		StudentDAO studentDAO = new StudentDAO();

		try {
			Student student = new Student();
			student.setUserId(Integer.parseInt(request.getParameter("userid")));
			student.setFirstName(request.getParameter("firstname"));
			student.setLastName(request.getParameter("lastname"));
			student.setDob(request.getParameter("dob"));
			student.setEmail(request.getParameter("email"));
			student.setAddress(request.getParameter("address"));
			student.setAbout(request.getParameter("about"));

			boolean result = studentDAO.updateStudent(student);
			if (result) {
				if ("Admin".equals(role)) {
					response.sendRedirect("StudentListServlet");
				} else if ("Staff".equals(role)) {
					response.sendRedirect("StudentListStaffServlet");
				} else {
					out.println("Error in Editing Student Due To Role Not Found");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

