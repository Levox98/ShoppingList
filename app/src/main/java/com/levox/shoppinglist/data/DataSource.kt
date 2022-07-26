package com.levox.shoppinglist.data


import com.levox.shoppinglist.model.Item

object DataSource {
    val itemList = listOf(
        Item("name_1"),
        Item("name_2"),
        Item("name_3")
    )

    val meatList = listOf(
        Item("Индейка"),
        Item("Курица"),
        Item("Говядина"),
        Item("Колбаса копчёная"),
        Item("Колбаса варёная")
    )

    val fruitAndVeggiesList = listOf(
        Item("Огурцы"),
        Item("Помидоры"),
        Item("Картофель"),
        Item("Морковь"),
        Item("Лук"),
        Item("Салат"),
        Item("Апельсины"),
        Item("Бананы"),
        Item("Груши"),
        Item("Яблоки")
    )

    val sweetsList = listOf(
        Item("Печенье"),
        Item("Шоколад"),
        Item("Конфеты"),
        Item("Вафли"),
    )

    val coffeeTeaList = listOf(
        Item("Чай"),
        Item("Кофе"),
        Item("Какао")
    )

    val groceriesList = listOf(
        Item("Макароны"),
        Item("Рис"),
        Item("Гречка"),
        Item("Кукуруза"),
        Item("Горошек"),
        Item("Консервы"),
        Item("Соусы")
    )

    val frozenList = listOf(
        Item("Пельмени"),
        Item("Мороженое"),
        Item("\"Горячая штучка\"")
    )

    val dairyList = listOf(
        Item("Молоко"),
        Item("Кефир"),
        Item("Йогурт"),
        Item("Яйца"),
        Item("Сыр")
    )

    val seaProductsList = listOf(
        Item("Рыба"),
        Item("Солёная рыба"),
        Item("Крабовые палочки"),
        Item("Креветки"),
        Item("Морская капуста")
    )

    val breadList = listOf(
        Item("Белый хлеб"),
        Item("Чёрный хлеб"),
        Item("Лаваш"),
        Item("Хлебцы")
    )

    val drinksList = listOf(
        Item("Сок"),
        Item("Газировка"),
        Item("Вода")
    )

    val chemistryList = listOf(
        Item("Зубная паста"),
        Item("Шампунь"),
        Item("Мыло")
    )
}