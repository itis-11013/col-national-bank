<#import "common.ftl" as c>
<@c.page>
    <h1>My Account</h1>

    <div style="display: grid" >
        <span> Name Organization : ${organization.name}</span>
        <span> Country : ${organization.country.name}</span>
        <span> Currency : ${account.currency}</span>
        <span> Amount : ${account.amount}</span>
    </div>

</@c.page>