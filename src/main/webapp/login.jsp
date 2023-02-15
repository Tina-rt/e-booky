<%@page import="com.ebooky.models.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
	<meta charset="UTF-8">
	<title>E-booky</title>
	<link rel="stylesheet" href="./asset/css/style.css">
</head>

<body>
	<div class="login_container">
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form action="#">
					<h1>Crée un compte</h1>
					<input type="text" name="nom-inscription" placeholder="Nom" />
					<input type="text" name="prenom-inscription" placeholder="Prenom" />
					<input type="email" name="email-inscription" placeholder="Email" />
					<input type="password" name="mdp-inscription" placeholder="Mot de passe" />
					<button type="submit">Crée un compte</button>
				</form>
			</div>
			<div class="form-container sign-in-container">
				<form action="login-utilisateur" method="post">
					<h1>Se connecter</h1>
					<input type="email" name="email-login" placeholder="Email" />
					<input type="password" name="mdp-login" placeholder="Mot de passe" />
					<a href="#">Mot de passe oublié?</a>
					<button type="submit">Se connecter</button>
				</form>
			</div>
			<div class="overlay-container">
				<div class="overlay">
					<div class="overlay-panel overlay-left">
						<h1>Bienvenu</h1>
						<p>Vous avez déja un compte? cliquez sur se connecter</p>
						<button class="bton" id="signIn">Se connecter</button>
					</div>
					<div class="overlay-panel overlay-right">
						<h1>Bienvenu</h1>
						<p>Si vous n'avez pas de compte, cliquez sur Crée un compte</p>
						<button class="bton" id="signUp">Crée un compte</button>
					</div>
				</div>
			</div>
		</div>
		<script src="./asset/js/script.js"></script>
	</div>
</body>

</html>