package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import card.CreditCard;
import card.CreditCardDAO;
import person.Person;
import person.PersonDAO;
import user_role.UserRole;
import user_role.UserRoleDAO;

/**
 * Servlet implementation class zhuce_page
 */
@WebServlet("/zhuce_page")
public class zhuce_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhuce_page() {
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
		
		
		String	user=request.getParameter("user");
		String	passwd=request.getParameter("passwd");
		String	card_number=request.getParameter("card_number");//信用卡号
		
		String	id_card=request.getParameter("id_card");//身份证号
		
		String	name=request.getParameter("name");//名字
		String	email=request.getParameter("email");//
		String	sex=request.getParameter("sex");
		
		Random ran = new Random();//随机数
		int jijia=(int) request.getSession().getAttribute("jijia");
		
		double num=ran.nextInt(jijia/1000)+1;
		
		PersonDAO ff=new PersonDAO();
		UserRoleDAO kk=new UserRoleDAO();
		CreditCardDAO cd=new CreditCardDAO();
		
		Person ren=new Person(id_card,name,sex,email);
		UserRole my=new UserRole(user,passwd,"顾客",id_card);
		CreditCard my_cd=new CreditCard(card_number,id_card,"123456",num*1000);
		
		ff.save(ren);
		kk.save(my);
		cd.save(my_cd);
		request.getRequestDispatcher("wait").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
