package io.github.rezaiyan.wire.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.ui.res.stringResource
import io.github.rezaiyan.wire.common.ui.FullScreenLoading
import io.github.rezaiyan.wire.common.ui.HomeScreenErrorAndContent
import io.github.rezaiyan.wire.common.ui.LoadingContent
import io.github.rezaiyan.wire.common.ui.produceUiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TvScheduleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
          WireTheme {
            val (postUiState, refreshPost, clearError) = produceUiState(viewModel) {
              getPrograms()
            }

            if (postUiState.value.hasError) {
              val errorMessage = stringResource(id = R.string.load_error) + "\n" + postUiState
                .value.exception!!.localizedMessage
              val retryMessage = stringResource(id = R.string.retry)

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
                val title = stringResource(id = R.string.schedule)
                TopAppBar(title = { Text(text = title) })
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

}