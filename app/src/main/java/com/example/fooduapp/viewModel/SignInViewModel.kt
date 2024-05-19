package com.example.fooduapp.viewModel

import com.example.fooduapp.HOME_NAV
import com.example.fooduapp.HOME_SCREEN
import com.example.fooduapp.SIGN_IN_SCREEN
import com.example.fooduapp.SIGN_UP_SCREEN
import com.example.fooduapp.model.SignInUiState
import com.example.fooduapp.model.service.AccountService
import com.example.fooduapp.util.isValidEmail
import com.example.fooduapp.util.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val accountService: AccountService
) : FoodUAppViewModel() {

    // State of the Sign In fields
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    fun updateEmail(enterEmail: String) {
        _uiState.update {currentState ->
            currentState.copy(
                email = enterEmail
            )
        }
    }

    fun updatePassword(enterPassword: String) {
        _uiState.update {currentState ->
            currentState.copy(
                password = enterPassword
            )
        }
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            if(!_uiState.value.email.isValidEmail()) {
                _uiState.update {currentState ->
                    currentState.copy(
                        invalidEmail = true
                    )
                }
            } else {
                _uiState.update {currentState ->
                    currentState.copy(
                        invalidEmail = false
                    )
                }
            }

            if(!_uiState.value.password.isValidPassword()) {
                _uiState.update {currentState ->
                    currentState.copy(
                        invalidPassword = true
                    )
                }
            } else {
                _uiState.update {currentState ->
                    currentState.copy(
                        invalidPassword = false
                    )
                }
            }

            if (_uiState.value.invalidEmail || _uiState.value.invalidPassword)
                throw IllegalArgumentException("Fields are not correct")

            accountService.signIn(_uiState.value.email, _uiState.value.password)
            openAndPopUp(HOME_NAV, SIGN_IN_SCREEN)
        }
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(SIGN_UP_SCREEN, SIGN_IN_SCREEN)
    }
}