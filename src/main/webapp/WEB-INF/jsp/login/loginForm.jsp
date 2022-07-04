<jsp:include page="../include/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>
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
            padding: 3rem 0;
            width: 90%;
            max-width: 60rem;
        }
        form {
            box-sizing: border-box;
            padding: 3.5rem;
            border-radius: 1rem;
            background-color: hsl(0, 0%, 100%);
            border: 4px solid hsl(0, 0%, 90%);
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 2rem;
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




    </style>
</head>
<body>
<h1 style="margin-left: 4rem">Log in </h1>
<div id="main">
<form action="/login/loginSubmit" method="POST" id="form">

    Username : <input class="input" type="text" name="username" placeholder="username" class="input">
    <br>
    Password : <input class="input" type="password" name="password" placeholder="password" class="input">
    <br>
    <button id="btn" type="submit">Submit</button>
</form>
</div>
</body>
</html>


<jsp:include page="../include/footer.jsp"/>