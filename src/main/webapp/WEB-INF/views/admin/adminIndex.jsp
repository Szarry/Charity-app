<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="adminHeader.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Witaj Administratorze: ${userName}<br/>
            Zarządzaj światem z tego miesjca!
        </h1>
    </div>
</div>
</header>

<c:import url="adminFooter.jsp"/>