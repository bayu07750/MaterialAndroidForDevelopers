// This should not be edited instead you can always generate using `source_code_generator.js`.


 object BottomAppBarWithScrollBehaviourContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarWithScrollBehaviourContent(
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    Column(
        modifier = modifier,
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .weight(1f),
        ) {
            item {
                CenterAlignedTopAppBar(title = {
                    Text(text = "Scroll me")
                })
            }
            items(100) { index ->
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 2.dp,
                    tonalElevation = 2.dp,
                ) {
                    Text(text = , modifier = Modifier.padding(16.dp))
                }
            }
        }
        BottomAppBar(
            scrollBehavior = scrollBehavior,
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Explore, contentDescription = "Explore")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
            },
        )
    }
}

     """.trimIndent()
 }