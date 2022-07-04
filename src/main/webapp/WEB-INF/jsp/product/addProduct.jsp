<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <style>
        body {
            margin: 0;
        }

        #main {
            margin: 0 auto;
            /*padding: 2rem 0;*/
            width: 90%;
            /*max-width: 60rem;*/
        }

        form {
            box-sizing: border-box;
            padding: 2rem;
            border-radius: 1rem;
            background-color: hsl(0, 0%, 100%);
            border: 4px solid hsl(0, 0%, 90%);
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 2rem;
        }

        .input {
            margin-bottom: 1.0rem;
            padding: 0.75rem 0.75rem;
        }

        #btn {
            border-radius: 0.25rem;
            cursor: pointer;
            padding: 0.75rem 1.25rem;
            /*margin-right: 20px;*/
            margin-left: 100px;
        }

    </style>
</head>
<jsp:include page="../include/header.jsp"/>

<body>
<h1>Add Product</h1>
<div class="container" id="main">
    <form action="/product/productSubmit" method="get">
        Id : <input class="input" type="text" name="productId" value="${form.productId}">
        <br>
        Name : <input class="input" type="text" name="productName" value="${form.productName}">
        <br>
        Description : <input class="input" type="text" name="description" value="${form.description}">
        <br>
        Image URL : <input class="input" type="text" name="imageUrl" value="${form.imageUrl}">
        <br>
        Price : <input class="input" type="text" name="price" value="${form.price}">
        <br>
        Category : <input class="input" type="text" name="category" value="${form.category}">

        <button type="submit" id="btn">Submit</button>
    </form>
</div>

<c:if test="${bindingResult.hasErrors()}">
    <br>

    <c:forEach items="${bindingResult.getAllErrors()}" var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
</c:if>

</body>
<jsp:include page="../include/footer.jsp"/>

</html>