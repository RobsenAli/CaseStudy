<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        h1 {
            text-align: center;
            position: relative;
            top: 10px;

        }

        body {
            margin: 0;
        }

        #main {
            margin: 0 auto;
            padding: 1rem 0;
            width: 90%;
            max-width: 60rem;
        }

        form {
            box-sizing: border-box;
            padding: 2.5rem;
            border-radius: 1rem;
            background-color: hsl(0, 0%, 100%);
            border: 4px solid hsl(0, 0%, 90%);
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1rem;
        }

        #btn {
            border-radius: 0.25rem;
            cursor: pointer;
            padding: 0.75rem 1.25rem;
            margin-right: 20px;
        }

        .input {
            margin-bottom: 2.5rem;
            padding: 0.75rem 1.25rem;
        }

        .error {
            text-align: center;
        }

        select {

        }

    </style>


</head>

<div class="container" id="main">
    <form action="/registerSubmit" method="post">
        <input type="hidden" name="id" value="${form.id}">

        Email <input class="input" type="text" name="email" id="emailId" value="${form.email}">
        <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
            <div class="error" style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <br>
        First Name <input class="input" type="text" name="firstName" id="firstNameId" value="${form.firstName}">
        <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
            <div class="error" style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <br>
        Last Name <input class="input" type="text" name="lastName" id="lastNameId" value="${form.lastName}">
        <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
            <div class="error" style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <br>
        Password <input class="input" type="password" name="password" id="passwordId" value="${form.password}">
        <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
            <div class="error" style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <br>
        Confirm Password <input class="input" type="password"
                                name="confirmPassword" id="confirmPasswordId" value="${form.confirmPassword}">
        <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
            <div class="error" style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <h5> I agree to
            <bold>terms of service</bold>
        </h5>
        <input type="checkbox" name="checkbox">
        </h5>
        <button type="submit" id="btn">Submit</button>
    </form>
</div>

<c:if test="${bindingResult.hasErrors()}">
<br>

<c:forEach items="${bindingResult.getAllErrors()}" var="error">
<div style="color:red;">${error.getDefaultMessage()}</div>
</c:forEach>
</c:if>


<jsp:include page="../include/footer.jsp"/>
