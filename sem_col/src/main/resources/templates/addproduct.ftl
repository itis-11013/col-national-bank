<#include 'common.ftl'>

<@page>
<div class="container py-5">
<div class="row">
    <div class="col">
        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
            <ol class="breadcrumb mb-0">
                <h1 class="text-center">REGISTER PRODUCT</h1>
            </ol>
        </nav>
    </div>
</div>
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
            <div>
                <input class="field" type="submit" value="add" />
            </div>
        </form>
    </div>
</div></div>
</@page>