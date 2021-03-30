package com.Vlxdy.controller;

import com.Vlxdy.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vlxdy Hishikawa
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String opcion = request.getParameter("op");
        Persona objper = new Persona();
        int id,pos;
        HttpSession ses =request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
        
        switch (opcion){
            case "nuevo":
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("Editar.jsp").forward(request,response);
            break;
            case "editar":
                id=Integer.parseInt(request.getParameter("Id"));
                pos= buscarPorIndice(request,id);
                objper = lista.get(pos);
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("Editar.jsp").forward(request,response);
            break;
            case "eliminar":
                id=Integer.parseInt(request.getParameter("Id"));
                pos= buscarPorIndice(request,id);
                if (pos >= 0){
                    lista.remove(pos);
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("Index.jsp");
            break;
            default:
                request.setAttribute("listaper", lista);
                response.sendRedirect("Index.jsp");
            break;
        
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            int id= Integer.parseInt(request.getParameter("Id"));
            String nombres = request.getParameter("Nombres");
            String apellidos = request.getParameter("Apellidos");
            int edad= Integer.parseInt(request.getParameter("Edad"));
            HttpSession ses= request.getSession();
            ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
            Persona objper = new Persona();
            objper.setId(id);
            objper.setNombres(nombres);
            objper.setApellidos(apellidos);
            objper.setEdad(edad);
            System.out.println("EL ID ES" + id);
            if (id == 0){
                int idNuevo = obtenerId(request,id);
                objper.setId(idNuevo);
                lista.add(objper);
                System.out.println(objper.toString());
            }else{
                int pos = buscarPorIndice(request,id);
                lista.set(pos,objper);
                System.out.println(objper.toString());
            }
            System.out.println("ENVIANDO AS INDEX");
            request.setAttribute("listaper",lista);
            response.sendRedirect("Index.jsp");
    }
    private int buscarPorIndice(HttpServletRequest request,int id){
    HttpSession ses =request.getSession();
    ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
        int pos = -1;
        if(lista != null){
            for (Persona ele : lista){
                ++pos;
                if(ele.getId()==id){
                    break;
                }
            }
        }
        return pos;
    }
    private int obtenerId(HttpServletRequest request,int id){
    HttpSession ses =request.getSession();
    ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
    int idn = 0;
        for (Persona ele : lista){
            idn = ele.getId();
        }
        return idn + 1;
    }
}
