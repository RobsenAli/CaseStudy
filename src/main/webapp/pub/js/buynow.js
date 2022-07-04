$(document).ready(function () {
    $(".buynow").on("click", function (e) {
        console.log("clicked")
        $.ajax({
            url: "/cart/addTo-cart/" + e.target.value,
            type: "GET",
            success: function (data) {
                window.location.href = "/cart/pay"
            }
        })
    })
})
