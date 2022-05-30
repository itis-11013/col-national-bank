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
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Code</th>
            <th scope="col">Product</th>
            <th scope="col">Units</th>
            <th scope="col">Count</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <#foreach category in product>
        <tr>
            <td>${category.product.code}</td>
            <td>${category.product.name}</td>
            <td>${category.units.type}</td>
            <td>${category.count}</td>
            <td>${category.price}</td>

        </tr>
        </#foreach>

        </tbody>
    </table>
    <div class="container py-5">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                <ol class="breadcrumb mb-0">
                    <h1 class="text-center">Buy Product</h1>
                </ol>
            </nav>
        </div>
    </div>

    <form action="/market" method="post">
    <div>
        <label> Product : </label>
        <select name="product" style="width:250px">
            <#list product as category>
                <option name="product" value="${category.product.id}" >${category.product.name}</option>
            </#list>
        </select>
    </div>
    <div>
        <label>Quantity</label>
        <input type="number" name="count" placeholder="quantity" id="count">
    </div>
    <div><input class="field" type="submit" value="buy"/></div>
    </form>
</@c.page>