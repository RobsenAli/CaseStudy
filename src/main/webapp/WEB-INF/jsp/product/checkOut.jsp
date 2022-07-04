<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<h1>Check Out Information</h1>

<form action="/cart/addPay" method="POST">
    Credit Card <input name="creditCard" placeholder="credit card" type="text" required>
    Shipping Address <input name="shippingAddress" placeholder="address" type="text" required>

    <button id="btn" type="submit">check</button>

</form>


<jsp:include page="../include/footer.jsp"/>