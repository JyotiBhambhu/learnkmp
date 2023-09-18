package com.jyoti.learnkmp.android.feature.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyoti.learnkmp.data.model.RocketLaunch
import com.jyoti.learnkmp.domain.RocketLaunchesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LaunchViewModel(private val launchUseCase: RocketLaunchesUseCase): ViewModel() {

    private val _launchListState: MutableStateFlow<List<RocketLaunch>> = MutableStateFlow(listOf())
    val screenState: StateFlow<List<RocketLaunch>> = _launchListState
    init {
        viewModelScope.launch {
            _launchListState.value = try {
                launchUseCase.invoke()
            } catch (e: Exception) {
                listOf()
            }
        }
    }

}