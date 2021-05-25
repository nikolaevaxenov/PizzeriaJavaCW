var main = {
    init : function () {
        var _this = this;
        $('#btn-signup').on('click', function () {
            _this.save();
        });
        $('#btn-login').on('click', function(){
            _this.login();
        });
        $('#btn-logout').on('click', function(){
            _this.logout();
        })
        $('#btn-cardadd').on('click', function(){
            _this.cardadd();
        })
        $('#btn-shipadd').on('click', function(){
            _this.shipadd();
        })
        $(document).on("click","#btn-Addcard", function(){
            _this.Addcard();
        })
        $(document).on("click","#btn-Addship", function(){
            _this.Addship();
        })
        $('#btn-pizzasSave').on("click", function(){
            _this.pizzasSave();
        })
        $('#btn-pizzasUpdate').on("click", function(){
            _this.pizzasUpdate();
        })
        $('#btn-pizzasDelete').on("click", function(){
            _this.pizzasDelete();
        })
        $('#btn-searchpizza').on("click", function(){
            _this.searchpizza();
        })
        $('#btn-addCart').on("click", function(){
            _this.addCart();
        })
        $('#btn-deleteCartlist').on("click", function(){
            _this.deleteCartlist();
        })
        $('#btn-order').on("click",function(){
            _this.addOrder();
        })
        $('#btn-cartlistOrder').on("click", function(){
            _this.addCartlistOrder();
        })
        $('#btn-addCartlistOrder').on("click", function() {
            _this.addCartlistOrders();
        })

    },
    save : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/signup',
            dataType: 'JSON',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Пользователь зарегестрирован.');
            window.location.href = "/users/login"
        }).fail(function (error) {
            if(data.id == ""){
                alert("Пожалуйста, введите информацию.");
            }else{
                alert("Логин уже существует.")
            }
        });
    },
    login : function(){
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/login',
            dataType: 'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            window.location.href = '/';
        }).fail(function(error){
            console.log(error);
            alert('Логин или пароль неверный.');
        })
    },
    logout : function(){
        $.ajax({
            type: 'POST',
            url: '/users/logout',
        }).done(function(){
            window.location.href = '/';
        })
    },
    cardadd : function(){
        var div = document.getElementById("container-card");
        var form = document.createElement("form");
        var inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","id");
        inputid.setAttribute("placeholder","Пожалуйста, введите номер вашей карты");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","datetime");
        inputid.setAttribute("placeholder","Пожалуйста, введите срок годности");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","type");
        inputid.setAttribute("placeholder","Пожалуйста, введите название вашего банка");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);
        div.appendChild(form);

        inputid = document.createElement("input");
        inputid.setAttribute("type","button");
        inputid.setAttribute("id","btn-Addcard");
        inputid.setAttribute("class", "btn btn-secondary col-lg-12");
        inputid.setAttribute("value", "Добавить")
        div.appendChild(inputid);

    },
    shipadd : function(){
        var div = document.getElementById("container-addr");
        var form = document.createElement("form");
        var inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","shipping_num");
        inputid.setAttribute("placeholder","\n" +
            "Пожалуйста, введите ваш почтовый индекс");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","basic_addr");
        inputid.setAttribute("placeholder","\n" +
            "Пожалуйста, введите ваш адрес по умолчанию");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","detail_addr");
        inputid.setAttribute("placeholder","Пожалуйста, введите ваш подробный адрес");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);
        div.appendChild(form);

        inputid = document.createElement("input");
        inputid.setAttribute("type","button");
        inputid.setAttribute("id","btn-Addship");
        inputid.setAttribute("class", "btn btn-secondary col-lg-12");
        inputid.setAttribute("value", "Добавить")
        div.appendChild(inputid);

    },
    Addcard : function(){
        var data = {
            id: $('#id').val(),
            datetime: $('#datetime').val(),
            type: $('#type').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/addCard',
            dataType: 'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            window.location.href = '/users/mypage';
        }).fail(function(error){
            console.log(data);
            alert(error);
        })
    },
    Addship : function(){
            var data = {
                basic_addr: $('#basic_addr').val(),
                shipping_num: $('#shipping_num').val()
            };

            $.ajax({
                type: 'POST',
                url: '/users/addAddr',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                window.location.href = '/users/mypage';
            }).fail(function(error){
                console.log(data);
                alert(error);
            })
        },
    pizzasSave : function(){
            var data = {
                pizzaName: $('#pizza_name').val(),
                pizzaPrice: $('#pizza_price').val(),
                pizzaCount: $('#pizza_count').val()
            };

            $.ajax({
                type: 'POST',
                url: '/pizzas/savepizzas',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                window.location.href='/'
            }).fail(function(error){
                console.log("222222222222222222");
                console.log(error);
            })
        },
    pizzasUpdate : function(){
            var data = {
                pizzaName: $('#pizza_name').val(),
                pizzaPrice: $('#pizza_price').val(),
                pizzaCount: $('#pizza_count').val()
            };

            var uid = new URLSearchParams(location.search).get("uid");

            $.ajax({
                type: 'POST',
                url: '/pizzas/updatepizzas/'+uid,
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                window.location.href='/'
            }).fail(function(error){
                console.log(error);
            })
    },
    pizzasDelete : function() {
            let uid = new URLSearchParams(location.search).get("uid");
            $.ajax({
                type: 'POST',
                url: '/pizzas/deletepizzas/'+ uid,
            }).done(function() {
                window.location.href='/'
            }).fail(function(err) {
                console.log(err);
            })
    },
    searchpizza : function(){
            var searchVal = $('#search').val();

            window.location.href = '/pizzas/pizzaSearch?sn='+searchVal;
    },
    addCart : function(){
            var data = {
                pizzaCount : $('#count').val()
            };

            var uid = new URLSearchParams(location.search).get("uid");

            $.ajax({
                type: 'POST',
                url: '/cart/addCartlist/'+uid,
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                alert("Был добавлен в вашу корзину.")
                window.location.href='/'
            }).fail(function(error){
                console.log(error);
            })
    },
    deleteCartlist : function(){
            let checkValArr = [];
            $("input[name='check_name']:checked").each(function(){
                checkValArr.push($(this).val());
            })
            let data1 = {checkArr: checkValArr}
            $.ajax({
                type: 'POST',
                url: "/cart/deleteCartlist",
                data: data1
            }).done(function(){
                location.href=location.href;
            }).fail(function(err){
                if(checkValArr.length == 0){
                    alert("\n" +
                        "Продукт не выбран.")
                }
            })
    },
    addOrder : function(){
        let pizzaUid = [];
        let count = [];
        pizzaUid.push(new URLSearchParams(location.search).get("pizzaUid"));
        count.push(new URLSearchParams(location.href).get("count"));
        let data = {
            pizzaUid : pizzaUid,
            count : count,
            cardid : $("#cardSelect").val(),
            addrUid : $("#addrSelect").val()
        }
        $.ajax({
            type : 'POST',
            url : '/orders/addOrder',
            data : data
        }).done(function(){
            location.href='/'
        }).fail(function(err){
            console.log(err);
        })
    },
    addCartlistOrder : function(){
        let pizzaUid = [];
        let countValArr = new Array();
        let checkbox = $("input[name='check_name']:checked");
        function paramFor(data) {
            let string = "";
            
            data.pizzaUid.forEach(a => {
                string += "pizzaUid%5B%5D="+a+"&";
            });

            data.count.forEach(a =>{
                string += "count%5B%5D="+a+"&";
            });

            return string;
        }
        checkbox.each(function(i){
            pizzaUid.push($(this).val());

            let tr = checkbox.parent().parent().parent().eq(i);
            // console.log(tr);
            let inputVal = tr.children().eq(2).children().eq(0).children().eq(2).val();

            countValArr.push(inputVal);
        })
        let data = {
            pizzaUid : pizzaUid,
            count : countValArr
        }

        window.location.href='/orders/addCartlistOrder?'+paramFor(data)
    },
    addCartlistOrders: function(){
        let pizzaUid = new URLSearchParams(location.search).getAll("pizzaUid[]");
        let count = new URLSearchParams(location.href).getAll("count[]");
        let data = {
            pizzaUid : pizzaUid,
            count : count,
            cardid : $("#cardSelect").val(),
            addrUid : $("#addrSelect").val()
        }
        $.ajax({
            type : 'POST',
            url : '/orders/cartOrder',
            data : data
        }).done(function(){
            location.href='/'
        }).fail(function(err){
            console.log(err);
        })
    }

};

main.init();