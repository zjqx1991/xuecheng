<!DOCTYPE html>
<html lang="en" xmlns:http="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div>
    <#if model??>
        <#list model as item>
            <div>
                <span>${item.name}</span>
                <img src=${item.value} />
            </div>
            <br/>
        </#list>
    </#if>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--<script type="text/javascript" src="http://www.xuecheng.com/plugins/jquery/dist/jquery.js"></script>-->
<!--<script type="text/javascript" src="http://www.xuecheng.com/plugins/bootstrap/dist/js/bootstrap.js"></script>-->
<script type="text/javascript">
    var tg = $('.banner-item .item');
    var num = 0;
    for (i = 0; i < tg.length; i++) {
        $('.indicators').append('<span></span>');
        $('.indicators').find('span').eq(num).addClass('active');
    }

    function roll() {
        tg.eq(num).animate({
            'opacity': '1',
            'z-index': num
        }, 1000).siblings().animate({
            'opacity': '0',
            'z-index': 0
        }, 1000);
        $('.indicators').find('span').eq(num).addClass('active').siblings().removeClass('active');
        if (num >= tg.length - 1) {
            num = 0;
        } else {
            num++;
        }
    }

    $('.indicators').find('span').click(function () {
        num = $(this).index();
        roll();
    });
    var timer = setInterval(roll, 3000);
    $('.banner-item').mouseover(function () {
        clearInterval(timer)
    });
    $('.banner-item').mouseout(function () {
        timer = setInterval(roll, 3000)
    });
</script>
</body>
</html>