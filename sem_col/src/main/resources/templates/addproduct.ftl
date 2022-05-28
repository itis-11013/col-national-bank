<#import "common.ftl" as c>
<@c.page>
<h>REGISTER PRODUCT</h>
<div class="__login">
    <div class="login_form">
        <form action="/product/add" method="post">
            <div>
                <label> units : </label>
                <select name="units" style="width:250px">
                    <#list units as a>
                        <option name="units" value="${a.id}">${a.type}</option>
                    </#list>
                </select>
            </div>

            <div>
                <label> Product : </label>
                <select name="product" style="width:250px">
                    <#list product as category>
                        <option name="product" value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </div>
            <div>
                <label>Quantity</label>
                <input type="number" name="count" placeholder="quantity" id="count">
            </div>
            <div>
                <label>Price</label>
                <input type="number" name="price" placeholder="quantity" id="quantity" style="-moz-appearance: textfield">
            </div>
            <div><input class="field" type="submit" value="add"/></div>
        </form>
    </div>
</div>
</@c.page>