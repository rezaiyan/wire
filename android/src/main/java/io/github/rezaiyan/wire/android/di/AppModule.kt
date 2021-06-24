package io.github.rezaiyan.wire.android

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { TvScheduleViewModel(get()) }
}
