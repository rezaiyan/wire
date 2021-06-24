package io.github.rezaiyan.wire.android

import androidx.lifecycle.ViewModel
import io.github.rezaiyan.wire.common.main.repository.TvScheduleRepository

class TvScheduleViewModel(private val repo : TvScheduleRepository) : ViewModel() {

  suspend fun getPrograms() = repo.getMatches()
}