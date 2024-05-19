package com.example.fooduapp.viewModel

import com.example.fooduapp.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    val accountService: AccountService
) : FoodUAppViewModel() {
    fun onSignOutClick() {
        launchCatching {
            accountService.signOut()
        }
    }
}