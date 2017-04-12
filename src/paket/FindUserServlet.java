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

/**
 * Servlet implementation class FindUserServlet
 */

public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ctx = getServletContext();
		ArrayList<Osoba> users = (ArrayList<Osoba>) ctx.getAttribute("users");
		String ime = request.getParameter("ime");
		for(Osoba user : users){
			if(user.getIme().equals(ime)){
				response.setHeader("Content-type", "text/html");
				response.setHeader("charset", "UTF-8");
				PrintWriter writter = response.getWriter();
				writter.print("<html>");
				
				writter.print("<body>");
				
				writter.print("<p>Korisnik</p>");
				writter.print(user.toString()+" postoji!");
				writter.print("</body>");
				writter.print("</html>");
				return;
			}
			
		}
		response.setHeader("Content-type", "text/html");
		response.setHeader("charset", "UTF-8");
		PrintWriter writter = response.getWriter();
		writter.print("<html>");
		
		writter.print("<body>");
		
		writter.print("<p>Korisnik</p>");
		writter.print(ime + " ne postoji");
		writter.print("</body>");
		writter.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
