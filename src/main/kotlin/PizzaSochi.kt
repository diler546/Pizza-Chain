class PizzaSochi(
    neapolitanPizzaPrice: Double,romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice,  romanPizzaPrice,
    sicilianPizzaPrice,  tyroleanPizzaPrice), Drink, CheckPhoto, Sauce
{
    val coffeePrice = 168.9
    var coffeeCount = 0

    val receiptDiscount = 40.7
    var receiptCount = 0

    val ketchupSaucePrice = 45.1
    val hawaiiSaucePrice = 67.7

    var ketchupSauceCount = 0
    var hawaiiSauceCount = 0

    var neapPlusCoffee = 0
    var romanPlusCoffee = 0
    var sicilianPlusCoffee = 0
    var tyroleanPlusCoffee = 0

    private var currSelectedPizza = "undefined" // Отдельное значение до обновления статистики

    override fun showStats()
    {
        println("-------------------------------------------")
        println("СТАТИСТИКА ПО СОЧИ")
        println()

        super.showStats()
        println("Продано чашек кофе: $coffeeCount \n" +
                "Всего продано кофе на сумму ${coffeePrice*coffeeCount} рублей")

        println("Кофе берут ${calcPercent(clientCount,coffeeCount)}% клиентов")
        println("${calcPercent(coffeeCount,neapPlusCoffee)}% кофе куплено вместе с неаполитанской пиццей, а именно ${neapPlusCoffee} штук")
        println("${calcPercent(coffeeCount,romanPlusCoffee)}% кофе куплено вместе с римской пиццей, а именно ${romanPlusCoffee} штук")
        println("${calcPercent(coffeeCount,sicilianPlusCoffee)}% кофе куплено вместе с сицилийской пиццей, а именно ${sicilianPlusCoffee} штук")
        println("${calcPercent(coffeeCount,tyroleanPlusCoffee)}% кофе куплено вместе с тирольской пиццей, а именно ${tyroleanPlusCoffee} штук")

        println("Показано чеков: $receiptCount \nВсего выдано скидок" +
                " на сумму ${receiptCount*receiptDiscount} рублей")

        println("Чек показывают ${calcPercent(clientCount,receiptCount)}% клиентов")

        println("Купили баночек кетчупа: $ketchupSauceCount; на сумму ${ketchupSauceCount*ketchupSaucePrice} рублей")
        println("Купили баночек Чесночного: $hawaiiSauceCount; на сумму ${hawaiiSaucePrice*hawaiiSauceCount} рублей")

        var sauceIncome = ketchupSaucePrice*ketchupSauceCount+hawaiiSauceCount*hawaiiSaucePrice
        println("На соусах заработали $sauceIncome рублей")

        println("Итого на счету пиццерии ${moneyPizz+coffeePrice*coffeeCount+sauceIncome-receiptCount*receiptDiscount} рублей")
        println("-------------------------------------------")
    }

    override fun drinkSale() {
        println("Не хотите ли выпить кофе?")
        println("1. Да\n2. Нет")
        if (readln()=="1")
        {
            coffeeCount++
            println("С вас ещё $coffeePrice рублей")
            when (currSelectedPizza)
            {
                "neapolitanPizza" -> neapPlusCoffee++
                "romanPizza" -> romanPlusCoffee++
                "sicilianPizza" -> sicilianPlusCoffee++
                "tyroleanPizza" -> tyroleanPlusCoffee++
            }
        }
    }

    override fun showReceiptPhoto() {
        println("У Вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln()=="1")
        {
            println("Вы получили скидку $receiptDiscount рублей")
            receiptCount++
        }
    }

    override fun SauceSale()
    {
        println("Не хотите ли взять соус к пицце?")
        println("1. Да\n2. Нет")
        if (readln()=="1")
        {
            println("1. Кетчуп \n2. Чесночный")
            var temp = readln()
            if (temp=="1")
            {
                ketchupSauceCount++
                println("Кетчуп будет стоить $ketchupSaucePrice рублей")
                return
            }
            else if (temp=="2")
            {
                hawaiiSauceCount++
                println("Чесночный будет стоить $hawaiiSaucePrice рублей")
                return
            }
            else println("Вы не взяли соус")
        }
        else println("Вы не взяли соус")
    }

    override fun neapolitanPizzaSell()
    {
        neapolitanPizzaCount++
        currSelectedPizza="neapolitanPizza"
        println("Спасибо за покупку неаполитанской пиццы в Сочи!")
    }
    override fun romanPizzaSell()
    {
        romanPizzaCount++
        currSelectedPizza="romanPizza"
        println("Спасибо за покупку римской пиццы в Сочи!")
    }
    override fun sicilianPizzaSell()
    {
        sicilianPizzaCount++
        currSelectedPizza="sicilianPizza"
        println("Спасибо за покупку сицилийской пиццы в Сочи!")
    }
    override fun tyroleanPizzaSell()
    {
        tyroleanPizzaCount++
        currSelectedPizza="tyroleanPizza"
        println("Спасибо за покупку тирольской пиццы в Сочи!")
    }
}