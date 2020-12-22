<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="adminHeader.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>

               <table class="tab">
                <tr>
                    <td>Id</td>
                    <td>Nick</td>
                    <td>Imię</td>
                    <td>Nazwisko</td>
                    <td>e-mail</td>
                    <td>Akcja</td>
                </tr>
                   <c:forEach items="${admins}" var="admin">
                <tr>

                    <td>${admin.id}</td>
                    <td>${admin.username}</td>
                    <td>${admin.firstname}</td>
                    <td>${admin.lastname}</td>
                    <td>${admin.email}</td>
                    <td><button class="btn--large"/></td>

                </tr>
                   </c:forEach>
               </table>


        </h1>
    </div>
</div>
</header>

<c:import url="adminFooter.jsp"/>