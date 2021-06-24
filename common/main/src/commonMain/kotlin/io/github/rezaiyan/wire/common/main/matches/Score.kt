package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Score (

	val winner : String? = null,
	val duration : String,
	val fullTime : FullTime,
	val halfTime : HalfTime,
	val extraTime : ExtraTime,
	val penalties : Penalties? = null
)