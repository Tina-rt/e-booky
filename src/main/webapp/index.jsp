<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" style="--bs-primary: #ff9c08;--bs-primary-rgb: 255,156,8;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - E-booky</title>
    <meta name="description" content="Site de vente de livres">
    <link rel="stylesheet" href="./asset/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="./asset/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md fixed-top navbar-shrink py-3" id="mainNav">
        <div class="container"><a class="navbar-brand d-flex align-items-center" href="/"><span>E-booky</span></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item"><a class="nav-link active" href="index.jsp">Acceuil</a></li>
                    <li class="nav-item"><a class="nav-link" href="livres.jsp">Livres</a></li>
                    <li class="nav-item"></li>
                    <li class="nav-item"><a class="nav-link" href="categorie.jsp">Categorie</a></li>
                    <li class="nav-item"><a class="nav-link" href="contacts.jsp">Contacts</a></li>
                </ul><button class="btn btn-primary btn-warning icon icon-market rounded" type="button" style="margin-right: 22px;">P</button><a class="btn btn-primary shadow" role="button" href="login.jsp">Se connecter</a>
            </div>
        </div>
    </nav>
    <header class="pt-5">
        <div class="container pt-4 pt-xl-5">
            <div class="row pt-5">
                <div class="col-md-8 text-center text-md-start mx-auto">
                    <div class="text-center">
                        <h1 class="display-4 fw-bold mb-5">Acheter des livres en un&nbsp;<span class="underline">clique</span>.</h1>
                        <p class="fs-5 text-muted mb-5">« E-booky » est un site de vente de livre sur internet. Les livres sont<br>disponibles en version physique et numerique.</p>
                        <form class="d-flex justify-content-center flex-wrap" method="post">
                            <div class="shadow-lg mb-3"><input class="form-control" type="email" placeholder="Entrer votre recherche"></div>
                            <div class="shadow-lg mb-3"><button class="btn btn-primary" type="submit">Rechercher</button></div>
                        </form>
                    </div>
                </div>
                <div class="col-12 col-lg-10 mx-auto">
                    <div class="text-center position-relative"></div>
                </div>
            </div>
        </div>
    </header>
    <section></section>
    <section>
        <div class="container py-4 py-xl-5">
            <div class="row">
                <div class="col-md-6">
                    <h3 class="display-6 fw-bold pb-md-4">Pourquoi acheter des livres sur&nbsp;<span class="underline">E-booky</span>?</h3>
                </div>
            </div>
            <div class="row gy-4 gy-md-0">
                <div class="col-md-6 d-flex d-sm-flex d-md-flex justify-content-center align-items-center justify-content-md-start align-items-md-center justify-content-xl-center">
                    <div>
                        <div class="row gy-2 row-cols-1 row-cols-sm-2">
                            <div class="col text-center text-md-start">
                                <div class="d-flex justify-content-center align-items-center justify-content-md-start"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-sun fs-3 text-primary bg-warning">
                                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                        <circle cx="12" cy="12" r="4"></circle>
                                        <path d="M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7"></path>
                                    </svg>
                                    <h5 class="fw-bold mb-0 ms-2">Commande en ligne</h5>
                                </div>
                                <p class="text-muted my-3">Acheter des livres sans avoir à se deplacer</p>
                            </div>
                            <div class="col text-center text-md-start">
                                <div class="d-flex justify-content-center align-items-center justify-content-md-start"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-sun fs-3 text-primary bg-warning">
                                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                        <circle cx="12" cy="12" r="4"></circle>
                                        <path d="M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7"></path>
                                    </svg>
                                    <h5 class="fw-bold mb-0 ms-2">Vaste choix&nbsp;</h5>
                                </div>
                                <p class="text-muted my-3">Offre un multitude de choix de livres qu'une librairie physique.</p>
                            </div>
                            <div class="col text-center text-md-start">
                                <div class="d-flex justify-content-center align-items-center justify-content-md-start"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-sun fs-3 text-primary bg-warning">
                                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                        <circle cx="12" cy="12" r="4"></circle>
                                        <path d="M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7"></path>
                                    </svg>
                                    <h5 class="fw-bold mb-0 ms-2">Tarifs abordable</h5>
                                </div>
                                <p class="text-muted my-3">Offre des tarifs abordable pour tous</p>
                            </div>
                            <div class="col text-center text-md-start">
                                <div class="d-flex justify-content-center align-items-center justify-content-md-start"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-sun fs-3 text-primary bg-warning">
                                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                        <circle cx="12" cy="12" r="4"></circle>
                                        <path d="M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7"></path>
                                    </svg>
                                    <h5 class="fw-bold mb-0 ms-2">Accesible 24/7</h5>
                                </div>
                                <p class="text-muted my-3">Vous pouvez commander à tout moment</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 order-first order-md-last">
                    <div><img class="rounded img-fluid w-100 fit-cover" style="min-height: 300px;" src="./asset/img/teamwork.svg"></div>
                </div>
            </div>
        </div>
    </section>
    <section></section>
    <section class="py-5" style="--bs-primary: #ff9c08;--bs-primary-rgb: 255,156,8;">
        <div class="container py-4 py-xl-5">
            <div class="row mb-5">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <h2 class="display-6 fw-bold mb-4">Nos&nbsp;<span class="underline">Livres</span></h2>
                    <p class="text-muted">Curae hendrerit donec commodo hendrerit egestas tempus, turpis facilisis nostra nunc. Vestibulum dui eget ultrices.</p>
                </div>
            </div>
            <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3">
                <div class="col">
                    <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="./asset/img/report.svg">
                        <div class="card-body p-4">
                            <div class="row">
                                <div class="col">
                                    <p class="text-primary mb-0" id="date-publication">05-22-2006</p>
                                </div>
                                <div class="col">
                                    <p class="text-primary mb-0" id="date-publication-1" style="font-style: italic;">Categorie</p>
                                </div>
                            </div>
                            <h4 class="card-title" id="titre-llivre" style="font-weight: bold;">Why windows users are stupid?</h4>
                            <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                            <div class="d-flex"><button class="btn btn-primary" type="button">Free</button></div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="./asset/img/ranking.svg">
                        <div class="card-body p-4">
                            <div class="row">
                                <div class="col">
                                    <p class="text-primary mb-0" id="date-publication-4">05-22-2006</p>
                                </div>
                                <div class="col">
                                    <p class="text-primary mb-0" id="date-publication-5" style="font-style: italic;">Devellopement</p>
                                </div>
                            </div>
                            <h4 class="card-title" id="titre-llivre" style="font-weight: bold;">Machin learning for baby</h4>
                            <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                            <div class="d-flex"><button class="btn btn-primary" type="button">60000 Ar</button></div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="./asset/img/startup.svg">
                        <div class="card-body p-4">
                            <div class="row">
                                <div class="col">
                                    <p class="text-primary mb-0" id="date-publication-2">05-22-2006</p>
                                </div>
                                <div class="col">
                                    <p class="text-primary mb-0" id="date-publication-3" style="font-style: italic;">Novel</p>
                                </div>
                            </div>
                            <h4 class="card-title" id="titre-llivre" style="font-weight: bold;">The Begining After The End</h4>
                            <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                            <div class="d-flex"><button class="btn btn-primary" type="button">90000 Ar</button></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col" style="margin-bottom: -62px;padding-bottom: 0px;padding-top: 34px;">
                    <div class="row mb-5">
                        <div class="col-md-8 col-xl-6 text-center mx-auto"><button class="btn btn-sm px-0">Voir plus&nbsp;<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-arrow-right">
                                    <path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"></path>
                                </svg><br></button></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="py-4 py-xl-5">
        <div class="container">
            <div class="text-white bg-primary border rounded border-0 border-primary d-flex flex-column justify-content-between flex-lg-row p-4 p-md-5">
                <div class="pb-2 pb-lg-1">
                    <h2 class="fw-bold text-warning mb-2">Des remarques?</h2>
                    <p class="mb-0">Contactez-nous</p>
                </div>
                <div class="my-2"><a class="btn btn-light fs-5 py-2 px-4" role="button" href="contacts.jsp">Contactez-nous</a></div>
            </div>
        </div>
    </section>
    <footer>
        <div class="container py-4 py-lg-5">
            <div class="row row-cols-2 row-cols-md-4">
                <div class="col-12 col-md-3">
                    <div class="fw-bold d-flex align-items-center mb-2"><span>E-booky</span></div>
                    <p class="text-muted">Site de vente de livres</p>
                </div>
                <div class="col-sm-4 col-md-3 text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Ventes</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">Livres physiques</a></li>
                        <li><a href="#">Livres numeriques</a></li>
                        <li></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Appropos</h3>
                    <ul class="list-unstyled">
                        <li></li>
                        <li><a href="#">Developpé par Tina et Luca</a></li>
                        <li></li>
                    </ul>
                </div>
            </div>
            <hr>
            <div class="text-muted d-flex justify-content-between align-items-center pt-3">
                <p class="mb-0">Copyright © 2023 E-booky</p>
                <ul class="list-inline mb-0">
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-facebook">
                            <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"></path>
                        </svg></li>
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-twitter">
                            <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"></path>
                        </svg></li>
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-instagram">
                            <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"></path>
                        </svg></li>
                </ul>
            </div>
        </div>
    </footer>
    <script src="./asset/bootstrap/js/bootstrap.min.js"></script>
    <script src="./asset/js/script.js"></script>
</body>

</html>