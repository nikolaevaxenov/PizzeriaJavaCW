class Pizza {
  type = 0;
  size = 0;
  quantity = 0;
  cost = 0;
  orig_cost = 0;
  choosed = false;

  constructor(type, size, quantity) {
    switch (size) {
      case 26:
      case 30:
      case 40:
        this.size = size;
        break;
      default:
        return;
    }

    switch (type) {
      case 1:
        switch (this.size) {
          case 26:
            this.cost = 399;
            break;
          case 30:
            this.cost = 549;
            break;
          case 40:
            this.cost = 769;
            break;
        }
        this.type = type;
        break;
      case 2:
        switch (this.size) {
          case 26:
            this.cost = 499;
            break;
          case 30:
            this.cost = 649;
            break;
          case 40:
            this.cost = 869;
            break;
        }
        this.type = type;
        break;
      case 3:
        switch (this.size) {
          case 26:
            this.cost = 519;
            break;
          case 30:
            this.cost = 759;
            break;
          case 40:
            this.cost = 999;
            break;
        }
        this.type = type;
        break;
      case 4:
        switch (this.size) {
          case 26:
            this.cost = 489;
            break;
          case 30:
            this.cost = 649;
            break;
          case 40:
            this.cost = 869;
            break;
        }
        this.type = type;
        break;
      case 5:
        switch (this.size) {
          case 26:
            this.cost = 529;
            break;
          case 30:
            this.cost = 699;
            break;
          case 40:
            this.cost = 989;
            break;
        }
        this.type = type;
        break;
      case 6:
        switch (this.size) {
          case 26:
            this.cost = 349;
            break;
          case 30:
            this.cost = 439;
            break;
          case 40:
            this.cost = 579;
            break;
        }
        this.type = type;
        break;
      case 7:
        switch (this.size) {
          case 26:
            this.cost = 479;
            break;
          case 30:
            this.cost = 659;
            break;
          case 40:
            this.cost = 899;
            break;
        }
        this.type = type;
        break;
      case 8:
        switch (this.size) {
          case 26:
            this.cost = 499;
            break;
          case 30:
            this.cost = 569;
            break;
          case 40:
            this.cost = 789;
            break;
        }
        this.type = type;
        break;
      default:
        return;
    }
    this.quantity = quantity;
    this.orig_cost = this.cost;
  }

  getType() {
    return this.type;
  }

  getSize() {
    return this.size;
  }

  getQuantity() {
    return this.quantity;
  }

  getCost() {
    return this.cost;
  }

  incrementPizza() {
    this.quantity += 1;

    this.cost = this.orig_cost * this.quantity;
  }

  decrementPizza() {
    if (this.quantity > 1) {
      this.quantity -= 1;
    }
    this.cost = this.orig_cost * this.quantity;
  }

  setChoosed() {
    this.choosed = true;
  }

  unsetChoosed() {
    this.choosed = false;
  }

  getChoosedState() {
    return this.choosed;
  }
}

class Order {
  constructor() {
    this.pizzaArr = [
      new Pizza(1, 26, 1),
      new Pizza(1, 30, 1),
      new Pizza(1, 40, 1),
      new Pizza(2, 26, 1),
      new Pizza(2, 30, 1),
      new Pizza(2, 40, 1),
      new Pizza(3, 26, 1),
      new Pizza(3, 30, 1),
      new Pizza(3, 40, 1),
      new Pizza(4, 26, 1),
      new Pizza(4, 30, 1),
      new Pizza(4, 40, 1),
      new Pizza(5, 26, 1),
      new Pizza(5, 30, 1),
      new Pizza(5, 40, 1),
      new Pizza(6, 26, 1),
      new Pizza(6, 30, 1),
      new Pizza(6, 40, 1),
      new Pizza(7, 26, 1),
      new Pizza(7, 30, 1),
      new Pizza(7, 40, 1),
      new Pizza(8, 26, 1),
      new Pizza(8, 30, 1),
      new Pizza(8, 40, 1),
    ];
  }

  addPizza(type, size) {
    for (var i = 0; i < this.pizzaArr.length; i++) {
      if (
        this.pizzaArr[i].getType() == type &&
        this.pizzaArr[i].getSize() == size
      ) {
        this.pizzaArr[i].setChoosed();
        return this.pizzaArr[i].incrementPizza();
      }
    }
  }

  delPizza(type, size) {
    for (var i = 0; i < this.pizzaArr.length; i++) {
      if (
        this.pizzaArr[i].getType() == type &&
        this.pizzaArr[i].getSize() == size
      ) {
        return this.pizzaArr[i].decrementPizza();
      }
    }
  }

  findPizza(type, size) {
    for (var i = 0; i < this.pizzaArr.length; i++) {
      if (
        this.pizzaArr[i].getType() == type &&
        this.pizzaArr[i].getSize() == size
      ) {
        return this.pizzaArr[i];
      }
    }
  }

  getTotalQuantity() {
    var q = 0;

    for (var i = 0; i < this.pizzaArr.length; i++) {
      q += this.pizzaArr[i].getQuantity();
    }

    return q;
  }

  getTotalCost() {
    var sum = 0;

    for (var i = 0; i < this.pizzaArr.length; i++) {
      if (this.pizzaArr[i].getChoosedState() == true) {
        sum += this.pizzaArr[i].getCost();
      }
    }

    return sum;
  }
}

var order = new Order();

function inc(qid) {
  var type = qid[1];
  var size = 0;

  if (document.getElementById(type + "t" + "26").checked == true) {
    size = 26;
  } else if (document.getElementById(type + "t" + "30").checked == true) {
    size = 30;
  } else if (document.getElementById(type + "t" + "40").checked == true) {
    size = 40;
  } else {
    return;
  }

  document.getElementById(qid).stepUp();

  order.addPizza(type, size);
  document.getElementById("p" + type).innerHTML = order
    .findPizza(type, size)
    .getCost();
}

function decr(qid) {
  var type = qid[1];
  var size = 0;

  if (document.getElementById(type + "t" + "26").checked == true) {
    size = 26;
  } else if (document.getElementById(type + "t" + "30").checked == true) {
    size = 30;
  } else if (document.getElementById(type + "t" + "40").checked == true) {
    size = 40;
  } else {
    return;
  }

  document.getElementById(qid).stepDown();

  order.delPizza(type, size);
  document.getElementById("p" + type).innerHTML = order
    .findPizza(type, size)
    .getCost();
}

function getCurrent(type, size) {
  document.getElementById("q" + type).value = 1;
  document.getElementById("p" + type).innerHTML = order
    .findPizza(type, size)
    .getCost();
}

function addToCart(type) {
  if (document.getElementById("cart").innerHTML == "") {
    document.getElementById("cart").innerHTML =
      '<h1 align="center">Корзина</h1><table class="table table-hover"><thead><tr><th scope="col">Название</th><th scope="col">Размер</th><th scope="col">Количество</th><th scope="col">Цена</th></tr></thead><tbody id="orderTable"></tbody></table><div class="confirmationBlock"><h2 style="display: inline" id="summary">Итог: 0 ₽</h2><button type="button" class="btn btn-success" style="display: inline; float: right" onclick="submitOrder()">Продолжить оформление</button></div>';
  }

  var size = 0;

  if (document.getElementById(type + "t" + "26").checked == true) {
    size = 26;
  } else if (document.getElementById(type + "t" + "30").checked == true) {
    size = 30;
  } else if (document.getElementById(type + "t" + "40").checked == true) {
    size = 40;
  } else {
    return;
  }

  order.findPizza(type, size).setChoosed();

  document.getElementById("orderTable").innerHTML += `<tr><td>${
    document.getElementById(`name${type}`).textContent
  }</td><td>${size} см</td><td>${order
    .findPizza(type, size)
    .getQuantity()}</td><td>${order.findPizza(type, size).getCost()}</td></tr>`;

  document.getElementById(
    "summary"
  ).innerHTML = `Итог: ${order.getTotalCost()} ₽`;
}

function submitOrder() {
  if (document.getElementById("cart").innerHTML !== "") {
    document.getElementById("cart").innerHTML =
      '<form class="row g-3 needs-validation" novalidate> <div class="col-md-4"> <label for="form1" class="form-label">Имя</label> <input type="text" class="form-control" id="form1" value="Иван" required /> <div class="invalid-feedback">Пожалуйста, введите корректное имя</div> </div> <div class="col-md-4"> <label for="form2" class="form-label">Фамилия</label> <input type="text" class="form-control" id="form2" value="Иванов" required /> <div class="invalid-feedback"> Пожалуйста, введите корректную фамилию </div> </div> <div class="col-md-4"> <label for="form3" class="form-label">Email-адрес</label> <input type="text" class="form-control" id="form3" value="example@mail.ru" required /> <div class="invalid-feedback"> Пожалуйста, введите корректный email-адрес </div> </div> <div class="col-md-4"> <label for="form4" class="form-label">Номер телефона</label> <input type="text" class="form-control" id="form4" value="+79997770011" required /> <div class="invalid-feedback"> Пожалуйста, введите корректный номер телефона </div> </div> <div class="col-md-4"> <label for="form5" class="form-label">Улица</label> <input type="text" class="form-control" id="form5" value="Селигерская" required /> <div class="invalid-feedback"> Пожалуйста, введите корректное название улицы </div> </div> <div class="col-md-4"> <label for="form6" class="form-label">Дом</label> <input type="text" class="form-control" id="form6" value="1" required /> <div class="invalid-feedback"> Пожалуйста, введите корректный номер дома </div> </div> <div class="col-md-4"> <label for="form7" class="form-label">Подъезд</label> <input type="text" class="form-control" id="form7" value="1" required /> <div class="invalid-feedback"> Пожалуйста, введите корректный номер подъезда </div> </div> <div class="col-md-4"> <label for="form8" class="form-label">Этаж</label> <input type="text" class="form-control" id="form8" value="10" required /> <div class="invalid-feedback"> Пожалуйста, введите корректный этаж </div> </div> <div class="col-md-4"> <label for="form9" class="form-label">Код домофона</label> <input type="text" class="form-control" id="form9" required /> <div class="invalid-feedback"> Пожалуйста, введите корректный код домофона </div> </div> <div class="col-mb-3"> <label for="form10" class="form-label">Комментарий к заказу</label> <input type="text" class="form-control" id="form10" /> </div> <div class="col-12"> <button class="btn btn-primary" type="submit" id="ordernow"> Заказать </button> </div> </form>';
  }
}
