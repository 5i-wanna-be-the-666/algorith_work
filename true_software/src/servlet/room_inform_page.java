package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.RoomInformation;
import room.RoomInformationDAO;

/**
 * Servlet implementation class room_inform_page
 */
@WebServlet("/room_inform_page")
public class room_inform_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public room_inform_page() {
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
		
		
		RoomInformationDAO ss=new RoomInformationDAO();
		List biao=ss.findByHousingType("标间");
		List zt=ss.findByHousingType("总统房");
		List big=ss.findByHousingType("大床房");
		List shuang=ss.findByHousingType("双人间");
		
		
		//最后一个int标记空房间数
		//去除已经有人居住的房间
		
		//标间
		Iterator<RoomInformation> it =biao.listIterator();
		
		while(it.hasNext())
		{
			RoomInformation yong=it.next();
			if(yong.getEmpety()==false)
				it.remove();
		}
		
		RoomInformation fan_biao=(RoomInformation) biao.get(0);
		
		int biao_shu=biao.size();
		
		//大床房
		
		Iterator<RoomInformation>it1 =big.listIterator();
		
		while(it1.hasNext())
		{
			RoomInformation yong=it1.next();
			if(yong.getEmpety()==false)
				it1.remove();
		}
		RoomInformation fan_big=(RoomInformation) big.get(0);
		int big_shu=big.size();
		//双人房
		
		Iterator<RoomInformation>it2 =shuang.listIterator();
			
	     while(it2.hasNext())
			{
				RoomInformation yong=it2.next();
				if(yong.getEmpety()==false)
					it2.remove();
			}
	     RoomInformation fan_shuang=(RoomInformation) shuang.get(0);
			int shuang_shu=shuang.size();
			
		//总统房
			
			Iterator<RoomInformation>it3 =zt.listIterator();
				
		 while(it3.hasNext())
		{
			RoomInformation yong=it3.next();
			if(yong.getEmpety()==false)
			it3.remove();
		}
		 RoomInformation fan_zt=(RoomInformation)zt.get(0);
		int zt_shu=zt.size();
			
		//总共的空房间数
		int sum=biao_shu+zt_shu+shuang_shu+big_shu;
		
		String fan=request.getParameter("lei");
		
		switch(fan)
		{
		case "1":
        {
        	
        	 response.getWriter().append("房间类型:");
        	 response.getWriter().append(fan_biao.getHousingType()+"</br>");
        	 
        	 response.getWriter().append("房间大小:");
        	 response.getWriter().append(fan_biao.getArea()+"</br>");
        	 
        	 response.getWriter().append("房间价格:");
        	 response.getWriter().append(fan_biao.getPrice()+"</br>");
        	 
        	 response.getWriter().append("房间最大居住人数:");
        	 response.getWriter().append(fan_biao.getMaxperson()+"</br>");
        	 
        	
        	 response.getWriter().append("房间剩余数:");
        	 response.getWriter().append(biao_shu+"</br>");
			
		}break;
		case "2":
        {
        	 response.getWriter().append("房间类型:");
        	 response.getWriter().append(fan_big.getHousingType()+"</br>");
        	 
        	 response.getWriter().append("房间大小:");
        	 response.getWriter().append(fan_big.getArea()+"</br>");
        	 
        	 response.getWriter().append("房间价格:");
        	 response.getWriter().append(fan_big.getPrice()+"</br>");
        	 
        	 response.getWriter().append("房间最大居住人数:");
        	 response.getWriter().append(fan_big.getMaxperson()+"</br>");
        	 
        	
        	 response.getWriter().append("房间剩余数:");
        	 response.getWriter().append(big_shu+"</br>");
			
		}break;
		case "3":
		{
			 response.getWriter().append("房间类型:");
        	 response.getWriter().append(fan_shuang.getHousingType()+"</br>");
        	 
        	 response.getWriter().append("房间大小:");
        	 response.getWriter().append(fan_shuang.getArea()+"</br>");
        	 
        	 response.getWriter().append("房间价格:");
        	 response.getWriter().append(fan_shuang.getPrice()+"</br>");
        	 
        	 response.getWriter().append("房间最大居住人数:");
        	 response.getWriter().append(fan_shuang.getMaxperson()+"</br>");
        	 
        	
        	 response.getWriter().append("房间剩余数:");
        	 response.getWriter().append(shuang_shu+"</br>");
		}break;
		case "4":
		{
			 response.getWriter().append("房间类型:");
        	 response.getWriter().append(fan_zt.getHousingType()+"</br>");
        	 
        	 response.getWriter().append("房间大小:");
        	 response.getWriter().append(fan_zt.getArea()+"</br>");
        	 
        	 response.getWriter().append("房间价格:");
        	 response.getWriter().append(fan_zt.getPrice()+"</br>");
        	 
        	 response.getWriter().append("房间最大居住人数:");
        	 response.getWriter().append(fan_zt.getMaxperson()+"</br>");
        	 
        	
        	 response.getWriter().append("房间剩余数:");
        	 response.getWriter().append(zt_shu+"</br>");
		}break;
			default:break;
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
