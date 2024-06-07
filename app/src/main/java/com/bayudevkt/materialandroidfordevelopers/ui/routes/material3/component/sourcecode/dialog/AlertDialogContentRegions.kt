// This should not be edited instead you can always generate using `source_code_generator.js`.


 object AlertDialogContentSourceCode {
 
     val code get() = """
 
@Composable
fun AlertDialogContent(
    modifier: Modifier = Modifier,
) {
    var openDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { openDialog = true }) {
            Text(text = "Request Location")
        }
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            },
            confirmButton = {
                TextButton(onClick = {
                    openDialog = false
                }) {
                    Text(text = "Allow")
                }
            },
            dismissButton = {
                Button(onClick = { openDialog = false }) {
                    Text(text = "Deny")
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location"
                )
            },
            title = {
                Text(text = "Demo Request Location?")
            },
            text = {
                Text(text = "Please allow application to access your location. Thank You :)")
            },
            shape = MaterialTheme.shapes.large,
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
}

     """.trimIndent()
 }