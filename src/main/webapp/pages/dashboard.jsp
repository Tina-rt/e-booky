<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="com.ebooky.dao.*"%>
<%@page import="com.ebooky.models.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="./asset/css/style_dashboard.css">


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
    <div class="article">

        <div class="card-list">

            <div class="card-item">
                <div class="card-h1">
                    30
                </div>
                <div class="card-detail">
                    livre(s) vendu
                </div>
            </div>
            <div class="card-item bg-thirdly">
                <div class="card-h1">
                    4
                </div>
                <div class="card-detail">
                    livre(s) en cours de validation
                    <% 
                        ArrayList<Langue> ld = (ArrayList) request.getAttribute("all_langue");
//                        ArrayList<Langue> list_langue = ld.selectAllLangue();
//                        out.println(ld.size()   );
                    %>
                </div>
            </div>
        </div>
        <div class="">

        <div class="section-vente mg pad border-radius bg-thirdly">
            <h2>Les derniers livres vendues </h2>
            <div class="liste-vente">

            </div>
        </div>
        <div class="section-stock mg pad border-radius bg-thirdly" id="section-stock">
            <div class="section-stock-header">
                <h2>Stock</h2>
                <div class="btn btn-add" id="btn-add">Ajouter</div>
            </div>
            <div class="popup-add" id="popup-add">
                <div class="popup-header">
                    <h2>Ajouter un nouveau element</h2>
                </div>
                <form action="AjoutLivre" method="post" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td><label for="page_couverture">Page de couverture du livre</label></td>
                            <td>
                                <input type="file" name="page_couverture" id="page_couverture">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="titre">Titre du livre</label></td>
                            <td><input type="text" name="titre" id="titre"></td>
                        </tr>
                        <tr>
                            <td><label for="auteur">Auteur du livre</label></td>
                            <td><input type="text" name="auteur" id="auteur"></td>
                        </tr>
                        <tr>
                            <td><label for="prix">Prix du livre</label></td>
                            <td><input type="number" name="prix" id="prix"></td>
                        </tr>
                        <tr>
                            <td><label for="edition">Edition</label></td>
                            <td><input type="text" name="edition" id="edition"></td>
                        </tr>
                        <tr>
                            <td><label for="langue">Langue du livre </label></td>
                            <td>
                                <select name="langue">
                                    <% 
                                        for (int i=0; i < ld.size();i++){
                                    %>
                                    <option value="<%=ld.get(i).getId()%>"><%=ld.get(i).getNom()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="categorie">Categorie du livre </label></td>
                            <td>
                                <select name="categorie">
                                    <% 
                                        ArrayList<Categorie> all_categorie = (ArrayList) request.getAttribute("all_categorie");
                                        
                                        for (int i=0; i < all_categorie.size();i++){
                                    %>
                                    <option value="<%=all_categorie.get(i).getId()%>"><%out.println(all_categorie.get(i).getLabel());%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="ebook">Version ebook du livre</label></td>
                            <td><input type="file" name="ebook" id="ebook"></td>
                        </tr>
                        <tr>
                            <td><label for="description">Description du livre</label></td>
                        </tr>
                        <tr>
                            
                            <td colspan="2"><textarea name="description" id="description" cols="60" rows="10"></textarea></td>
                        </tr>
                        <tr>
                            <td><label for="quantite">Quantite</label></td>
                            <td><input type="number" name="quantite" id="quantite"></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="center-content">
                                <input class="btn btn-valider" type="submit" value="Sauvegarder">

                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="list-stock">
                <% 
                    ArrayList<Livre> all_livre = (ArrayList) request.getAttribute("all_livre");
                    for (int i=0;i<all_livre.size();i++){
                        %>
                
                <div class="stock-item">
                    <div class="livre">
                        <div class="livre-couverture"><img src="<%=getServletContext().getContextPath() + File.separator + all_livre.get(i).getPage_couverture()%>"/></div>
                        <div class="livre-titre"><a href="detail_livre?id_livre=<%=all_livre.get(i).getId()%>"><%=all_livre.get(i).getTitre()%></a></div>
                        <div class="livre-auteur"><span>Auteur: </span><%= all_livre.get(i).getAuteur().getNom() %></div>
                        <div class="livre-prix"><span>Prix:</span><%= all_livre.get(i).getPrix() %></div>
                        <div  class="quantite"><span>Quantite en stock:</span><%= all_livre.get(i).getQuantite() %></div>
                    </div>
                    
                </div>
                <%
                    }
                %>
               
            </div>
        </div>
    </div>

    </div>


</body>
<script>
    var btn_add = document.getElementById("btn-add");
    var popup = document.getElementById('popup-add');
    var open = false;
    btn_add.addEventListener("click", ()=>{
        if (!open){

            popup.style = "display: block;"
            btn_add.innerHTML = "Annuler"
        }else{
            popup.style = "display: none;"
            btn_add.innerHTML = "Ajouter"
        }
        open = !open;
    })

    


</script>
</html>