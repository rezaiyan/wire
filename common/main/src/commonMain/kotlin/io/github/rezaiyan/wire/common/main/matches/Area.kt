package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Area (

	val name : String,
	val code : String,
	val ensignUrl : String? = null
)