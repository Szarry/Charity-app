<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="<c:url value="/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>
</header>
w
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="AppUser" method="post">
        <div class="form-group">
            <form:input path="username" type="text" name="username" placeholder="Nick" />
            <form:errors path="username"/>
        </div>
        <div class="form-group">
            <form:input path="firstname" type="text" name="username" placeholder="Imię" />
            <form:errors path="firstname"/>
        </div>
        <div class="form-group">
            <form:input path="lastname" type="text" name="username" placeholder="Nazwisko" />
            <form:errors path="lastname"/>
        </div>
        <div class="form-group">
            <form:input path="email" type="email" name="email" placeholder="Email" />
            <form:errors path="email"/>
                ${messageEmail}
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password" placeholder="Hasło" />
            <form:errors path="password"/>
            ${messagePass}
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="<c:url value="/login"/> " class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<c:import url="footer.jsp"/>