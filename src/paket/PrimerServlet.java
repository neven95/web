package paket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */

public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	ServletContext ctx = getServletContext();
    	ctx.setAttribute("users", new ArrayList<String>());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime = request.getParameter("ime");
		ServletContext ctx = getServletContext();
		List<String> listaKorisnika = (List<String>) ctx.getAttribute("users");
		if (ime!=null){
			listaKorisnika.add(ime);
		}
		response.setHeader("Content-type", "text/html");
		response.setHeader("charset", "UTF-8");
		PrintWriter writter = response.getWriter();
		writter.print("<html>");
		
		writter.print("<body>");
		writter.print("<p>Ciao</p>"+ime);
		for (String korisnik: listaKorisnika){
			writter.print(korisnik+" ");
		}
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
