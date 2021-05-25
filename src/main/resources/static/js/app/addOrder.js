let totalPrice;
let backLocation = () => {
    let pizzaUid = new URLSearchParams(location.search).get("pizzaUid");
    window.location.href="/pizzas/pizzadetail?uid="+pizzaUid;
}