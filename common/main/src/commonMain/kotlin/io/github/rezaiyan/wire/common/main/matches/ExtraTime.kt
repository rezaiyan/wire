package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class ExtraTime (

	val homeTeam : String? = null,
	val awayTeam : String? = null
)