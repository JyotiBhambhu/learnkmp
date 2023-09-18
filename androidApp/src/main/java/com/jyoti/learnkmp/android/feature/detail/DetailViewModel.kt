package com.jyoti.learnkmp.android.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyoti.learnkmp.data.model.RocketLaunch
import com.jyoti.learnkmp.domain.RocketLaunchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class DetailViewModel(private val launchUseCase: RocketLaunchUseCase) : ViewModel() {

    private val _launchListState: MutableStateFlow<RocketLaunch?> = MutableStateFlow(null)
    val screenState: StateFlow<RocketLaunch?> = _launchListState
    fun fetchRocketInfo(id: String) {
        viewModelScope.launch {
            _launchListState.value = try {
                launchUseCase.invoke(id)
            } catch (e: Exception) {
                null
            }
        }
    }

}