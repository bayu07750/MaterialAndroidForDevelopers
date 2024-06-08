// This should not be edited instead you can always generate using `source_code_generator.js`.


 object BadgeContentSourceCode {
 
     val code get() = """
 
@Composable
fun BadgeContent(
    modifier: Modifier = Modifier,
) {
    val items = remember {
        listOf(
            Icons.Rounded.Home to "Home",
            Icons.Rounded.Explore to "Explore",
            Icons.Rounded.Favorite to "Favorite",
        )
    }
    var selectedItem by remember { mutableStateOf(items.first().second) }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    selected = item.second == selectedItem,
                    onClick = {
                        selectedItem = item.second
                    },
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge {
                                    val badgeInt = 12
                                    Text(
                                        text = badgeInt.toString(),
                                        modifier = Modifier
                                    )
                                }
                            },
                            content = {
                                Icon(
                                    imageVector = item.first,
                                    contentDescription = item.second
                                )
                            }
                        )
                    },
                    label = {
                        Text(text = item.second)
                    },
                )
            }
        }
    }
}

     """.trimIndent()
 }