// This should not be edited instead you can always generate using `source_code_generator.js`.


 object LinearProgressIndicatorContentSourceCode {
 
     val code get() = """
 
@Composable
fun LinearProgressIndicatorContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
        )

        Spacer(modifier = Modifier.height(24.dp))
        var progress by remember { mutableFloatStateOf(0.0f) }
        val progressAnim by animateFloatAsState(
            targetValue = progress,
            label = "progress",
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            progress = { progressAnim },
            modifier = Modifier.fillMaxWidth(),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                progress -= 0.1f
            }, enabled = progress > 0.0f) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
            }
            IconButton(onClick = {
                progress += 0.1f
            }, enabled = progress < 1.0f) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
            }
        }
    }
}

     """.trimIndent()
 }