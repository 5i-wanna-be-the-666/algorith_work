package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import card.CreditCard;
import card.CreditCardDAO;
import person.PersonDAO;
import software.client;
import software.manager;
import user_role.UserRoleDAO;

/**
 * Servlet implementation class Login_page
 */
@WebServlet("/Login_page")
public class Login_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_page() {
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
		
		
		String	user=request.getParameter("username");
		String	passwd=request.getParameter("passwd");
		
		UserRoleDAO kk=new UserRoleDAO();
		PersonDAO pp=new PersonDAO();
		CreditCardDAO cd=new CreditCardDAO();
		
		
		if(kk.findById(user)==null||!kk.findById(user).getPasswd().equals(passwd))
		{
			out.print(false);
			out.flush();
			out.close();
		}
		else
		{
			
			
			
		switch(kk.findById(user).getPosition())
		{
		
		case "¹Ë¿Í":
			{
				client yong_hu=new client();
				yong_hu.set_role(kk.findById(user));
				yong_hu.set_person(pp.findById(kk.findById(user).getIdCard()));
				yong_hu.set_card((CreditCard) cd.findByIdCard(kk.findById(user).getIdCard()).get(0));
				request.setAttribute("client",yong_hu);
				
				request.getRequestDispatcher("client").forward(request, response);
				
			}break;
		case "¹ÍÔ±":
		{
			request.getRequestDispatcher("emplye").forward(request, response);
			
			
		}break;
		
		case "ÀÏ°å":
		{
			manager boss=new manager(kk.findById(user));
			request.getSession().setAttribute("boss", boss);
			request.getRequestDispatcher("boss").forward(request, response);
			
		}break;
		}//end switch
			}//end else
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
