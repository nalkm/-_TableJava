package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("Servlet Created");
	}

	public void destroy() {
		System.out.println("Servlet Destroyed");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String user_id = "user6767";
		String restaurant_id = "222-000-5555";
		String restaurant_name = "아무 식당2";
		
		String adultCount = request.getParameter("adultCount");
		String kidCount = request.getParameter("kidCount");
		String stroller = request.getParameter("stroller");
		String wheelchair = request.getParameter("wheelchair");
		String date = request.getParameter("dateValue");
		String time = request.getParameter("timeValue");
		String requirement = request.getParameter("requirement");
		String status = "0"; //예약 대기 상태

		BookDTO dto = new BookDTO();
		dto.setUser_id(user_id);
		dto.setRestaurant_id(restaurant_id);
		dto.setRestaurant_name(restaurant_name);
		dto.setDate(date);
		dto.setTime(time);
		dto.setStatus(status);
		dto.setA_count(adultCount);
		dto.setK_count(kidCount);
		dto.setS_count(stroller);
		dto.setW_count(wheelchair);
		dto.setRequirement(requirement);
		
		BookDAO dao = new BookDAO();
		dao.addBook(dto);
		
		request.setAttribute("book", dto);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/book_done.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
