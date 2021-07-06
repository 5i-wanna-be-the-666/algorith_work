package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import true_book.BookingInformation;
import dao.HibernateSessionFactory;


/**
 * Servlet implementation class tuiding_page
 */
@WebServlet("/tuiding_page")
public class tuiding_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tuiding_page() {
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
		
		String hang=request.getParameter("hang");
		int hh=Integer.parseInt(hang)-1;
		List bao=(List) request.getSession().getAttribute("my_yuding");
		
		org.hibernate.Session session = null;
		BookingInformation mdd=new BookingInformation();
		mdd=(BookingInformation)bao.get(hh);
		
		bao.remove(hh);
		request.getSession().setAttribute("my_yuding",bao);
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction(); // 开启事物
			session.delete(mdd);
		
            session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 出错将回滚事物
			session.getTransaction().rollback();
		} finally {
			// 关闭Session对象
			session.close();
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
