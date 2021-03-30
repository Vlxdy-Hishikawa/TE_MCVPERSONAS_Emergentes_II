<%-- 
    Document   : Editar
    Created on : 28-mar-2021, 20:40:28
    Author     : Vlxdy Hishikawa
--%>

<%@page import="com.Vlxdy.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Persona reg = (Persona)request.getAttribute("miobjper");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logo.png">
        <title> REGISTRO </title>
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
        form{
		width: 480px;
		padding: 16px;
		border-radius: 0px;
		margin: auto;
		background-color: #ccf;
	}
	form input[type="number"]{
		width: 200px;
		padding: 3px 10px;
		border:1px solid #f6f6f6;
		border-radius: 3px;
		background-color:#9f9;
		margin:8px 0;
		display: inline-block;
	}
        form input[type="text"]{
		width: 200px;
		padding: 3px 10px;
		border:1px solid #f6f6f6;
		border-radius: 3px;
		background-color:#9f9;
		margin:8px 0;
		display: inline-block;
	}
	form input[type="submit"]{
		width: 100%;
		padding: 8px 16px;
		margin-top: 32px;
		border:1px solid #1e3300;
		border-radius: 5px;
		display: block;
		color: #fff;
		background-color:#1e3300;
	}
	form input[type="submit"]:hover{
            
		cursor:pointer;
	}
        SELECT{ 
                width: 200px;
		padding: 3px 10px;
		border:1px solid #f6f6f6;
		border-radius: 3px;
		background-color:  #f6f6f6;
		margin:8px 0;
		display: inline-block;
            }
    </style>
    <body>
        <header>
                <h1 align="center"> REGISTRO DE PERSONAS </h1>
                <br><br>
        </header>
        <form action="MainServlet" method="POST">
            <h3 align="center">INTRODUZCA SUS DATOS</h3><br>
            <table>
                <tr>
                    <td><b>ID:</b></td>
                    <td><input type="number" name="Id" value="<%=reg.getId()%>" size="2" readonly required/></td>
                </tr>
                <tr>
                    <td><b>NOMBRES:</b></td>
                    <td><input type="Text" name="Nombres" value="<%=reg.getNombres()%>" required/></td>
                </tr>
                <tr>
                    <td><b>APELLIDOS:</b></td>
                    <td><input type="Text" name="Apellidos" value="<%=reg.getApellidos()%>" required/></td>
                </tr>
                <tr>
                    <td><b>EDAD:</b></td>
                    <td><input type="number" name="Edad" value="<%=reg.getEdad()%>" size="3" min="1" max="100" required/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="ENVIAR">
                    </td>
                </tr>
            </table>
	</form>
    <footer>
        <p><br><br>
            <h3 id="heading" align="center">DEVELOPED &#x1F497; by <a style="color:yellow;" ><strong>VLADIMIR HUANCA</strong></a></h3>
        </p>
    </footer>
    </body>
</html>