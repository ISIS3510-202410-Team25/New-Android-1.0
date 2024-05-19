package com.example.fooduapp.model

data class SignInUiState (
    val email: String = "",
    val password: String = "",
    val invalidEmail: Boolean = false,
    val invalidPassword: Boolean = false
)