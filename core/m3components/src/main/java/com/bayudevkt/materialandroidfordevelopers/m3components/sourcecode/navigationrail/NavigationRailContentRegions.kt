// This should not be edited instead you can always generate using `source_code_generator.js`.


 object NavigationRailContentSourceCode {
 
     val code get() = """
 
@Composable
fun NavigationRailContent(
    modifier: Modifier = Modifier,
) {
    val items = remember {
        listOf(
            Icons.Default.Home to "Home",
            Icons.Default.FavoriteBorder to "Favorite",
            Icons.Default.Settings to "Settings",
        )
    }
    var selectedItem by remember { mutableStateOf(items.first().second) }

    Row(
        modifier = modifier
            .fillMaxSize(),
    ) {
        NavigationRail(
            header = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        ) {
            items.forEach { item ->
                NavigationRailItem(
                    selected = item.second == selectedItem,
                    onClick = {
                        selectedItem = item.second
                    },
                    icon = {
                        Icon(imageVector = item.first, contentDescription = item.second)
                    },
                    label = {
                        Text(text = item.second)
                    },
                    alwaysShowLabel = true,
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = selectedItem)
        }
    }
}

     """.trimIndent()
 }