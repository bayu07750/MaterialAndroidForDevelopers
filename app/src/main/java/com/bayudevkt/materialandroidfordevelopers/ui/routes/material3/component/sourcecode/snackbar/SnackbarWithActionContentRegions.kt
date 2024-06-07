// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SnackbarWithActionContentSourceCode {
 
     val code get() = """
 
@Composable
fun SnackbarWithActionContent(
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val showSnackbar: (String) -> Unit = { message: String ->
        scope.launch {
            val snackbarResult = snackbarHostState.showSnackbar(
                message,
                actionLabel = "OK",
                withDismissAction = true,
            )
            when (snackbarResult) {
                Dismissed -> {
                    Toast.makeText(context, "Dismissed", Toast.LENGTH_SHORT).show()
                }

                SnackbarResult.ActionPerformed -> {
                    Toast.makeText(context, "Clicked OK", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPad ->
        Column(
            modifier = Modifier
                .padding(innerPad)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            var message by remember { mutableStateOf("") }
            TextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                label = {
                    Text(text = "Your Message to the World")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    showSnackbar(message)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            ) {
                Text(text = "Send message")
            }
        }
    }
}

     """.trimIndent()
 }