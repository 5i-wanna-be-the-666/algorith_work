package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HibernateSessionFactory;
import room.RoomInformation;
import room.RoomInformationDAO;
import software.manager;


/**
 * Servlet implementation class change_jia
 */
@WebServlet("/change_jia")
public class change_jia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_jia() {
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
		
		manager boss=(manager) request.getSession().getAttribute("boss");
		String	yong=request.getParameter("jijia");
		double jijia=Double.parseDouble(yong);
		
		request.getSession().setAttribute("jijia",jijia);
		boss.setjia(jijia);
		out.print("true");
		RoomInformationDAO room=new RoomInformationDAO();
		
		Iterator<RoomInformation> it=room.findAll().iterator();
		RoomInformation fan =new RoomInformation();
		
		org.hibernate.Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction(); // ��������
			while(it.hasNext())
			{
				fan=it.next();
				if(fan.getHousingType().equals("���"))
					fan.setPrice(jijia*1.0);
				if(fan.getHousingType().equals("˫�˼�"))
					fan.setPrice(jijia*2.0);
				if(fan.getHousingType().equals("�󴲷�"))
					fan.setPrice(jijia*4.0);
				if(fan.getHousingType().equals("��ͳ��"))
					fan.setPrice(jijia*8.0);
			session.save(fan);
			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// �����ع�����
			session.getTransaction().rollback();
		} finally {
			// �ر�Session����
			session.close();
	}
		BufferedWriter bw = null;
        try {

            String mycontent = ""+jijia;

            // ָ��д���ļ���·��

            File file = new File("D://Myeclipse2020//software_qk/jijia.txt");

            
            if (file.exists()) 
            {
            	file.delete();
            }
            /* �ȴ����ļ�*/ 
            if (!file.exists()) 
            {

                file.createNewFile();

            }

            FileWriter fw = new FileWriter(file);

            bw = new BufferedWriter(fw);

            bw.write(mycontent);
            

            System.out.println("д��ɹ�");

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } finally {

            try {

                if (bw != null)

                    bw.close();

            } catch (Exception ex) 
            {

                System.out.println("Error in closing the BufferedWriter" + ex);

            }

        }
        request.getRequestDispatcher("boss").forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
