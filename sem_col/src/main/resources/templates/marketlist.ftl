<#import "common.ftl" as c>
<@c.page>
    <div class="container py-5">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                <ol class="breadcrumb mb-0">
                    <h1 class="text-center">Market</h1>
                </ol>
            </nav>
        </div>
    </div>
    <table class="table table-striped table-hover" style="color: black; background-color: aliceblue; border-radius: 5px">
        <thead>
        <tr>
            <th scope="col">Inner Id</th>
            <th scope="col">Code</th>
            <th scope="col">Product</th>
            <th scope="col">Units</th>
            <th scope="col">Count</th>
            <th scope="col">Price</th>
            <th scope="col">Count</th>
            <th scope="col">Pay</th>

        </tr>
        </thead>
        <tbody>
        <#foreach category in product>
        <tr>
            <td>${category.innerID}</td>
            <td>${category.product.code}</td>
            <td>${category.product.name}</td>
            <td>${category.units.type}</td>
            <td>${category.count}</td>
            <td>${category.price}</td>
            <form action="/market" method="post">
                <td> <input type="number" name="count" placeholder="quantity" id="count"></td>
            <td>
                    <button type="submit" value="${category.innerID}" name="innerId" id="innerId" style="color: forestgreen; border: solid">Pay</button>
                </td></form>

        </tr>
        </#foreach>

        </tbody>
    </table>

<#--    <form action="/market" method="post" style="color: aliceblue; inline-size: min-content">-->
<#--    <div>-->
<#--        <label> Product : </label>-->
<#--        <select name="product" style="width:250px">-->
<#--            <#list product as category>-->
<#--                <option name="product" value="${category.product.id}" >${category.product.name}</option>-->
<#--            </#list>-->
<#--        </select>-->
<#--    </div>-->
<#--    <div>-->
<#--        <label> inner id : </label>-->
<#--        <input type="UUID" name="innerID" placeholder="innerID" id="innerID">-->
<#--    </div>-->
<#--    <div>-->
<#--        <label>Quantity:</label>-->
<#--        <input type="number" name="count" placeholder="quantity" id="count">-->
<#--    </div>-->
<#--    <div><input class="field" type="submit" value="buy"/></div>-->
<#--    </form>-->
</@c.page>