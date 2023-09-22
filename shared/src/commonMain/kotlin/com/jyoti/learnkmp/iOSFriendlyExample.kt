package com.jyoti.learnkmp

import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
fun find(@ObjCName("_") elem: Int, @ObjCName("_") list: List<Int>): Int = list.indexOf(elem)

abstract class AbsOption {
    abstract val id: String
}

internal data class FriendlyOptionImpl(override val id: String): AbsOption()
val option2Set: Set<AbsOption> = setOf<AbsOption>(FriendlyOptionImpl("A"), FriendlyOptionImpl("B"))
val option2Map = mapOf<AbsOption, Int>(FriendlyOptionImpl("a") to 1, FriendlyOptionImpl("b") to 2)

class FriendlyOrder{
    fun setFriendlyOptions(optionSet: Set<AbsOption>) {}
    fun setFriendlyOptions(optionMap: Map<AbsOption, Int>) {}
}