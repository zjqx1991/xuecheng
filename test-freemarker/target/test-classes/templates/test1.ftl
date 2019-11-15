<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>

<body>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>

    <#-- List指令-->
    <#list stuList as stu>
        <tr>
            <td>${stu_index + 1}</td>
            <td
                <#if stu.name == '小明'>
                    style="background:red;"
                </#if>
            >
                ${stu.name}
            </td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
        </tr>
    </#list>

</table>


<hr/>
<br/>

<#-- 遍历Map数据-->
姓名：${stuMap['stu1'].name}
<br/>
年龄：${stuMap.stu2.age}

</body>
</html>