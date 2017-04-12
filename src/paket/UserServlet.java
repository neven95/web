package paket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init(){
    	ServletContext sct = getServletContext();
    	sct.setAttribute("users", new ArrayList<Osoba>());
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html");
		response.setHeader("charset", "UTF-8");
		PrintWriter writter = response.getWriter();
		writter.print("<html>");
		
		writter.print("<body>");
		writter.print("<form action= \"user\" method=\"post\">");
		writter.print("<input type=\"text\"name=\"ime\">");
		writter.print("<br>");
		writter.print("<input type=\"text\"name=\"prezime\">");
		writter.print("<br>");
		writter.print("<input type=\"password\"name=\"sifra\">");
		writter.print("<br>");
		writter.print("<input type=\"submit\">");
		writter.print("</form>");
		
		writter.print("<body>");
		writter.print("<form action= \"findUser\" method=\"get\">");
		writter.print("<input type=\"text\"name=\"ime\">");
		
		writter.print("<br>");
		writter.print("<input type=\"submit\">");
		writter.print("</form>");
		writter.print("</body>");
		writter.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Osoba osoba =new Osoba(request.getParameter("ime"), request.getParameter("prezime"), request.getParameter("sifra"));
		ServletContext ctx = getServletContext();
		ArrayList<Osoba> users =  (ArrayList<Osoba>) ctx.getAttribute("users");
		if (osoba!=null){
			users.add(osoba);
		}
		response.setHeader("Content-type", "text/html");
		response.setHeader("charset", "UTF-8");
		PrintWriter writter = response.getWriter();
		writter.print("<html>");
		
		writter.print("<body>");
		writter.print("<p>Korisnici</p>");
		for (Osoba korisnik: users){
			writter.print(korisnik.toString());
			writter.print("<br>");
		}
		writter.print("</body>");
		writter.print("</html>");
		
	}

}
