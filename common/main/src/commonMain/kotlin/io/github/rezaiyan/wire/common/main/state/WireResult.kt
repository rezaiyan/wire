/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.rezaiyan.wire.common.main.state

import io.github.rezaiyan.wire.common.main.state.WireResult.WireSuccess

/**
 * A generic class that holds a value or an exception
 */
sealed class WireResult<out R> {

    data class WireSuccess<out T>(val data: T) : WireResult<T>()
    data class WireError(val exception: Exception) : WireResult<Nothing>()
}

/**
 * `true` if [WireResult] is of type [WireSuccess] & holds non-null [WireSuccess.data].
 */
val WireResult<*>.succeeded
    get() = this is WireSuccess && data != null

fun <T> WireResult<T>.successOr(fallback: T): T {
    return (this as? WireSuccess<T>)?.data ?: fallback
}
