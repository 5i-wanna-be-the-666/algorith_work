package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.RoomInformation;
import room.RoomInformationDAO;

/**
 * Servlet implementation class du_room
 */
@WebServlet("/du_room")
public class du_room extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public du_room() {
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
		 
		 for(int i=0;i<biao.size();i++)
		 {
			 RoomInformation yong=(RoomInformation) biao.get(i);
			 if(yong.getEmpety()==false)
			 {
				 biao.remove(i);
				 i--;
			 }
		 }
		 
		 for(int i=0;i<zt.size();i++)
		 {
			 RoomInformation yong=(RoomInformation) zt.get(i);
			 if(yong.getEmpety()==false)
			 {
				 zt.remove(i);
				 i--;
			 }
		 }
		 
		 for(int i=0;i<big.size();i++)
		 {
			 RoomInformation yong=(RoomInformation) big.get(i);
			 if(yong.getEmpety()==false)
			 {
				 big.remove(i);
				 i--;
			 }
		 }
		 
		 for(int i=0;i<shuang.size();i++)
		 {
			 RoomInformation yong=(RoomInformation) shuang.get(i);
			 if(yong.getEmpety()==false)
			 {
				 shuang.remove(i);
				 i--;
			 }
		 }
		
		
		request.getSession().setAttribute("biao",biao);
		request.getSession().setAttribute("zt",zt);
		request.getSession().setAttribute("big",big);
		request.getSession().setAttribute("shuang",shuang);
		request.getSession().setAttribute("zong",(shuang.size()+big.size()+zt.size()+biao.size()));
		request.getRequestDispatcher("booking").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
