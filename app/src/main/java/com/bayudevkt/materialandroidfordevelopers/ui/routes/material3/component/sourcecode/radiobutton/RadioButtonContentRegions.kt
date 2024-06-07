// This should not be edited instead you can always generate using `source_code_generator.js`.


 object RadioButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun RadioButtonContent(
    modifier: Modifier = Modifier,
) {
    var darkMode by remember { mutableStateOf(false) }

    MaterialAndroidForDevelopersTheme(
        darkTheme = darkMode,
        dynamicColor = false
    ) {
        Surface {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Text(text = "Theme", modifier = Modifier.padding(start = 16.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    RadioButton(
                        selected = !darkMode,
                        onClick = {
                            darkMode = !darkMode
                        }
                    )
                    Text(text = "Light")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    RadioButton(
                        selected = darkMode,
                        onClick = {
                            darkMode = !darkMode
                        }
                    )
                    Text(text = "Dark")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    RadioButton(
                        selected = false,
                        onClick = {},
                        enabled = false
                    )
                    Text(text = "System Theme")
                }
            }
        }
    }
}

     """.trimIndent()
 }