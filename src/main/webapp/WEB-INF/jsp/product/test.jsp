div id="main">
<br>
<form action="/product/search" method="GET">
    Product Name : <input class="input" placeholder="search for products" type="text" name="productName" value="${productName}">
    <button id="btn" type="submit">Submit</button>
</form>
</div>

<br>

<c:if test="${not empty productName}">
    <h5>Search Results Found ${productsModelKey.size()}</h5>
    <br>
    <br>
</c:if>


<table style="width:50%"  class="table">
    <tr scope="row">
        <th>Product Name</th>
        <th>Product Id</th>
        <th>Product Description</th>
        <th>Price</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${productsModelKey}" var="product">
        <tr scope="row">
            <td>${product.name}</td>
            <td>${product.id}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>

            <td><a href="/product/edit/${product.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />

