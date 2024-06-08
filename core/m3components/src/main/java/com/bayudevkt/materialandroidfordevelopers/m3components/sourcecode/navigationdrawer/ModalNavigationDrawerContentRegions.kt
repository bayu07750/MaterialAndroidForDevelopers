// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ModalNavigationDrawerContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigationDrawerContent(
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val scope = rememberCoroutineScope()
    val drawerItems = remember {
        listOf(
            Icons.Default.Add to "New Chat",
            Icons.Default.History to "History",
            Icons.Default.Settings to "Settings",
            Icons.AutoMirrored.Filled.Help to "Help Center",
        )
    }
    var selectedItem by remember { mutableStateOf(drawerItems.first().second) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                val padModifier = Modifier
                    .padding(horizontal = 16.dp)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = padModifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column {
                        Text(
                            text = "Your Name?",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium)
                        )
                        Text(
                            text = "Enter Email",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    modifier = padModifier,
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 5.dp,
                ) {
                    Text(
                        text = "Free Plan",
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                HorizontalDivider(modifier = padModifier)
                Spacer(modifier = Modifier.height(8.dp))
                drawerItems.take(2).forEach { data ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        label = { Text(text = data.second) },
                        icon = { Icon(imageVector = data.first, contentDescription = data.second) },
                        selected = data.second == selectedItem,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem = data.second
                        }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                HorizontalDivider(modifier = padModifier)
                Spacer(modifier = Modifier.height(8.dp))
                drawerItems.takeLast(2).forEach { data ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        label = { Text(text = data.second) },
                        icon = { Icon(imageVector = data.first, contentDescription = data.second) },
                        selected = data.second == selectedItem,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem = data.second
                        }
                    )
                }
            }
        },
        content = {
            Scaffold(
                modifier = modifier,
                contentWindowInsets = contentWindowInsets,
                topBar = {
                    TopAppBar(
                        title = { },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            }
                        }
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = selectedItem)
                }
            }
        }
    )
}

     """.trimIndent()
 }