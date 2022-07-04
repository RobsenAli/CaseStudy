<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Users</title>
    <style>
        h1 {
            text-align: center;
            position: relative;
            top: 10px;
        }

        h5 {
            text-align: center;
            position: relative;
            top: 10px;
            font-size: x-large;

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
        }

        body {
            margin: 0;
        }

        #main {
            margin: 0 auto;
            padding: 3rem 0;
            width: 90%;
            max-width: 60rem;
        }

        .input {
            margin-bottom: 2.5rem;
            padding: 0.75rem 1.25rem;
            margin-right: 20px;
        }

        #btn {
            border-radius: 0.25rem;
            cursor: pointer;
            padding: 0.75rem 1.25rem;
            margin-right: 20px;
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
        }


    </style>
</head>

<h2 style="margin-top: -20px; text-align: center">Cart</h2>

<table  style=" margin-left: auto; margin-right: auto;table-layout: auto;width: 60%; margin-top: -5px" class="table">
    <tr scope="row">
        <th>Product Name</th>
        <%--        <th>Pid</th>--%>
        <th>Order Id</th>
        <th>Quantity</th>
        <th>price</th>
        <th>Total</th>
        <th>Remove</th>


    </tr>
    <c:forEach items="${cartProducts}" var="cp">
        <tr scope="row">
            <td>${cp.name}</td>
                <%--            <td>${cp.product_id}</td>--%>
            <td>${cp.order_id}</td>
            <td>${cp.quantity}</td>
            <td>${cp.price}</td>
            <td>${cp.total}</td>
            <td>  <a href="/cart/deleteItem/${cp.id}" class="btn btn-secondary">Remove ${cp.name} from cart</a></td>

        </tr>

    </c:forEach>
</table>
<a href="/cart/checkout" class="btn btn-primary" style="margin-left: auto; margin-right: auto; text-align: center">Check Out</a>

<script>
    const btn = document.getElementById('checkout');

    btn.addEventListener('click', function onClick() {
        btn.style.backgroundColor = 'green';
        btn.style.color = 'white';
    });
</script>


<%--<jsp:include page="../include/footer.jsp"/>--%>