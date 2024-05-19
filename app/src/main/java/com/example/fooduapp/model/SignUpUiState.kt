package com.example.fooduapp.model

data class SignUpUiState (
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val invalidUsername: Boolean = false,
    val invalidEmail: Boolean = false,
    val invalidPassword: Boolean = false
)