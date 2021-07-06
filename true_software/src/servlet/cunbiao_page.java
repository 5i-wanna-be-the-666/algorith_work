package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import true_book.BookingInformation;
import true_book.BookingInformationDAO;
import room.RoomInformation;


/**
 * Servlet implementation class cunbiao_page
 */
@WebServlet("/cunbiao_page")
public class cunbiao_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cunbiao_page() 
    {
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
		
		Date tode=new Date();
		BookingInformationDAO bk=new BookingInformationDAO();
		Iterator<BookingInformationDAO> it =bk.findAll().listIterator();
		
		String file_name=tode.toLocaleString();
		file_name=file_name.replace(" ", "-");
		file_name=file_name.replace(":", "-");
		 FileOutputStream os = new FileOutputStream("D://Myeclipse2020//software_qk/"+file_name+".txt");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		 try {

	         

	            // 指定写入文件的路径

	            File file = new File("D://Myeclipse2020//software_qk/"+file_name+".txt");

	           
	            if (file.exists()) 
	            {
	            	file.delete();
	            }
	            /* 先创建文件*/ 
	            if (!file.exists()) 
	            {

	                file.createNewFile();

	            }
              
	            oos = new ObjectOutputStream(os);
	            while(it.hasNext())
	            {
	            	oos.writeObject(it.next());
	            }
	            

	            System.out.println("写入成功");

	        } catch (IOException ioe) {

	            ioe.printStackTrace();

	        } finally {

	            try {

	                if (oos != null)

	                	oos.close();

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
