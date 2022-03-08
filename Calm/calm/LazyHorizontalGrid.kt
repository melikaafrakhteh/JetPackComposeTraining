package com.afrakhteh.learncompose.calm

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun LazyHorizontalGrid(
    cells: GridCells.Fixed,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyGridScope.() -> Unit
) {
    val scope = LazyGridScopeImpl()
    scope.apply(content)

    when (cells) {
        is GridCells.Fixed ->
            FixedLazyGrid(
                nRows = cells.count,
                modifier = modifier,
                state = state,
                contentPadding = contentPadding,
                scope = scope
            )
    // is GridCells.Adaptive -> { }
    }
}

@Composable
@ExperimentalFoundationApi
private fun FixedLazyGrid(
    nRows: Int,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    scope: LazyGridScopeImpl
) {
    val columns = (scope.totalSize + nRows - 1) / nRows
    LazyRow(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
    ) {
        items(columns) { columnIndex ->
            Column {
                for (rowIndex in 0 until nRows) {
                    val itemIndex = columnIndex * nRows + rowIndex
                    if (itemIndex < scope.totalSize) {
                        Box(
                            modifier = Modifier.wrapContentSize(),
                            propagateMinConstraints = true
                        ) {
                            scope.contentFor(itemIndex, this@items).invoke()
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}