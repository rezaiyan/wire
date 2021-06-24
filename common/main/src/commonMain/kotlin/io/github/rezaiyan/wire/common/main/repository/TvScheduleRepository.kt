package io.github.rezaiyan.wire.common.main.repository

import io.github.rezaiyan.wire.common.main.entities.Conductor
import io.github.rezaiyan.wire.common.main.remote.TvScheduleApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import io.github.rezaiyan.wire.common.main.state.WireResult

class TvScheduleRepository : KoinComponent{
    private val api: TvScheduleApi by inject()
    private var conductor: Conductor? = null

    @Throws(Exception::class)
    suspend fun getMatches(): WireResult<Conductor> {
        var exc : Exception? = null
        try {
            conductor = api.fetchTv3Timeline().zip(api.fetchVarzeshTimeline())
        } catch (e: Exception) {
            exc = e
            e.printStackTrace()
        }

        if (exc!=null){
            return WireResult.WireError(exc)
        }

        return WireResult.WireSuccess(conductor!!)
    }


}

private fun Conductor.zip(it: Conductor): Conductor {
    this.list.toMutableList().addAll(it.list)
    return this
}
