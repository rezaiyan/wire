package io.github.rezaiyan.wire.desktop

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult.ActionPerformed
import androidx.compose.material.SnackbarResult.Dismissed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import io.github.rezaiyan.wire.common.main.di.initKoin
import io.github.rezaiyan.wire.common.main.repository.TvScheduleRepository
import io.github.rezaiyan.wire.common.ui.FullScreenLoading
import io.github.rezaiyan.wire.common.ui.HomeScreenErrorAndContent
import io.github.rezaiyan.wire.common.ui.LoadingContent
import io.github.rezaiyan.wire.common.ui.produceUiState

private val koin = initKoin(enableNetworkLogs = true).koin

fun main() = Window("Wire") {

  val repo = koin.get<TvScheduleRepository>()

  Surface(modifier = Modifier.fillMaxSize()) {

    val scaffoldState = rememberScaffoldState()
    Surface(color = MaterialTheme.colors.background) {

      val (postUiState, refreshPost, clearError) = produceUiState(repo) {
        getMatches()
      }

      if (postUiState.value.hasError) {
        val errorMessage = "Can\\'t update latest news"
        val retryMessage = "Retry"

        val onRefreshPostsState by rememberUpdatedState(refreshPost)
        val onErrorDismissState by rememberUpdatedState(clearError)

        LaunchedEffect(scaffoldState) {

          val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
            message = errorMessage,
            actionLabel = retryMessage
          )
          when (snackbarResult) {
            ActionPerformed -> onRefreshPostsState()
            Dismissed -> onErrorDismissState()
          }
        }
      }
      Scaffold(
        topBar = {
          val title = "Sport TV Schedule"
          TopAppBar(
            title = { Text(text = title) }
          )
        },
        scaffoldState = scaffoldState,
        content ={
          LoadingContent(
            empty = postUiState.value.initialLoad,
            emptyContent = { FullScreenLoading() },
            loading = postUiState.value.loading,
            onRefresh = refreshPost,
            content = {
              HomeScreenErrorAndContent(
                posts = postUiState.value,
                onRefresh = {
                  refreshPost()
                }
              )
            }
          )
        }
      )
    }

  }
}