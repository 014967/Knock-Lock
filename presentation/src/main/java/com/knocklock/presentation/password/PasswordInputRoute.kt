package com.knocklock.presentation.password

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PasswordInputRoute(
    viewModel: PasswordInputViewModel = hiltViewModel()
) {
    PasswordInputScreen(
        modifier = Modifier.fillMaxSize(),
        inputtedPassword = viewModel.inputPassword.value,
        onClickTextButton = viewModel::onClickTextButton,
        onClickAction = viewModel::onClickKeyboardAction,
    )
}