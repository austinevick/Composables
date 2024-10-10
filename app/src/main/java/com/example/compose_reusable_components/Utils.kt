package com.example.compose_reusable_components

import java.text.NumberFormat


fun formattedAmount(value: String): String {
    return "₦${NumberFormat.getNumberInstance().format(value.toLong())}"
}