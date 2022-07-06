<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>THANK YOU!!</title>
    <style>
        h1 {
            text-align: center;
            position: relative;
        }

        body {/
        margin: 0;
        }
        #main {
            margin: 0 auto;
            padding: 3rem 0;
            width: 90%;
            max-width: 60rem;
            padding: 3.5rem;
            border-radius: 1rem;
            background-color: hsl(0, 0%, 100%);
            border: 4px solid hsl(0, 0%, 90%);
            margin-top: 30px;
        }
        p{
            margin-block: 20px;
            text-align: center;
            font-size: larger;
        }
        #current_date{
            font-size: larger;
            text-align: center;
        }

    </style>
</head>
<body>
</div>
<div class="container" id="main">
    <h1>SUCCESS</h1>
    <p>Order Placed! Thank you. <br>Here are your details:
        <br>
        Purchase day:
        <br>
    <div id="current_date"></p>
    Total:
    Receipt Id:
        <script>
            document.getElementById("current_date").innerHTML = Date();
        </script><br>
        <br>

    </div>

</div>
</body>
</html>

<jsp:include page="../include/footer.jsp"/>