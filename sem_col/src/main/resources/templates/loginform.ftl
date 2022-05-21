
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link rel='stylesheet' href='/resources/css/login.css'>
    <#--    <script src='/resources/js/lab10.js'></script>-->
    <script>
        function validate(){
            alert('Ok')
            return true;
        }
        function showPassword() {
            const x = document.getElementById("password");
            const y = document.getElementsByClassName("sign_form")
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
        function createOrg() {
            if ( document.getElementById("register").classList.contains('show_form') )
                document.getElementById("register").classList.replace('show_form','hide_form');

            else
                if (document.getElementById("register").classList.contains('hide_form'))
                    document.getElementById("register").classList.replace('hide_form','show_form');
                else
                    document.getElementById("register").classList.add('show_form')

        }


    </script>
</head>
<body>
<div class="__login">
        <div class="login_form">
            <form action="/login" method="post">
                <p style="color: aliceblue">Colombia's Bank</p>
                <div><input class="field" name="name" placeholder="Organization's Name"/></div>
                <div>
                    <input class="field" name="password" placeholder="Password" id="password" type="password" onclick="showPassword()"/>
                </div>
                <div><input class="field" type="submit" value="Log In"/></div>
            </form>
        </div>
</div>
<div class="__container_org">
    <p style="color: aliceblue">You Don't Have An Organization?</p>
    <a href="/register">
        <button class="__org_button">Create Organization</button>
    </a>

</div>

</body>
</html>
