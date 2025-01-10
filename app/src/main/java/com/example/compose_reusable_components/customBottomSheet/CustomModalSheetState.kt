package com.example.compose_reusable_components.customBottomSheet

import androidx.compose.animation.core.AnimationSpec


class CustomModalSheetState(
    val skipHiddenState: Boolean,
    val skipIntermediatelyExpanded: Boolean,
    val skipSlightlyExpanded: Boolean,
    val customModalSheetValue: CustomModalSheetValue,
    val containSystemBars: Boolean,
    val allowNestedScroll: Boolean,
    val isModal: Boolean,
    val animateSpec: AnimationSpec<Float>,
    initialValue: CustomModalSheetValue = CustomModalSheetValue.Hidden,
    confirmValueChange: (CustomModalSheetValue) -> Boolean = { true },
) {
    init {
        if (skipIntermediatelyExpanded) {
            require(initialValue != CustomModalSheetValue.IntermediatelyExpanded) {
                "The initial value must not be set to IntermediatelyExpanded if " +
                        "skipIntermediatelyExpanded is set to true."
            }
        }
    }

}
enum class CustomModalSheetValue {
    Hidden,

    FullyExpanded,

    IntermediatelyExpanded,

    SlightlyExpanded
}