package com.yts.cleannote.features.note.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
