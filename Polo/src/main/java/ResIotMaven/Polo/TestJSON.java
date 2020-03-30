package ResIotMaven.Polo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.json.simple.JSONObject;
import ResIotMaven.Polo.FirstPDF.HelloServlet;
  
public class TestJSON {
	public static void main(String[] args) throws Exception {
			
			//JSON file to rest
			
				 Server server = new Server(8080);
			     ServletHandler handler = new ServletHandler();
			     handler.addServletWithMapping(HelloServlet.class, "/test");//Set the servlet to run.
			     server.setHandler(handler);    
			     server.start();
			     server.join();
	}

	public static JSONObject json() {
		String string = "";	
		JSONObject jsonObject = new JSONObject();
		try {
		InputStream crunchifyInputStream = new FileInputStream("C:\\Users\\POL-EWEN\\Documents\\CrunchifyJSON.txt");
		InputStreamReader read = new InputStreamReader(crunchifyInputStream);
		BufferedReader br = new BufferedReader(read);
		StringBuilder builder = new StringBuilder();
		String line;
		
		while ((line = br.readLine()) != null) {
			string += line + "\n";
			builder.append(line);
		}
		
		jsonObject.put("message", string);
		System.out.println(jsonObject);
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	
	}
			     
			     @SuppressWarnings("serial")
	public static class HelloServlet extends HttpServlet {

		
        @Override
        @produce
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello SimpleServlet</h1>");
            response.getWriter().println(json());
        }
    }
}