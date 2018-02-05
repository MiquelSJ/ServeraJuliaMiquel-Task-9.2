<%@ page import="com.iesemilidarder.projectzero.DBHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iesemilidarder.projectzero.Restaurants" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ca">
<head>
    <title>Restaurants</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css" >

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/png" href="http://elowcarbfoodlist.org/wp-content/uploads/2013/01/bacon-256.jpg"/>

</head>
<body>

<!-- Navigation bar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="index.jsp">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Inici<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="login.jsp">
                    <%
                        if (session.getAttribute("sessio")!=null){
                            out.println("Surtir");
                            session.invalidate();
                        } else {
                            out.println("Login");
                        }
                    %>

                    <span class="sr-only">(current)</span></a>
            </li>


            <li class="nav-item active">
                <%
                    String nomUsuari = (String) session.getAttribute("sessio");
                    if (session.getAttribute("sessio")!=null){
                        out.println("<a class=\"nav-link\">"+nomUsuari+"<span class=\"sr-only\">(current)</span></a>");
                    }

                %>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="login.jsp">Surtir<span class="sr-only">(current)</span></a>
            </li>

        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" name="cerca" type="text" placeholder="Cercar" aria-label="Cercar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cercar</button>
        </form>
    </div>


</nav>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Demana el que et demani el cos</h1>
            <h2>Menjar a domicili a prop de tu</h2>
        </div>
    </div>

    <div class="container">
            <%


            DBHelper dbHelper = new DBHelper();
            List<Restaurants> arrayRestaurants = dbHelper.getRestaurants(request.getParameter("cerca"));
            Iterator itr = arrayRestaurants.iterator();

            while (itr.hasNext()) {
                Restaurants std = (Restaurants) itr.next();
                out.println("<div class=\"row\">" +
                        "<div class=\"col-md-4\">" +
                        "<img class=\"img-fluid\" src=\""+ std.getImages()+"\">" +
                        "</div>" +
                        "<div class=\"col-md-8\">" +
                        "<h2>" + std.getName() + "</h2>" +
                        "<p>" + std.getAddress() + "</p>" +
                        "<p>" + std.getTelephone() + "</p>" +
                        "<p>" + std.getType() + "</p>" +
                        "<p>" + "<p>Puntuació ♥ " + std.getMitjana() + "</p>" +
                        "<p>" + "<a target=\"_blank\"class=\"btn btn-info\" href=\"./restaurant?id="+std.getCode()+"\" role=\"button\"> Més informació</a>" + "</a>" + "</p>" +
                        "</div>" +
                        "</div>"
                );
            }

        %>



</main>

<footer class="container">
    <p>&copy; Miquel Servera Julià 2017</p>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
