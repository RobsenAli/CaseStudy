<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<head>
    <style>
        h1 {
            text-align: center;
            position: relative;
            top: 10px;
        }

        input {
            margin-bottom: 2.5rem;
            padding: 0.75rem 1.25rem;
            margin-right: 20px;
        }

        form {
            box-sizing: content-box;
            border-radius: 1rem;
            background-color: hsl(0, 0%, 100%);
            border: 4px solid hsl(0, 0%, 90%);
            padding: 30px;
            margin: 100px;

        }
    </style>

</head>

<div class="mainContent">
    <sec:authorize access="isAuthenticated()">
        <h1>Edit Account</h1>
        <form action="/user/accountEditSubmit" method="get">
            <input type="hidden" name="id" value="${form.id}">
            <h3>Edit name</h3>
            <label for="firstNameId">First name:</label>
            <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">
            <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>

            <label for="lastNameId">Last name:</label>
            <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">
            <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>

            <h3>Change password</h3>
            <label for="newPasswordId">New password:</label>
            <input type="password" name="newPassword" id="newPasswordId" value="${form.newPassword}">
            <c:forEach items='${bindingResult.getFieldErrors("newPassword")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>

            <label for="confirmPasswordId">Confirm new password:</label>
            <input type="password"
                   name="confirmPassword" id="confirmPasswordId" value="${form.confirmPassword}">
            <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>
            <h6> Make Changes</h6>
            <input type="radio" name="checkbox">
            <button class="btn btn-primary" type="submit">Change</button>

        </form>

        <c:if test="${bindingResult.hasErrors()}">
            <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </c:if>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <p>Not authorized.</p>
        <a href="/register/registerForm">
            <button class="btn-primary">Register</button>
        </a>
    </sec:authorize>
</div>

<jsp:include page="../include/footer.jsp"/>
