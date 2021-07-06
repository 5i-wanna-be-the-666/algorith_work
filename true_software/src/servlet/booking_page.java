package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import true_book.BookingInformation;
import true_book.BookingInformationDAO;
import true_book.BookingInformationId;
import card.CreditCard;
import card.CreditCardDAO;

import person.PersonDAO;
import room.RoomInformation;
import room.RoomInformationDAO;
import software.client;

import user_role.UserRoleDAO;

/**
 * Servlet implementation class booking_page
 */
@WebServlet("/booking_page")
public class booking_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking_page() {
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
		
		PersonDAO ren=new PersonDAO();
		UserRoleDAO hao=new UserRoleDAO();
		RoomInformationDAO fan=new RoomInformationDAO();
		CreditCardDAO cd=new CreditCardDAO();
		BookingInformationDAO bk=new BookingInformationDAO();
		
		Date toda=new Date();
		client yong_hu=(client) request.getSession().getAttribute("client");
		
		String	Serial_number=request.getParameter("Serial_number");
		double pr=0;
		
		
		//ͨ����Ų��ҷ��䣬ͨ���û�����idcard��name
		String	Booking_method=request.getParameter("Booking_method");
		switch(Booking_method)
		{
		
		case "1":
		{
			Booking_method="60";
			pr=fan.findById(Serial_number).getPrice()*0.8;
		}break;
		
		case "2":
		{
			Booking_method="����";
			pr=fan.findById(Serial_number).getPrice()*0.8;
		}break;
		
		case "3":
		{
			Booking_method="Ԥ��";
			pr=fan.findById(Serial_number).getPrice()*0.8;
		}break;
		
		default: break;
		
		}
		int zong=(int) request.getSession().getAttribute("zong");
		if(zong>=40)
		{
			pr*=0.8;
			System.out.println("��ý���Ԥ��");
		}
		Timestamp	 Booking_date=new Timestamp(toda.getTime());//�µ���ʱ�䣨���ڣ�
		String zhuan=request.getParameter("arrive_time");
		
		zhuan=zhuan.replace('/', '-');
		
		zhuan=zhuan.replace("T", " ");
		zhuan+=":00";
		
		Timestamp	 arrive_time=Timestamp.valueOf(zhuan);//����ʱ��
	
		 zhuan=request.getParameter("leavetime");
		 zhuan=zhuan.replace('/', '-');
		 zhuan=zhuan.replace('T', ' ');
		 zhuan+=":00";
			
		Timestamp	leavetime=Timestamp.valueOf(zhuan);
		
		
		int	live_days=(int) (leavetime.getTime()-arrive_time.getTime())/1000/60/60/24;//int��סʱ��
		// 
		// CreditCard md=new  CreditCard("555555","54534545","123456",500000.0);
		// yong_hu.set_card(md);
		
		boolean flag=false;
		if(live_days==0)
		{
			flag=true;
			System.out.println("��סʱ����0");
		}
		if(toda.getTime()-arrive_time.getTime()>1000*60)
			
		{
			flag=true;
			
		}
		if(Booking_method.equals("60"))
		{
			double time=(arrive_time.getTime()-toda.getTime())/1000/60/60/24;
			if(time<60.0)
			{
				System.out.println("��ǰ60��");
				flag=true;
			}
		}
		
		if(fan.findById(Serial_number).getEmpety()==false|| (pr*live_days)>yong_hu.get_card().getBalance()||flag==true)
		{
			
			out.println("����ʧ�ܣ��÷����Ѿ���Ԥ������ʣ�����,����Ԥ����ʱ����д�������ȷ"+"<br/>");
			out.println("ʱ������뱣֤����"+"<br/>");
			out.println("1��������һ���סʱ��"+"<br/>");
			out.println("2������ʱ��������֮��"+"<br/>");
			//ServletContext sc = getServletContext();
			//RequestDispatcher rd = null; 
			//rd = sc.getRequestDispatcher("/booking");//ת��Ԥ��ҳ��
			 //rd.forward(request, response); 
			
		}
		
		//Ԥ���ɹ�
		else {
			
		fan.findById(Serial_number).setEmpety(false);//�����ɹ�������Ϊ����
		fan.save(fan.findById(Serial_number));
		
		BookingInformationId me=new BookingInformationId(yong_hu.get_person().getIdCard(),Serial_number);
		
		BookingInformation my=new BookingInformation(me,yong_hu.get_person().getName(),Booking_method,Booking_date,arrive_time,live_days,leavetime);
		bk.save(my);
		
		yong_hu.set_house(fan.findById(Serial_number));
		yong_hu.set_booking(my);
		yong_hu.get_card().setBalance(yong_hu.get_card().getBalance()-pr*live_days);
		
		cd.delete(yong_hu.get_card());
		cd.save(yong_hu.get_card());
		
		out.print("�����ɹ���");
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
