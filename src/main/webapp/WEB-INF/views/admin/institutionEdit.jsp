<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:import url="adminHeader.jsp"/>
<div class="login-page">

    <form:form modelAttribute="institution" class="form-horizontal" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Edycja Istytucji / organizacji : ${institution.name}</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Nazwa</label>
                <div class="col-md-4">
                    <form:input path="name" id="name" name="name" type="text"
                                class="form-control input-md"></form:input>
                    <form:errors path="name"/>
                </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Opis</label>
                <div class="col-md-4">
                    <form:textarea path="description" name="description"  min="0" rows="10"></form:textarea>
                    <form:errors path="description"/>
                </div>
            </div>
            <button class="btn--large" type="submit" name="save">Zapisz zmiany</button>

        </fieldset>
    </form:form>
</div>

    </header>

<c:import url="adminFooter.jsp"/>