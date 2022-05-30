<#include 'common.ftl'>

<@page>
<div class="container py-5">
<div class="row">
    <div class="col">
        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
            <ol class="breadcrumb mb-0">
                <h1 class="text-center">Contracts</h1>
            </ol>
        </nav>
    </div>
</div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Time of generate contract</th>
        <th scope="col">Time of pay</th>
        <th scope="col">Date</th>
        <th scope="col">Product</th>
        <th scope="col">Price</th>
        <th scope="col">Count</th>
    </tr>
    </thead>
    <tbody>
    <#foreach category in contracts>
        <tr>
            <td>${category.id}</td>
            <td>${category.contractDate}</td>
            <td>${category.units.paymentDate}</td>
            <td>${category.deliveryDate}</td>
            <td>${category.product.name}</td>
            <td>${category.product.price}</td>
            <td>${category.count}</td>

        </tr>
    </#foreach>

    </tbody>
</table>
</@page>