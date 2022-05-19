
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
        function showPassword() {
            const x = document.getElementById("password");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
        function createOrg() {
            document.write("&lt;form id='form1' name='form1'action=''>");
            document.write(" &lt;td>&lt;input name='name' type='text' id='name'/>&lt;/td>");
            document.write("&lt;td>&lt;input name='address' type='text' id='address'/>&lt;/td>");
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
    <button class="__org_button" onclick="createOrg()">Create Organization</button>
</div>

<div>
</div>
</body>
</html>
