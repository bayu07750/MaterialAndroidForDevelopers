// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SwitchContentSourceCode {
 
     val code get() = """
 
@Composable
fun SwitchContent(
    modifier: Modifier = Modifier,
) {
    var darkTheme by remember { mutableStateOf(false) }
    MaterialAndroidForDevelopersTheme(
        darkTheme = darkTheme
    ) {
        Surface {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = !darkTheme },
                    thumbContent = {
                        Icon(
                            imageVector = if (darkTheme) Icons.Default.DarkMode else Icons.Default.LightMode,
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                )
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = !darkTheme },
                    thumbContent = {
                        Icon(
                            imageVector = if (darkTheme) Icons.Default.DarkMode else Icons.Default.LightMode,
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp)
                        )
                    },
                    enabled = false
                )
            }
        }
    }
}

     """.trimIndent()
 }