// This should not be edited instead you can always generate using `source_code_generator.js`.


 object DatePickerDialogContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogContent(
    modifier: Modifier = Modifier,
) {
    var openDialog by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            openDialog = true
        }) {
            Text(text = "Show Date Picker")
        }
    }

    if (openDialog) {
        val datePickerState = rememberDatePickerState()
        val context = LocalContext.current
        DatePickerDialog(
            onDismissRequest = { openDialog = false },
            confirmButton = {
                Button(onClick = {
                    val selectedDate = DateHelper.formatTime(datePickerState.selectedDateMillis)
                    Toast.makeText(context, selectedDate, Toast.LENGTH_SHORT).show()
                    openDialog = false
                }) {
                    Text(text = "Submit")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog = false
                }) {
                    Text(text = "Cancel")
                }
            },
            content = {
                DatePicker(
                    state = datePickerState,
                )
            }
        )
    }
}

     """.trimIndent()
 }