<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>market</title>
</head>
<body>
<h1>market</h1>
<div>
    <label> Product : </label>
    <select name="product" style="width:250px">
        <#list product as category>
            <option name="product" >${category.product.name}</option>
        </#list>
    </select>
</div>

</body>

</html>