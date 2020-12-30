/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session_beans.Db_beanLocal;
import model.Test;

/**
 *
 * @author Thijs Vercammen
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private Db_beanLocal db;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("submit");
        switch (action) {
            case "Burger":
                {
                    String username = request.getRemoteUser();
                    System.out.println("---------------- " + username + "\n");
                    response.sendRedirect("burger/redirect.jsp");
                    break;
                }
            case "Arts":
                response.sendRedirect("arts/arts_overview.jsp");
                break;
            case "nieuw contact":
                {
                    String username = request.getRemoteUser();
                    request.getSession().setAttribute("burgers", db.getAllBurgers(username));
                    gotoPage("burger/nieuw_contact.jsp", request, response);
                    break;
                }
            case "nieuwe test":
                {
                    String username = request.getRemoteUser();
                    Test t = db.getTest(username);
                    if (t != null) {
                        request.getSession().setAttribute("testStatus", t.getStatus().getNaam());
                        request.getSession().setAttribute("test", t);
                    } else {
                        request.setAttribute("testStatus", "Nog geen test uitgevoerd");
                    }       
                    gotoPage("burger/test_aanvragen.jsp", request, response);
                    break;
                }
            case "Voeg contact toe":
                {
                    String username = request.getRemoteUser();
                    String contact = request.getParameter("contact");
                    String soort = request.getParameter("soort_contact");
                    db.addContact(username, contact, soort);
                    gotoPage("burger/gebruiker_overview.jsp", request, response);
                    break;
                }
            case "Overzicht contacten":
                {
                    String username = request.getRemoteUser();
                    request.getSession().setAttribute("nauw", db.getNauweContacten(username));
                    request.getSession().setAttribute("gewoon", db.getGewoneContacten(username));
                    request.getSession().setAttribute("veilig", db.getVeiligeContacten(username));
                    request.getSession().setAttribute("aantnauw", db.getNauweContacten(username).size());
                    request.getSession().setAttribute("aantgewoon", db.getGewoneContacten(username).size());
                    request.getSession().setAttribute("aantveilig", db.getVeiligeContacten(username).size());
                    request.getSession().setAttribute("risico", db.getRisicoStatus(username));
                    gotoPage("burger/risico.jsp", request, response);
                    break;
                }
            case "Test Aanvragen":
                {
                    String username = request.getRemoteUser();
                    Test t = new Test();     
                    t.setStatus(db.getStatus("In uitvoering"));
                    db.updateTest(t, username);
                    request.getSession().setAttribute("testStatus", t.getStatus().getNaam());
                    request.getSession().setAttribute("test", t);
                    gotoPage("burger/test_aanvragen.jsp", request, response);
                    break;
                }
            case "Overzicht":
                request.getSession().setAttribute("burger", db.getBurger(request.getRemoteUser()));
                response.sendRedirect("burger/gebruiker_overview.jsp");
                break;
            case "Voeg test toe":
                {
                    String test_id = request.getParameter("test_id");
                    String status = request.getParameter("status");
                    Test burger = db.getTestByID(test_id);
                    if(burger == null) {
                        gotoPage("arts/arts_overview.jsp", request, response);
                    }else {
                        request.setAttribute("test_id", test_id);
                        request.setAttribute("burger", burger.getGebruiker().getNaam());
                        request.setAttribute("status", status);
                        gotoPage("arts/status_confirmation.jsp", request, response);
                    }       break;
                }
            case "Bevestig":
                {
                    String test_id = request.getParameter("test_id");
                    String status = request.getParameter("status");
                    String burger = request.getParameter("burger");
                    Test t = db.getTestByID(test_id);
                    //Status test aanpassen met resultaat
                    t.setStatus(db.getStatus(status));
                    if ("Positief".equals(status)) {
                        //Test is positief
                        db.updateTestPos(t, burger);
                    }
                    else {
                        //Test was negatief
                       db.updateTest(t, burger); 
                    }
                    //Notice toevoegen: resultaat beschikbaar
                    db.setNotice(1, burger);
                    gotoPage("arts/arts_overview.jsp", request, response);
                    break;
                }
            case "Annuleer":
                gotoPage("arts/arts_overview.jsp", request, response);
                break;
            case "Afmelden":
                request.getSession().invalidate();
                gotoPage("index.jsp", request, response);
                break;
            case "Doorgaan":
                String burger = request.getRemoteUser();
                request.getSession().setAttribute("notice", db.getBurger(burger).getNotice().intValue());
                request.getSession().setAttribute("burger", db.getBurger(burger));
                gotoPage("burger/gebruiker_overview.jsp", request, response);
                break;
            case "[x] Gelezen":
                db.setNotice(0, request.getRemoteUser());
                request.getSession().setAttribute("notice", db.getBurger(request.getRemoteUser()).getNotice().intValue());
                gotoPage("burger/gebruiker_overview.jsp", request, response);
                break;
            default:
                gotoPage("index.jsp", request, response);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void gotoPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
    }

}
