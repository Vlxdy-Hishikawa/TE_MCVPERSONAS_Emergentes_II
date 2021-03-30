package com.Vlxdy.controlador;

import com.Vlxdy.modelo.Nota;
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
@WebServlet(name = "Procesa", urlPatterns = {"/Procesa"})
public class Procesa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
        Nota objnota = new Nota();
        int id,pos;
        HttpSession ses =request.getSession();
        ArrayList<Nota> lista = (ArrayList<Nota>)ses.getAttribute("listanota");       
        switch (opcion){
            case "nuevo":
                request.setAttribute("miobjnota", objnota);
                request.getRequestDispatcher("Editor.jsp").forward(request,response);
            break;
            case "editar":
                id=Integer.parseInt(request.getParameter("Id"));
                pos= buscarPorIndice(request,id);
                objnota = lista.get(pos);
                request.setAttribute("miobjnota", objnota);
                request.getRequestDispatcher("Editor.jsp").forward(request,response);
            break;
            case "eliminar":
                id=Integer.parseInt(request.getParameter("Id"));
                pos= buscarPorIndice(request,id);
                if (pos >= 0){
                    lista.remove(pos);
                }
                request.setAttribute("listanota", lista);
                response.sendRedirect("Index.jsp");
            break;
            default:
                request.setAttribute("listanota", lista);
                response.sendRedirect("Index.jsp");
            break;
        
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id= Integer.parseInt(request.getParameter("Id"));
            String hora = request.getParameter("Hora");
            String actividad = request.getParameter("Actividad");
            String completado= request.getParameter("Completado");
            HttpSession ses= request.getSession();
            ArrayList<Nota> lista = (ArrayList<Nota>)ses.getAttribute("listanota");
            Nota objnota = new Nota();
            objnota.setId(id);
            objnota.setHora(hora);
            objnota.setActividad(actividad);
            objnota.setCompletado(completado);
            System.out.println("EL ID ES" + id);
            if (id == 0){
                int idNuevo = obtenerId(request,id);
                objnota.setId(idNuevo);
                lista.add(objnota);
                System.out.println(objnota.toString());
            }else{
                int pos = buscarPorIndice(request,id);
                lista.set(pos,objnota);
                System.out.println(objnota.toString());
            }
            System.out.println("ENVIANDO AS INDEX");
            request.setAttribute("listanota",lista);
            response.sendRedirect("Index.jsp");
    }
    private int buscarPorIndice(HttpServletRequest request,int id){
    HttpSession ses =request.getSession();
    ArrayList<Nota> lista = (ArrayList<Nota>)ses.getAttribute("listanota");
        int pos = -1;
        if(lista != null){
            for (Nota kira : lista){
                ++pos;
                if(kira.getId()==id){
                    break;
                }
            }
        }
        return pos;
    }
    private int obtenerId(HttpServletRequest request,int id){
    HttpSession ses =request.getSession();
    ArrayList<Nota> lista = (ArrayList<Nota>)ses.getAttribute("listanota");
    int idn = 0;
        for (Nota kira : lista){
            idn = kira.getId();
        }
        return idn + 1;
    }
}

