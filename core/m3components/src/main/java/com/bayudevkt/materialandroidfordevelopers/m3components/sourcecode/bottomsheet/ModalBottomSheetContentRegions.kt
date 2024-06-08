// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ModalBottomSheetContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetContent(
    modifier: Modifier = Modifier,
    options: List<DataDropdownMenu> = remember { DataDummy.dataDropdownMenu }
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            showBottomSheet = true
        }) {
            Text(text = "Show ModalBottomSheet")
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
            shape = MaterialTheme.shapes.extraLarge,
        ) {
            options.forEach { data ->
                DropdownMenuItem(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    text = {
                        Text(text = data.text)
                    },
                    onClick = {
                        scope.launch {
                            Toast.makeText(context, data.text, Toast.LENGTH_SHORT).show()
                            sheetState.hide()
                        }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = data.icon,
                            contentDescription = null
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

     """.trimIndent()
 }