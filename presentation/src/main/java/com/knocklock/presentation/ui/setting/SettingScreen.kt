package com.knocklock.presentation.ui.setting

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.knocklock.presentation.R
import com.knocklock.presentation.ui.setting.menu.MenuList

@Composable
fun SettingRoute(
    viewModel: SettingViewModel,
    onMenuSelected: () -> Unit,
    onBackPressedIconSelected: () -> Unit
) {
    val passwordActivateState by viewModel.isActivated.collectAsState()

    SettingScreen(
        onBackPressedIconSelected = onBackPressedIconSelected,
        onMenuSelected = onMenuSelected,
        onSwitchChanged = viewModel::tmpChangeSwitchChecked,
        passwordActivateState = passwordActivateState
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    onBackPressedIconSelected: () -> Unit,
    onMenuSelected: () -> Unit,
    onSwitchChanged: (Boolean) -> Unit,
    passwordActivateState: Boolean
) {
    Scaffold(
        topBar = { SettingHeader(modifier, onBackPressedIconSelected) },
    ) {
        Column(modifier.padding(it)) {
            Spacer(modifier.padding(20.dp))
            SettingBody(
                modifier,
                onMenuSelected,
                onSwitchChanged = onSwitchChanged,
                passwordActivateState
            )
        }
    }
}

@Composable
private fun SettingBody(
    modifier: Modifier = Modifier,
    onMenuSelected: () -> Unit,
    onSwitchChanged: (Boolean) -> Unit,
    checked: Boolean
) {
    Surface(
        modifier.fillMaxSize(),
        color = Color(0xffEFEEF3)
    ) {
        MenuList(modifier, onMenuSelected, onSwitchChanged, checked)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingHeader(
    modifier: Modifier = Modifier,
    onBackPressedIconSelected: () -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .size(24.dp),
                onClick = onBackPressedIconSelected
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        title = {
            Text(
                text = stringResource(R.string.setting)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}


@Preview
@Composable
fun PreviewSettingScreen() {
    SettingScreen(
        onBackPressedIconSelected = { },
        onMenuSelected = {},
        onSwitchChanged = {},
        passwordActivateState = false
    )
}