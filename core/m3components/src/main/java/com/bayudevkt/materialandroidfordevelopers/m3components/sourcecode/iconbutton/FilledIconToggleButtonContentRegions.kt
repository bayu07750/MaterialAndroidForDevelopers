// This should not be edited instead you can always generate using `source_code_generator.js`.


 object FilledIconToggleButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun FilledIconToggleButtonContent(
    modifier: Modifier = Modifier,
) {
    var darkMode by remember { mutableStateOf(false) }

    MaterialAndroidForDevelopersTheme(
        darkTheme = darkMode,
        dynamicColor = false,
    ) {
        Surface {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = )
                FilledIconToggleButton(
                    checked = darkMode,
                    onCheckedChange = { darkMode = it },
                ) {
                    Icon(
                        imageVector = if (darkMode)
                            Icons.Default.DarkMode else
                            Icons.Default.LightMode,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

     """.trimIndent()
 }