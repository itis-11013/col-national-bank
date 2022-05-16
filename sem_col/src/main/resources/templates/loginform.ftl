
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Organization Login Form Spring Security</title>

    <link rel='stylesheet' href='/resources/css/login.css'>
<#--    <script src='/resources/js/lab10.js'></script>-->
    <script>
        function validate(){
            alert('Ok')
            return true;
        }
    </script>
</head>
<body>
    <div class="__login">
        <div class="login_text">
            <h1>Log In</h1>
        </div>

        <div class="login_form">
            <form action="/login" method="post" onsubmit="validate()">
                <p style="color: aliceblue">Colombia's Bank</p>
                <div><input class="field" name="name" placeholder="Company's Name"/></div>
                <div><input class="field" name="password" placeholder="Password"/></div>
                <div><input class="field" type="submit" value="Log In"/></div>
            </form>
            <div class="drops">
                <div class="drop drop-1"></div>
                <div class="drop drop-2"></div>
                <div class="drop drop-3"></div>
                <div class="drop drop-4"></div>
                <div class="drop drop-5"></div>
            </div>
        </div>
    </div>
</body>
</html>