package control.gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Utente;
import model.AccountManager;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AccountManager manager= new AccountManager();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		boolean utenteNonTrovato=false;
		
		Utente utente=null;
		try {
			utente= manager.login(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(utente==null) {
			utenteNonTrovato= true;
		}
		
		request.getSession().setAttribute("utenteNonTrovato", utenteNonTrovato);
		request.getSession().setAttribute("utente", utente);
		
		String redirect="";
		
		if(utente==null) {
			redirect="Login.jsp";
		}else if(utente.getTipo().equalsIgnoreCase("cliente")) {
			redirect="Home.jsp";
		}else if(utente.getTipo().equalsIgnoreCase("amministratore")){
			redirect="../amministratore/AmministratoreCatalogo.jsp";
		}else if(utente.getTipo().equalsIgnoreCase("amministratoreOrdine")){
			redirect="../amministratoreOrdini/AmministratoreOrdiniOrdine.jsp";
		}
		response.sendRedirect(redirect);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
