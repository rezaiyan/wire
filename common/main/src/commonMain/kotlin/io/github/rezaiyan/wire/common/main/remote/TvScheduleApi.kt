package io.github.rezaiyan.wire.common.main.remote

import io.github.rezaiyan.wire.common.main.entities.Conductor
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

class TvScheduleApi(private val client: HttpClient) : KoinComponent {
    suspend fun fetchVarzeshTimeline() = client.get<Conductor>("https://api.codebazan.ir/tv/index.php?type=url&link=https://www.irib" +
          ".ir/conductor/47/%D8%AC%D8%AF%D9%88%D9%84-%D9%BE%D8%AE%D8%B4-%D8%B4%D8%A8%DA%A9%D9%87-%D9%88%D8%B1%D8%B2%D8%B4"){
    }
    suspend fun fetchTv3Timeline() = client.get<Conductor>("https://api.codebazan.ir/tv/index.php?type=url&link=https://www.irib.ir/conductor/33/%D8%AC%D8%AF%D9%88%D9%84-%D9%BE%D8%AE%D8%B4-%D8%B4%D8%A8%DA%A9%D9%87-%D8%B3%D9%87/"){
    }
}
