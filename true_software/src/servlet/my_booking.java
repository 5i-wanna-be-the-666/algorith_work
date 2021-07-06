package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import true_book.BookingInformationDAO;
import net.sf.json.JSONArray;
import software.client;

/**
 * Servlet implementation class my_booking
 */
@WebServlet("/my_booking")
public class my_booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public my_booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		client yong_hu=(client) request.getSession().getAttribute("client");
		BookingInformationDAO bk=new BookingInformationDAO();
		
		List bao=bk.findByName(yong_hu.get_person().getName());
		
		request.getSession().setAttribute("my_yuding",bao);
		JSONArray true_json=JSONArray.fromObject(bao);
	    
		System.out.println(true_json.toString());
		response.getWriter().append(true_json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
