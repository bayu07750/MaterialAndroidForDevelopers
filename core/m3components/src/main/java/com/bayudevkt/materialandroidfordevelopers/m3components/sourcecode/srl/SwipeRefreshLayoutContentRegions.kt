// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SwipeRefreshLayoutContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeRefreshLayoutContent(
    modifier: Modifier = Modifier,
) {
    var isRefreshing by remember { mutableStateOf(false) }
    val pullToRefreshState = rememberPullToRefreshState()
    val coroutineScope = rememberCoroutineScope()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            coroutineScope.launch {
                delay(2000)
                isRefreshing = false
            }
        },
        state = pullToRefreshState,
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (isRefreshing) {
            Text("Loading data...")
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(count = 100) { index ->
                    ListItem(
                        headlineContent = { Text(text = ) }
                    )
                }
            }
        }
    }
}

     """.trimIndent()
 }