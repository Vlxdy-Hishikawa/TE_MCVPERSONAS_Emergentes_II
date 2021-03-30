<%-- 
    Document   : Index
    Created on : 28-mar-2021, 22:14:10
    Author     : Vlxdy Hishikawa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.Vlxdy.modelo.Nota"%>
<%
    if (session.getAttribute("listanota") == null){
        ArrayList<Nota> la = new ArrayList<Nota>();
        session.setAttribute("listanota", la);
    }
    ArrayList<Nota> lista = (ArrayList<Nota>) session.getAttribute("listanota");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logo.png">
        <title> LISTADO </title>
    </head>
    <style>
        body {
  		background-image: linear-gradient(
     		rgba(0, 0, 0, 0.6),
     		rgba(0, 0, 0, 0.6)
   			), url("Fondo.png");
  			background-repeat: no-repeat;
 			background-attachment: fixed;
  			background-size: 100% 100%;
  			padding: 20px;
  			background-color:#dbffcc;
		}
        #heading { color: #fff; }
	a,h1,h2,h4,li{
		color: white;
                }
        b{
	   color: yellow;
        }
        table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        }
        th {
          border: 1px solid white;
          background-color:black;
          color: white;
          text-align: left;
          padding: 8px;
        }

        td {
          border: 1px solid black;
          text-align: left;
          padding: 8px;
        }

        tr:nth-child(odd) {
          background-color: #dddddd;
        }
        tr:nth-child(even) {
          background-color: white;
          color:black;
        }
    </style>
    <body>
        <h1 align="center"> LISTADO DE NOTAS DE LA AGENDA PERSONAL </h1>
        <a href="Procesa?op=nuevo">NUEVO REGISTRO</a>
        <br><br>
        <table>
            <tr>
                <th>ID</th>
                <th>HORA</th>
                <th>ACTIVIDAD</th>
                <th>COMPLETADO</th>
                <th></th>
                <th></th>
            </tr>
            <%    
                if (lista != null) {
                    for (Nota item : lista) {
            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getHora()%></td>
                <td><%=item.getActividad()%></td>
                <td><%=item.getCompletado()%></td>
                <td><a style="color:blue;" href="Procesa?op=editar&Id=<%=item.getId()%>">EDITAR</a></td>
                <td><a style="color:red;" href="Procesa?op=eliminar&Id=<%=item.getId()%>" onclick="return(confirm('ESTA SEGURO DE ELIMINAR ??  '))">ELIMINAR</a></td>
            </tr>
            <%    
                    }
                }
            %>
        </table>
    <footer>
        <br><br>
        <br><br>
	<p>
            <h3 id="heading" align="center">DEVELOPED &#x1F497; by <a style="color:yellow;" ><strong>VLADIMIR HUANCA</strong></a></h3>
        </p>
    </footer>
    </body>
</html>