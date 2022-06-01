
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

    <link rel='stylesheet' href='/col/resources/css/login.css'>
    <#--    <script src='/resources/js/lab10.js'></script>-->

</head>
<body>

<div id="register" class="show_form">
    <form action="/col/register" method="post">
        <p style="color: aliceblue">Colombia's Bank</p>
        <div>
            <input class="field" name="name" placeholder="Organization's Name"/>
        </div>
        <div>
            <input class="field" name="address" placeholder="Address" id="address" onclick="showPassword()"/>
        </div>
        <div>
            <input class="field" name="password" placeholder="Password" id="password" type="password" onclick="showPassword()"/>
        </div>
        <div><input class="field" type="submit" value="Sign Up"/></div>
    </form>

</div>
<div class="__container_org">
    <a href="/col/login">
        <button class="__org_button">Go Back To Log In</button>
    </a>

</div>

</body>
</html>
>