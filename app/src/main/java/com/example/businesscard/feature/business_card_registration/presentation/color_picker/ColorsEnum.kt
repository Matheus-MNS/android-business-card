package com.example.businesscard.feature.business_card_registration.presentation.color_picker

import com.example.businesscard.R

enum class ColorsEnum(val color: Int) {

    YELLOW(R.color.yellow),
    ORANGE(R.color.orange),
    RED(R.color.red),
    PURPLE(R.color.purple),
    DARK_BLUE(R.color.dark_blue),
    LIGHT_BLUE(R.color.light_blue),
    GREEN(R.color.green),
    LIGHT_GREEN(R.color.light_green),
    BROWN(R.color.brown),
    GRAY(R.color.gray),
    DEFAULT(R.color.maya_blue);

    companion object {

        val DUMBLIST = listOf(
            YELLOW,
            ORANGE,
            RED,
            PURPLE,
            DARK_BLUE,
            LIGHT_BLUE,
            GREEN,
            LIGHT_GREEN,
            BROWN,
            GRAY,
            DEFAULT
        )
    }
}