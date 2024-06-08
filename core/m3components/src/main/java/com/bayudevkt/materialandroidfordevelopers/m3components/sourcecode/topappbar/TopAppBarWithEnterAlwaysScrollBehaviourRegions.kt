// This should not be edited instead you can always generate using `source_code_generator.js`.


 object TopAppBarWithEnterAlwaysScrollBehaviourSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithEnterAlwaysScrollBehaviour(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = windowInsets,
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                },
                title = {
                    Text(text = "TopAppBarWithEnterAlwaysScrollBehaviour", modifier = Modifier.basicMarquee(),)
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Save, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                    }
                }
            )
        }
    ) {
        ContentColors(
            modifier = Modifier
                .padding(it),
        )
    }
}

@Composable
fun ContentColors(
    modifier: Modifier = Modifier,
    colors: List<String> = remember { DataDummy.listColors },
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items = colors) { color ->
            Surface(
                color = Color(android.graphics.Color.parseColor()),
                shape = MaterialTheme.shapes.medium,
                contentColor = androidx.compose.ui.graphics.Color.White,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = ,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        IconButton(
                            onClick = {
                                context.copyText(color)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.CopyAll,
                                contentDescription = Icons.Default.CopyAll.name
                            )
                        }
                    }
                }
            }
        }
    }
}

     """.trimIndent()
 }