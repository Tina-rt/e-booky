<%-- Document : detail Created on : Feb 15, 2023, 2:52:45 AM Author : Tina --%>

<%@page import="java.io.File" %>
<%@page import="com.ebooky.models.Livre" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                    <a href="Dashboard#section-stock">Stock</a>
                </div>
                <div class="border-bottom">
                </div>
            </div>
        </div>

    </nav>

    <body>
        <% Livre livre=(Livre) request.getAttribute("current_livre"); %>
            <div class="btn btn-precedent"> <a href="Dashboard">
                    < Precedent</a>
            </div>
            <div class="detail-section">

                <div class="detail-article">
                    <div class="couverture-livre">
                        <img src="<%=getServletContext().getContextPath() + File.separator + livre.getPage_couverture()%>"
                            alt="image de couverture">
                    </div>
                    <div class="detail-livre">
                        <div class="titre-livre">
                            <%= livre.getTitre() %>
                        </div>
                        <div class="auteur-livre">
                            <%= livre.getAuteur().getNom() %>
                        </div>
                        <div class="prix-livre">
                            <%= livre.getPrix() %> Ariary
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
                            <div class="btn" id="btn_modifier">Modifier</div>
                            <div class="btn"> <a href="delete_livre?id_livre=<%=livre.getId()%>">Supprimer</a></div>
                        </div>
                    </div>
                </div>
                <div class="edit-livre" id="edit-livre">
                    <form action="">
                        <table>
                            <tr>
                                <td><label for="titre">Titre</label></td>
                                <td><input type="text" value="<%=livre.getTitre() %>" name="titre"
                                        id="titre"></td>
                            </tr>
                            <tr>
                                <td><label for="auteur">Auteur</label></td>
                                <td><input type="text" value="<%= livre.getAuteur().getNom() %>"
                                        name="auteur" id="auteur"></td>
                            </tr>
                            <tr>
                                <td><label for="prix">Prix</label></td>
                                <td><input type="number" value="<%=livre.getPrix() %>" name="prix"
                                        id="prix" step="0.01"></td>
                            </tr>
                            <tr>
                                <td><label for="quantite">Quantite en stock</label></td>
                                <td><input type="number" name="quantite"
                                        value="<%=livre.getQuantite() %>" id="quantite" step="1"></td>
                            </tr>
                            <tr>
                                <td><label for="description">Description</label></td>
                                <td><textarea name="description" id="description" cols="30"
                                        rows="10"><%=livre.getDescription() %></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="valider" class="btn"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>

    </body>
<script>
let btn_edit = document.getElementById("btn_modifier");
let edit_livre = document.getElementById("edit-livre");
edit_livre.style = "display:none;";
btn_edit.addEventListener("click", (e) => {
    edit_livre.style.display = 'block';
    console.log("tonga")
})

</script>
</html>