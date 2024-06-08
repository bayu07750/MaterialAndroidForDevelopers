// This should not be edited instead you can always generate using `source_code_generator.js`.


 object MultiChoiceSegmentedButtonRowContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiChoiceSegmentedButtonRowContent(
    modifier: Modifier = Modifier,
) {
    val checkedList = remember { mutableStateListOf<Int>() }
    val options = listOf("Home", "Favorite", "Settings")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.Favorite,
        Icons.Filled.Settings,
    )
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    icon = {
                        SegmentedButtonDefaults.Icon(active = index in checkedList) {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = null,
                                modifier = Modifier.size(SegmentedButtonDefaults.IconSize)
                            )
                        }
                    },
                    onCheckedChange = {
                        if (index in checkedList) {
                            checkedList.remove(index)
                        } else {
                            checkedList.add(index)
                        }
                    },
                    checked = index in checkedList
                ) {
                    Text(label)
                }
            }
        }
    }
}

     """.trimIndent()
 }