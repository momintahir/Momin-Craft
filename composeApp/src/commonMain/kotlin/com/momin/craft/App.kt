package com.momin.craft

import androidx.compose.runtime.*
import com.momin.craft.core.presentation.theme.MominCraftTheme
import com.momin.craft.main.MainViewModel
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun MominCraftApp(mainViewModel: MainViewModel = koinViewModel()) {

    val hasOnBoardingCompleted = mainViewModel.hasOnBoardingCompleted.collectAsState().value


    MominCraftTheme(content = {


    })
}