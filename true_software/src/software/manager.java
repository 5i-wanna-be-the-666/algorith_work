package software;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import user_role.UserRole;

public class manager {
	public double jijia;
	UserRole I;
	
	public manager(UserRole I)
	{
		this.I=I;
		BufferedReader bw = null;

        try {

            

            // 指定读出文件的路径

            File file = new File("D://Myeclipse2020//software_qk/jijia.txt");

            
           

            Reader fw = new FileReader(file);

            bw = new BufferedReader(fw);
           

            this.jijia=Double.parseDouble(bw.readLine());
            
            
           

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
		
	}
	public manager()
	{
		
	}
	public void setjia(double n)
	{
		this.jijia=n;
	}
	
	public double getjia()
	{
		return this.jijia;
	}
	public void set_role(UserRole I)
	{
		this.I=I;
	}
	public UserRole get_role()
	{
		return this.I;
	}
	

}
