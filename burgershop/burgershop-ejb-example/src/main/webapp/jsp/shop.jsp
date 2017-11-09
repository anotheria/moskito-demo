<!DOCTYPE html>
<%@ taglib uri="http://www.anotheria.net/ano-tags" prefix="ano"
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Burger Shop</title>
    <link rel="stylesheet" href="css/common.css"/>
    <script src="js/general.js"></script>
    <!--[if IE]>
    <script>
        document.createElement('header');
        document.createElement('nav');
        document.createElement('section');
        document.createElement('article');
        document.createElement('aside');
        document.createElement('footer');
    </script>
    <![endif]-->

    <script type="text/javascript">

        var choices = [];

        $(document).ready(function(){

            $("tr:first").show();

            var prices = [];
            var step_names = ['bread', 'meat', 'options'];
            var step = 1;
            $('#step_index').text(step);
            $('#step_name').text("Select your " + step_names[0]);

            $("table tr td").click(function(){
                var selection_name = $(this).find('p').text();
                $(this).siblings('.active_item').removeClass('active_item')
                $(this).addClass("active_item");
                $(this).siblings().find('.dark').remove();
                $(this).siblings().append("<div class='dark'></div>");

                var tr_index = $(this).closest('tr').index();
                choices[tr_index] = selection_name;



                prices[tr_index] = parseFloat($(this).find(".price span").text());
                var total_price = 0;
                $.each(prices, function(index, price){
                    total_price += price;
                });
                $(".total_cost p span").text(total_price.toFixed(2) + ' EUR');

                var $nextLine = $(this).closest('tr').next();
                if($nextLine.length > 0){
                    $nextLine.show();
                    if(!$(this).closest('tr').hasClass('step_done')){
                        $('#step_index').text(++step);
                        $('#step_name').text("Select your " + step_names[tr_index+1]);
                        $(this).closest('tr').addClass('step_done');
                    }
                }
                else{
                    $(".lightbox").show();
                    $(".oder_now p").text('Order now ' + total_price.toFixed(2) + ' EUR');
                    $(this).closest('table').addClass('selection_complete');

                }
            });


            //close lightbox
            $('.black_bg, .close_box').click(function() {
                $('.lightbox').hide();
                return false;
            });

            //close lightbox
            $('.black_bg, .order_click').click(function() {
                $('.lightbox').hide();
                document.location.href = 'order?choice1='+choices[0]+'&choice2='+choices[1]+'&choice3='+choices[2];
            });


        });

    </script>
</head>

<body class="inner_bg">

<header class="main">
    <div class="logo_line"></div>
    <img src="img/logo.png"/>
    <h1 class="line_name">
        <div>
            <span id="step_index">1</span>
            <span id="step_name"></span>
        </div>
    </h1>
</header>
<table cellpadding="0" cellspacing="0">
    <tbody>
    <tr>
        <ano:iterate name="BREAD" id="bread" type="org.moskito.demo.burgershop.burgershopejb.ui.ShopItemBean">
            <td class="<ano:write name="bread" property="item"/>">

                <div class="price">
                    <span><ano:write name="bread" property="price"/></span>
                </div>

                <div class="item_name">
                    <p class=""><ano:write name="bread" property="item"/></p>
                    <div></div>
                </div>

            </td>
        </ano:iterate>
    </tr>
    <tr>
        <ano:iterate name="MEAT" id="meat" type="org.moskito.demo.burgershop.burgershopejb.ui.ShopItemBean">
            <td class="<ano:write name="meat" property="item"/>">

                <div class="price">
                    <span><ano:write name="meat" property="price"/></span>
                </div>

                <div class="item_name">
                    <p class=""><ano:write name="meat" property="item"/></p>
                    <div></div>
                </div>

            </td>
        </ano:iterate>
    </tr>
    <tr>
        <ano:iterate name="EXTRAS" id="extra" type="org.moskito.demo.burgershop.burgershopejb.ui.ShopItemBean">
            <td class="<ano:write name="extra" property="item"/>">

                <div class="price">
                    <span><ano:write name="extra" property="price"/></span>
                </div>

                <div class="item_name">
                    <p class=""><ano:write name="extra" property="item"/></p>
                    <div></div>
                </div>

            </td>
        </ano:iterate>
    </tr>
    </tbody>
</table>

<div class="total_cost">
    <div></div>
    <p> Total cost: <span>0</span></p>
</div>


<div class="lightbox">
    <div class="black_bg"></div>
    <div class="box_l">
        <div class="oder_now">
            <a class="close_box">x</a>
            <p class="order_click"></p>
        </div>

    </div>
</div>



</body>
</html>