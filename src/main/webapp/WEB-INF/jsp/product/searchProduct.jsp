<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Product</title>
    <style>
        h1 {
            text-align: center;
            position: relative;
            top: 10px;
            color: white;

        }

        h5 {
            text-align: center;
            position: relative;
            top: 10px;
            font-size: x-large;
            color: white;


        }

        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;


        }

        th, td {
            padding: 5px;
            text-align: left;
            color: white;

        }

        body {
            margin: 0;
        }

        #main {
            margin: 0 auto;
            padding: 3rem 0;
            width: 90%;
            max-width: 60rem;
            color: white;

        }

        .input {
            margin-bottom: 2.5rem;
            padding: 0.75rem 1.25rem;
            margin-right: 20px;
            color: white;

        }

        #btn {
            border-radius: 0.25rem;
            cursor: pointer;
            padding: 0.75rem 1.25rem;
            margin-right: 20px;
            color: white;

        }

        form {
            /*box-sizing: border-box;*/
            padding: 3.5rem;
            border-radius: 1rem;
            background-color: hsl(0, 0%, 100%);
            border: 4px solid hsl(0, 0%, 90%);
            /*display: grid;*/
            /*grid-template-columns: 1fr 1fr;*/
            /*gap: 2rem;*/
            color: white;


        }

        table {
            font-size: 20px;
            color: white;

        }

    </style>
</head>

<h1>Search Classes</h1>

<div id="main">
    <br>
    <form action="/product/search" method="GET">
        Product Name : <input class="input" placeholder="search for products" type="text" name="productName"
                              value="${productName}">
        <button id="btn" type="submit">Submit</button>
    </form>
</div>

<br>

<c:if test="${not empty productName}">
<h5>Search Results Found ${productsModelKey.size()}</h5>
<br>
<br>
</c:if>


<table style="width:50%" class="table">
    <tr scope="row">
        <th>Product Name</th>
        <%--        <th>Product Id</th>--%>
        <th>Product Description</th>
        <th>Price</th>
        <th>Image</th>
        <th>ADD Product</th>

    </tr>
    <c:forEach items="${productsModelKey}" var="product">
        <tr scope="row">
            <td>${product.name}</td>
                <%--            <td>${product.id}</td>--%>
            <td>${product.description}</td>
            <td>$${product.price}</td>
            <td><img style="width: 200px; height: 150px; " src="${product.imgUrl}"></td>

            <td><a href="/cart/addTo-cart/${product.id}">Add To Cart</a></td>
        </tr>
    </c:forEach>he
</table>


<jsp:include page="../include/footer.jsp"/>

