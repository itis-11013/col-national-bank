<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>add products for sale</title>
</head>
<body>
<h></h>
<div class="__login">
    <div class="login_form">
        <form action="/login" method="post">
            <div>
                <label> units : </label>
                <select name="units" style="width:250px">
                    <#list units as a>
                        <option name="producto">${a.type}</option>
                    </#list>
                </select>
            </div>

            <div>
                <label> producto : </label>
                <select name="producto" style="width:250px">
                    <#list producto as category>
                        <option name="producto">${category.name}</option>
                    </#list>
                </select>
            </div>
            <div>
                <label>Quantity</label>
                <input type="number" name="quantity" placeholder="quantity" id="quantity">
            </div>
            <div>
                <label>Price</label>
                <input type="number" name="price" placeholder="quantity" id="quantity" style="-moz-appearance: textfield">
            </div>
            <div><input class="field" type="submit" value="add"/></div>
        </form>
    </div>
</div>

</body>

</html>