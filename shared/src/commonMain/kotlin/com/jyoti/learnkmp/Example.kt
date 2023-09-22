package com.jyoti.learnkmp

fun findElementInList(elem: Int, list: List<Int>): Int = list.indexOf(elem)

interface Option {
    val id: String
}

internal data class OptionImpl(override val id: String) : Option

val options: Set<Option> = setOf(OptionImpl("A"), OptionImpl("B"))

class Order {
    fun setOptions(options: Set<Option>) {}
}