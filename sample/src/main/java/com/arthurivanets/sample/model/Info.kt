package com.arthurivanets.sample.model

import androidx.annotation.ColorInt

data class Info(@ColorInt val color : Int,
                val title : String = "") {
}