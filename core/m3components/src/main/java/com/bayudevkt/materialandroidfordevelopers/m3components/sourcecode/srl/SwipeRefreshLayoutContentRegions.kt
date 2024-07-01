// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SwipeRefreshLayoutContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeRefreshLayoutContent(
    modifier: Modifier = Modifier,
) {
    val pullToRefreshState = rememberPullToRefreshState()
    LaunchedEffect(pullToRefreshState.isRefreshing) {
        if (pullToRefreshState.isRefreshing) {
            delay(2000)
            pullToRefreshState.endRefresh()
        }
    }
    Box(
        modifier = modifier
            .nestedScroll(pullToRefreshState.nestedScrollConnection),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = 100) { index ->
                ListItem(
                    headlineContent = { Text(text = ) }
                )
            }
        }
        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier
                .align(Alignment.TopCenter),
        )
    }
}

     """.trimIndent()
 }