<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="userHeader.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Zacznij pomagać!<br/>
            Oddaj niechciane rzeczy w zaufane ręce
        </h1>
        <li>
            <a href="<c:url value="/user/form"/>" id="FormButton" class="btn btn--without-border">Formularz przekazania darów</a>
        </li>
    </div>
</div>
</header>

<c:import url="userFooter.jsp"/>