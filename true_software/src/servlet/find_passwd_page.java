package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_role.UserRoleDAO;

/**
 * Servlet implementation class find_passwd_page
 */
@WebServlet("/find_passwd_page")
public class find_passwd_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public find_passwd_page() {
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
		
		UserRoleDAO hao=new UserRoleDAO();
		
		String	username=request.getParameter("username");
		if(hao.findById(username)==null)
		{
			out.print(false);
			out.flush();
			out.close();
		}
		else 
		{
		out.print(hao.findById(username).getPasswd());
		request.getSession().setAttribute("your_passwd",hao.findById(username).getPasswd());
		request.getRequestDispatcher("find_passwd").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
