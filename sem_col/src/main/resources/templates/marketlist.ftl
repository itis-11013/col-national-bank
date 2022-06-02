<#import "common.ftl" as c>
<@c.page>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <script type="text/javascript">
        function select_merch(id, code) {
            tbody = document.getElementById('tbl_body');
            while(tbody.rows.length > 0) {
                tbody.deleteRow(0);
            }
            document.getElementById("merch_id").value = id;
            document.getElementById("merch_code").value = code;

        }
        async function search_merch() {
            //clear table
            tbody = document.getElementById('tbl_body');
            while(tbody.rows.length > 0) {
                tbody.deleteRow(0);
            }

            name = document.getElementById('name').value;
            console.log(decodeURI('/col/merch?name='+name))
            let response = await fetch(decodeURI("/col/merch?name="+name));
            let result = await response.json();
            for (var j = 0; j < result.length; j++) {
                var row = tbody.insertRow (-1);
                var cell1 = row.insertCell(-1);
                cell1.innerHTML = result[j].code;
                var cell2 = row.insertCell(-1);
                cell2.innerHTML = result[j].name;
                var cell3 = row.insertCell(-1);
                cell3.innerHTML = "<button onclick='select_merch("+result[j].id +","+ result[j].code+")'>Выбрать</button>"
            }
        }
    </script>

<#--    <table class="table table-striped table-hover" style="color: black; background-color: aliceblue; border-radius: 5px">-->
<#--        <thead>-->
<#--        <tr>-->
<#--            <th scope="col">Inner Id</th>-->
<#--            <th scope="col">Code</th>-->
<#--            <th scope="col">Product</th>-->
<#--            <th scope="col">Units</th>-->
<#--            <th scope="col">Count</th>-->
<#--            <th scope="col">Price</th>-->
<#--            <th scope="col">Count</th>-->
<#--            <th scope="col">Pay</th>-->

<#--        </tr>-->
<#--        </thead>-->
<#--        <tbody>-->
<#--        <#foreach category in product>-->
<#--        <tr>-->
<#--            <td>${category.innerID}</td>-->
<#--            <td>${category.product.code}</td>-->
<#--            <td>${category.product.name}</td>-->
<#--            <td>${category.units.type}</td>-->
<#--            <td>${category.count}</td>-->
<#--            <td>${category.price}</td>-->

<#--            <form action="/col/market" method="post">-->
<#--                <td> <input type="number" name="count" placeholder="quantity" id="count"></td>-->
<#--            <td>-->

<#--                    <button type="submit" value="${category.innerID}" name="innerId" id="innerId" style="color: forestgreen; border: solid">Pay</button>-->
<#--                </td></form>-->

<#--        </tr>-->
<#--        </#foreach>-->

<#--        </tbody>-->
<#--    </table>-->
    <h1>Новый товар</h1>
    <div>
        <span>Наименование</span>
        <input id="name" type="text"/>
        <button onclick="search_merch()">Найти</button>
    </div>
    <div>
        <table>
            <thead><th>Код</th><th>Наименование</th><th></th></thead>
            <tbody id="tbl_body"></tbody>
        </table>
    </div>

    <div><span>Выбранный товар:</span>

        <form action="/col/pp" method="post">
            <input type="hidden" id="merch_id" name="merch_id"></input>
            <label for="merch_code" > code :</label>
            <input type="text" id="merch_code" name="merch_code"></input>
            <label for="count">count :</label>
            <input type="number" id="count" name = "count"></input>


<#--            <s id="merch_code"></s>&nbsp;-->
<#--            <span id="merch_name"></span>-->

                    <button type="submit" style="color: forestgreen; border: solid">Pay</button>
        </form>
    </div>

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