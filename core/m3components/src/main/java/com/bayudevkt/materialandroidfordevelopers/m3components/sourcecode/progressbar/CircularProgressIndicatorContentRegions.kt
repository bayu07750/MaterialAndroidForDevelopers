// This should not be edited instead you can always generate using `source_code_generator.js`.


 object CircularProgressIndicatorContentSourceCode {
 
     val code get() = """
 
@Composable
fun CircularProgressIndicatorContent(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(24.dp))

            var progress by remember { mutableFloatStateOf(0.2f) }
            val progressAnim by animateFloatAsState(targetValue = progress, label = "Progress")
            Box(modifier = Modifier.size(100.dp)) {
                CircularProgressIndicator(
                    progress = { progressAnim },
                    modifier = Modifier.matchParentSize(),
                    strokeWidth = 15.dp,
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                FilledTonalIconButton(onClick = {
                    if (progress >= 1f) return@FilledTonalIconButton
                    progress += 0.1f
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
                FilledTonalIconButton(onClick = {
                    if (progress <= 0.0f) return@FilledTonalIconButton
                    progress -= 0.1f
                }) {
                    Icon(imageVector = Icons.Default.HorizontalRule, contentDescription = "Min")
                }
            }
        }
    }
}

     """.trimIndent()
 }