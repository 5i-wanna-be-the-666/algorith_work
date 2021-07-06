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
		
		
		//通过序号查找房间，通过用户查找idcard和name
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
			Booking_method="常规";
			pr=fan.findById(Serial_number).getPrice()*0.8;
		}break;
		
		case "3":
		{
			Booking_method="预付";
			pr=fan.findById(Serial_number).getPrice()*0.8;
		}break;
		
		default: break;
		
		}
		int zong=(int) request.getSession().getAttribute("zong");
		if(zong>=40)
		{
			pr*=0.8;
			System.out.println("获得奖励预订");
		}
		Timestamp	 Booking_date=new Timestamp(toda.getTime());//下单的时间（现在）
		String zhuan=request.getParameter("arrive_time");
		
		zhuan=zhuan.replace('/', '-');
		
		zhuan=zhuan.replace("T", " ");
		zhuan+=":00";
		
		Timestamp	 arrive_time=Timestamp.valueOf(zhuan);//到达时间
	
		 zhuan=request.getParameter("leavetime");
		 zhuan=zhuan.replace('/', '-');
		 zhuan=zhuan.replace('T', ' ');
		 zhuan+=":00";
			
		Timestamp	leavetime=Timestamp.valueOf(zhuan);
		
		
		int	live_days=(int) (leavetime.getTime()-arrive_time.getTime())/1000/60/60/24;//int居住时长
		// 
		// CreditCard md=new  CreditCard("555555","54534545","123456",500000.0);
		// yong_hu.set_card(md);
		
		boolean flag=false;
		if(live_days==0)
		{
			flag=true;
			System.out.println("居住时长是0");
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
				System.out.println("提前60天");
				flag=true;
			}
		}
		
		if(fan.findById(Serial_number).getEmpety()==false|| (pr*live_days)>yong_hu.get_card().getBalance()||flag==true)
		{
			
			out.println("订购失败，该房间已经被预订或者剩余金额不足,或者预订的时间填写情况不正确"+"<br/>");
			out.println("时间情况请保证：："+"<br/>");
			out.println("1：至少有一天居住时间"+"<br/>");
			out.println("2：到达时间在现在之后"+"<br/>");
			//ServletContext sc = getServletContext();
			//RequestDispatcher rd = null; 
			//rd = sc.getRequestDispatcher("/booking");//转回预订页面
			 //rd.forward(request, response); 
			
		}
		
		//预订成功
		else {
			
		fan.findById(Serial_number).setEmpety(false);//订购成功则将其置为不空
		fan.save(fan.findById(Serial_number));
		
		BookingInformationId me=new BookingInformationId(yong_hu.get_person().getIdCard(),Serial_number);
		
		BookingInformation my=new BookingInformation(me,yong_hu.get_person().getName(),Booking_method,Booking_date,arrive_time,live_days,leavetime);
		bk.save(my);
		
		yong_hu.set_house(fan.findById(Serial_number));
		yong_hu.set_booking(my);
		yong_hu.get_card().setBalance(yong_hu.get_card().getBalance()-pr*live_days);
		
		cd.delete(yong_hu.get_card());
		cd.save(yong_hu.get_card());
		
		out.print("订购成功！");
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
