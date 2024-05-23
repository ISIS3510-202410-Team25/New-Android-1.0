package com.example.fooduapp.ui.home

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val useCase: FoodUseCase
) : ViewModel() {

    val foodResponse by mutableStateOf<DataResponse<List<Food>>?>(null)

    fun getFood() = viewModelScope.launch {
        foodResponse = DataResponse.Loading
        useCase.getFood().collect() {
            foodResponse = it
        }
    }

    fun deleteFood(food: Food) = viewModelScope.launch {
        deleteResponse = DataResponse.Loading
        deleteResponse = useCase.deleteFood(food)
    }
}