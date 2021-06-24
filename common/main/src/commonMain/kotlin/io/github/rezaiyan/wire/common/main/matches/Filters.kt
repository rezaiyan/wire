package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Filters (

	val dateFrom : String,
	val dateTo : String,
	val permission : String? = null
)