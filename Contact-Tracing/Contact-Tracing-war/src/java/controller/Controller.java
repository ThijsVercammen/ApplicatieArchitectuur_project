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
import model.Arts;
import model.Burger;
import session_beans.Db_beanLocal;

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
    @EJB private Db_beanLocal db;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("submit");
        
        if(action.equals("Meld aan")){
            String rol = request.getParameter("rol");
            if(rol.equals("burger")){
                String naam = request.getParameter("gebruikersnaam");
                Burger b = db.getBurger(naam);
                if(b != null ){
                    String wachtwoord = request.getParameter("wachtwoord");
                    if(db.checkWachtwoord(b, wachtwoord)){
                        request.getSession().setAttribute("burger", b);
                        gotoPage("gebruiker_overview.jsp", request, response);
                    }
                }
            } else if(rol.equals("arts")){
                String naam = request.getParameter("gebruikersnaam");
                Arts a = db.getArts(naam);
                if(a != null ){
                    String wachtwoord = request.getParameter("wachtwoord");
                    if(db.checkWachtwoord(a, wachtwoord)){
                        request.getSession().setAttribute("arts", a);
                    }
                }
            }
            request.setAttribute("error", "Uw ingegeven gegevens zijn niet correct!");
            gotoPage("index.jsp", request, response);
        } else if(action.equals("nieuw_contact")){
            gotoPage("nieuw_contact.jsp", request, response);
        }else if(action.equals("test_aanvragen")){
            gotoPage("test_aanvragen.jsp", request, response);
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

    protected void gotoPage(String page,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
    }

}
