// This should not be edited instead you can always generate using `source_code_generator.js`.


 object IconButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun IconButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Camera")
        }
        IconButton(onClick = { /*TODO*/ }, enabled = false) {
            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Camera")
        }
    }
}

     """.trimIndent()
 }