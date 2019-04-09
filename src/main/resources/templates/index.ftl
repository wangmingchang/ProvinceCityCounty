<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/img/pcc.ico" type="image/x-icon">
    <title>省市区县镇村</title>
    <!--<link rel="stylesheet" type="text/css" th:href="@{/js/tooltip/css/default.css}">-->
    <!--<link rel="stylesheet" th:href="@{/js/tooltip/css/documentation.css}">-->
    <!--<link rel="stylesheet" th:href="@{/js/tooltip/font-awesome-4.3.0/css/font-awesome.min.css}">-->
    <script src="/js/jQuery-v2_1_4.js" ></script>
    <!--<script th:src="@{/js/tooltip/js/jquery.toolbar.js}" ></script>-->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style type="text/css">
        #data_ul{padding-left: 0px;color:#fff;}
        #data_ul li{cursor: pointer; padding: 5px 10px; float: left;list-style-type: none; background: #a8b5e4;margin: 10px 0 0 10px; border-radius: 3px;}
        .left_div{float: left; margin: 5px 5px;}
    </style>
</head>
<body>
<h2>拉取国家省市区县镇村的行政代码和地区名称</h2>
<div style="height: 30px;display: inline-table;">
    <div>
        <div class="left_div"><div style="height: 25px;width: 80px; background:#2bde74e0; float: left; margin-right: 5px;"></div><label>保存成功</label></div>
        <div class="left_div"><div style="height: 25px;width: 80px; background:#a8a8ab; float: left; margin-right: 5px;"></div><label>保存中</label></div>
        <div class="left_div"><div style="height: 25px;width: 80px; background:#fd4a4a; float: left; margin-right: 5px;"></div><label>保存失败</label></div>
    </div>
</div>
<ul id="data_ul">
    <li data-toggle="tooltip" title=""  id="11" data-load="false">北京市</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="12" data-load="false">天津市</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="13" data-load="false">河北省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="14" data-load="false">山西省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="15" data-load="false">内蒙古自治区</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="21" data-load="false">辽宁省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="22" data-load="false">吉林省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="23" data-load="false">黑龙江省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="31" data-load="false">上海市</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="32" data-load="false">江苏省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="33" data-load="false">浙江省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="34" data-load="false">安徽省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="35" data-load="false">福建省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="36" data-load="false">江西省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="37" data-load="false">山东省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="41" data-load="false">河南省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="42" data-load="false">湖北省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="43" data-load="false">湖南省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="44" data-load="false">广东省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="45" data-load="false">广西壮族自治区</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="46" data-load="false">海南省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="50" data-load="false">重庆市</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="51" data-load="false">四川省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="52" data-load="false">贵州省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="53" data-load="false">云南省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="54" data-load="false">西藏自治区</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="61" data-load="false">陕西省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="62" data-load="false">甘肃省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="63" data-load="false">青海省</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="64" data-load="false">宁夏回族自治区</li>
    <li data-toggle="tooltip" title="更新时间：12452" id="65" data-load="false">新疆维吾尔自治区</li>

</ul>

<script type="text/javascript">
    $(function () {
        $("#data_ul li").on("click", function () {
            var id = this.id;
            var name = $(this).text();
            var load_flag = $(this).data("load");
            console.log(id,name, load_flag);
            if(!load_flag){
                saveData(id, name);
            }else {
                console.log("保存中...")
            }
        });

        $('[data-toggle="tooltip"]').tooltip();
    });

    function saveData(code,name) {
        $("#" + code).css("background","#a8a8ab");
        $("#" + code).css("cursor", "text");
        $("#" + code).data("load", true);
        $.post("/area/saveData",{"code":code,"name":name},function(result){
            console.log(result);
            if(result){
                //成功
                $("#" + code).css("background", "#2bde74e0")
            }else {
                $("#" + code).css("background", "#fd4a4a")
            }
            $("#" + code).data("load", false);
            $("#" + code).css("cursor", "pointer");
        });
    }


</script>
</body>
</html>