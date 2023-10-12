     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Business Case Register</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<h1 class="text-center">Créer un compte</h1>

<form class="text-center" method="post">

    <ul>
        <c:forEach items="${errorsHibernate}" var = "hibernateError">
        <li>${hibernateError.message}</li>

        </c:forEach>

        <c:forEach items="${errors}" var = "error">
            <li>${error}</li>
        </c:forEach>

    </ul>

<div>
    <label class="form-control" for="nom">Nom</label>
    <input type="text" placeholder="Nom" id="nom" name="nom">
</div>
<div>
    <label class="form-control" for="prenom">Prenom</label>
    <input type="text" placeholder="Prenom" id="prenom" name="prenom">
</div>
<div>
    <label class="form-control" for="email">Email</label>
    <input type="email" placeholder="Email" id="email" name="email">
</div>
<div>
    <label class="form-control" for="password">Mot de passe</label>
    <input type="password" placeholder="password" id="password" name="password">
</div>

    <div>
        <label class="form-control" for="confirmpassword">Confirmer le mot de passe</label>
        <input type="password" placeholder="password" id="confirmpassword" name="confirmpassword">
    </div>

    <input class="btn btn-primary" type="submit">
</form>
</body>
</html>
