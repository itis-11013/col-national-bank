<#import "common.ftl" as c>
<@c.page>
<div class="container py-5">
<div class="row">
    <div class="col">
        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
            <ol class="breadcrumb mb-0">
                <h1 class="text-center">My Account</h1>
            </ol>
        </nav>
    </div>
</div>

    <div style="display: grid; color: aliceblue" >
        <span> Name Organization : ${organization.name}</span>
        <span> Country : ${organization.country.name}</span>
        <span> Currency : ${account.currency}</span>
        <span> Amount : ${account.amount}</span>
    </div>
    <form action="/col/account" method="post" style="color: aliceblue; white-space: pre-line">
    <div>
        <label>Add money</label>
        <input type="number" name="amount" placeholder="amount" id="amount" style="-moz-appearance: textfield">
    </div>
    <div><input class="field" type="submit" value="add money"/></div>
    </form>

</@c.page>