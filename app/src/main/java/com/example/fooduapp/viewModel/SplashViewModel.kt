package com.example.fooduapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.fooduapp.HOME_NAV
import com.example.fooduapp.HOME_SCREEN
import com.example.fooduapp.SIGN_IN_SCREEN
import com.example.fooduapp.SPLASH_SCREEN
import com.example.fooduapp.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountService: AccountService
) : ViewModel() {
    fun onAppStart(openAndPopUp: (String, String) -> Unit) {
        if (accountService.hasUser()) openAndPopUp(HOME_NAV, SPLASH_SCREEN)
        else openAndPopUp(SIGN_IN_SCREEN, SPLASH_SCREEN)
    }
}