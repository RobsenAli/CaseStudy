<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        .card {
            margin-bottom: 20px;
            margin-right: 50px !important;
        }
    </style>
</head>

<jsp:include page="../include/header.jsp"/>
<%--<table style="width:50%" class="table">--%>
<%--    <tr scope="row">--%>
<%--        <th>IMG</th>--%>
<%--        <th>Product Name</th>--%>
<%--&lt;%&ndash;        <th>Product Id</th>&ndash;%&gt;--%>
<%--        <th>Product Description</th>--%>
<%--        <th>Price</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${allProducts}" var="product">--%>
<%--        <tr scope="row">--%>
<%--            <td>${product.imgUrl}</td>--%>
<%--            <td>${product.name}</td>--%>
<%--                &lt;%&ndash;            <td>${product.id}</td>&ndash;%&gt;--%>
<%--            <td>${product.description}</td>--%>
<%--            <td>${product.price}</td>--%>
<%--            <td><a href="/product/edit/${product.id}">Buy Now</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<div class="container" style="margin:0 auto;">
    <div class="card-header my-3"> All Products</div>
    <div class="row">
        <div class="col-md-3" style="display: grid; grid-template-columns: 1fr 1fr 1fr">

            <c:forEach items="${allProducts}" var="product">
                <div class="card" style="width: 18rem;">
                    <img src="${product.imgUrl}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <h5 class="card-title">${product.price}</h5>
                        <h5 class="card-title">${product.category}</h5>
                        <button value="${product.id}" class="btn btn-primary buynow">Buy Now</button>
                        <a href="/cart/addTo-cart/${product.id}" class="btn btn-primary">Add To Cart</a>

                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">

</script>

<script src="../../../pub/js/buynow.js"></script>


<jsp:include page="../include/footer.jsp"/>
