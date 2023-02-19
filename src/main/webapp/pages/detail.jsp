<%-- 
    Document   : detail
    Created on : Feb 15, 2023, 2:52:45 AM
    Author     : Tina
--%>

<%@page import="java.io.File"%>
<%@page import="com.ebooky.models.Livre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detail</title>
        <link rel="stylesheet" href="./asset/css/style_dashboard.css">
        <link rel="stylesheet" href="./asset/css/style_dashboard_detail_livre.css">


    </head>

    <body>
        <nav class="">
            <h1 class="brand">Tableau de bord</h1>
            <div class="menu-list">
                <div class="menu-item">
                    <div class="menu-item-text">
                        Vente
                    </div>
                    <div class="border-bottom">
                    </div>

                </div>
                <div class="menu-item">
                    <div class="menu-item-text">
                        Commande en cours
                    </div>
                    <div class="border-bottom">
                    </div>
                </div>
                <div class="menu-item">
                    <div class="menu-item-text">
                        <a href="#section-stock">Stock</a>
                    </div>
                    <div class="border-bottom">
                    </div></div>
            </div>

        </nav>
    <body>
        <% 
            Livre livre = (Livre) request.getAttribute("current_livre");
            
        %>
        <div class="btn btn-precedent"> <a href="Dashboard"> < Precedent</a></div>
        <div class="detail-article">
            <div class="couverture-livre">
                <img src="<%=getServletContext().getContextPath() + File.separator + livre.getPage_couverture()%>" alt="image de couverture">
            </div>
                <div class="detail-livre">
                    <div class="titre-livre">
                        <%= livre.getTitre() %>
                    </div>
                    <div class="auteur-livre">
                        Darren Hardy
                    </div>
                    <div class="prix-livre">
                        20€
                    </div>
                    <div class="quantite-livre">17</div>
                    <div class="description">
                        <span>Description:</span>
                        <p>
                        <%= livre.getDescription() %>
                        </p>
                    </div>
                    <div class="ebook-livre"><a href="">Version ebooks</a></div>
                    <div class="btn-section">
                        <div class="btn">Modifier</div>
                        <div class="btn">Supprimer</div>
                    </div>
                </div>
        </div>
    </body>
</html>
