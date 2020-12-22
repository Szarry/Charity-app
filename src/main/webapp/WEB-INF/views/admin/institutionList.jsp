<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="adminHeader.jsp"/>
<div class="login-page">
    <div>
        <a href="/admin/institutionAdd" class="btn btn--without-border" id="FormButton">Dodaj nową instytucję</a>
    </div>

    <table class="GeneratedTable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${institutionList}" var="institution">
            <tr>
                <td>${institution.id}</td>
                <td>${institution.name}</td>
                <td>${institution.description}</td>
                <td><a href="<c:url value="/admin/institutionEdit/${institution.id}"/>" class="btn--small">
                    <span class="text">Edytuj</span></a>
                    <a href="<c:url value="/admin/institutionDelete/${institution.id}"/>"
                       onClick="if(confirm('Czy na pewno chcesz usunąć pozycję?')==false) return false;"
                       class="btn--small"><span class="text">Usuń</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</header>

<c:import url="adminFooter.jsp"/>