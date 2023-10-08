<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 07/10/2023
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Business Case Register</title>
</head>
<body>
<h1>Créer un compte</h1>

<form method="post">
<div>
    <label for="nom">Nom</label>
    <input type="text" placeholder="Nom" id="nom" name="nom">
</div>
<div>
    <label for="prenom">Prenom</label>
    <input type="text" placeholder="Prenom" id="prenom" name="prenom">
</div>
<div>
    <label for="email">Email</label>
    <input type="email" placeholder="Email" id="email" name="email">
</div>
<div>
    <label for="password">Mot de passe</label>
    <input type="password" placeholder="password" id="password" name="password">
</div>

    <div>
        <label for="confirmpassword">Confirmer le Mot de passe</label>
        <input type="password" placeholder="password" id="confirmpassword" name="confirmpassword">
    </div>

    <input type="submit">
</form>
</body>
</html>
