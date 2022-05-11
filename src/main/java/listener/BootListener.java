package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("db드라이버 로딩....");
        try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
}
