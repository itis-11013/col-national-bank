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

<table class="table table-striped table-hover" style="color: black; background-color: aliceblue; border-radius: 5px">
    <thead>
    <tr>
        <th scope="col">Generated</th>
        <th scope="col">Product</th>
        <th scope="col">Price</th>
        <th scope="col">Count</th>
        <th scope="col">Payment Date</th>
        <th scope="col">Payment</th>

    </tr>
    </thead>
    <tbody>
    <#foreach category in contracts>
        <tr>
            <td>${category.contractDate}</td>
            <td>${category.getProduct().getCatalog().name}</td>
            <td>${category.getProduct().price}</td>
            <td>${category.count}</td>

            <#if !category.deleted>
                <td>-------</td>
                <td>
                    <form action="/col/payments" method="post">
                        <button type="submit" value="${category.innerId}" name="innerId" id="innerId" style="color: forestgreen; border: solid">Pay</button>
                    </form>
                </td>
            <#else>
                <td>${category.paymentDate}</td>
                <td>Is Paid</td>
            </#if>



        </tr>
    </#foreach>

    </tbody>
</table>
</@page>