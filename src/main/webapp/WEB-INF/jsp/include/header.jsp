<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>

        #welcome {
            font-size: 20px;
            margin: 0px 5px 0px 5px;
            padding: 0px 0px 0px 10px;
        }

        #navBar {
            padding: 20px;
            background-color: black;
            font-size: large;
        }

        #siteHeader {
            float: left;
        }
        body{
            background-color: black;
        }

        /*#login {*/
        /*    float: right;*/
        /*    margin-right: 100px;*/
        /*    margin-bottom: 100px;*/

        /*}*/
    </style>
    <nav>
        <div id="navBar"><a href="/index">Home</a> &nbsp; | &nbsp; <a href="/product/all">Shop Classes</a> &nbsp; | &nbsp;
            &nbsp; | &nbsp; <a href="/product/search">Search Classes</a> &nbsp; | &nbsp; <a href="/cart/check-out/">My Classes</a>
            <a href="/index"><h2 id="siteHeader"> Rob's Muscle Gym&#129728;

                &nbsp; | &nbsp;
            </h2></a></div>

        <div id="authBar"><sec:authorize access="!isAuthenticated()">
            <a id="login"
               href="/login">Login</a>&nbsp; | &nbsp;<a id="login" href="/register/registerForm">Register</a>
        </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <span id="welcome">Lets Run, <sec:authentication property="principal.username"/></span>
                <span>&nbsp</span>
                <a id="navLogout" href="/login/logout">Logout</a> <a id="navAccount" href="/user/accountEditForm">Account</a>
            </sec:authorize>
            &nbsp; | &nbsp;
            <%-- easy example of how to show something gated off for ADMIN only.--%>
            <sec:authorize access="hasAuthority('ADMIN')">
                <a href="/user/search">Search Users</a>
                <span style="font-style: italic" id="welcome">Signed in as ADMIN.</span>
            </sec:authorize>
        </div
    </nav>
</html>