package control.gestioneOrdine;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ordine;

/**
 * Servlet implementation class VisualizzaFattura
 */
@WebServlet("/VisualizzaFattura")
public class VisualizzaFattura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaFattura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numOrdine= Integer.parseInt(request.getParameter("numOrdine"));
		Collection<?> ordini= (Collection<?>) request.getSession().getAttribute("ordini");
		Iterator<?> it= ordini.iterator();
		Object o = null;
		for(int i=0; i<numOrdine; i++) {
			if(it.hasNext()) 
				o=it.next();
		}
		Ordine ordine= (Ordine) o;
		
		request.getSession().setAttribute("ordineDaVisualizzare", ordine);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/presentation/cliente/Fattura.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
