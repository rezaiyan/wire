package io.github.rezaiyan.wire.common.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.text.style.TextAlign.End
import androidx.compose.ui.text.style.TextAlign.Start
import androidx.compose.ui.unit.dp
import io.github.rezaiyan.wire.common.main.entities.Conductor
import io.github.rezaiyan.wire.common.main.entities.Program
import io.github.rezaiyan.wire.common.main.state.UiState

@Composable
fun HomeScreenErrorAndContent(
  posts: UiState<Conductor>,
  onRefresh: () -> Unit,
  modifier: Modifier = Modifier
) {
  if (posts.data != null) {

    LazyColumn {
      items(
        items = posts.data!!.list,
        itemContent = {
          ProgramRow(program = it)
        })
    }
  } else if (!posts.hasError) {
    // if there are no posts, and no error, let the user refresh manually

  } else {
    // there's currently an error showing, don't show any content
    TextButton(onClick = onRefresh, modifier.fillMaxSize()) {
      Text("Tap to load content", textAlign = Center)
    }
  }
}

@Composable
fun ProgramRow(program: Program) {
  Card(
    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
    elevation = 2.dp,
    backgroundColor = androidx.compose.ui.graphics.Color.White,
    shape = RoundedCornerShape(corner = CornerSize(16.dp))

  ) {
    Row {
      Column(
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth()
          .align(Alignment.CenterVertically)) {
        Text(
          textAlign = End,
          modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
          text = program.title,
          style = typography.h6
        )
        Text(
          textAlign = Start,
          modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
          text = program.start,
          style = typography.caption
        )
      }
    }
  }
}

/**
 * Display an initial empty state or swipe to refresh content.
 *
 * @param empty (state) when true, display [emptyContent]
 * @param emptyContent (slot) the content to display for the empty state
 * @param loading (state) when true, display a loading spinner over [content]
 * @param onRefresh (event) event to request refresh
 * @param content (slot) the main content to show
 */
@Composable
fun LoadingContent(
  empty: Boolean,
  emptyContent: @Composable () -> Unit,
  loading: Boolean,
  onRefresh: () -> Unit,
  content: @Composable () -> Unit
) {
  if (empty) {
    emptyContent()
  } else {
    SwipeToRefreshLayout(
      refreshingState = loading,
      onRefresh = onRefresh,
      refreshIndicator = {
        Surface(elevation = 10.dp, shape = CircleShape) {
          CircularProgressIndicator(
            modifier = Modifier
              .size(36.dp)
              .padding(4.dp)
          )
        }
      },
      content = content,
    )
  }
}

@Composable
fun FullScreenLoading() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    CircularProgressIndicator()
  }
}