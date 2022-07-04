<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>
<%@ page import="teksystems.casestudy.database.entity.OrderProduct" %>
<%@ page import="teksystems.casestudy.database.entity.Order" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fashionably Late Running Store</title>
</head>
<body>

<div class="container">
    <div class="d-flex py-3"><h3> Total Price:</h3><a class="mx-3 btn-primary" href="#">Check Out</a>
        <table class="table table-light">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Buy Now</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>
