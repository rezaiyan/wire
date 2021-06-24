package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Penalties (

	val homeTeam : String? = null,
	val awayTeam : String? = null
)