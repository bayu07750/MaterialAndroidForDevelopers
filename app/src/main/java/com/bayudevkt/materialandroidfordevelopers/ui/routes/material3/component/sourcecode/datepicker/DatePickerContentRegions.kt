// This should not be edited instead you can always generate using `source_code_generator.js`.


 object DatePickerContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Surface(
            tonalElevation = 3.dp
        ) {
            val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(
                state = datePickerState,
                modifier = modifier,
            )
        }
        Surface(
            tonalElevation = 3.dp
        ) {
            val currentTimeInMills = remember {
                Calendar.getInstance().timeInMillis
            }
            val yearRange = 2000..20445
            val datePickerState = rememberDatePickerState(
                yearRange = yearRange,
                initialSelectedDateMillis = currentTimeInMills
            )
            DatePicker(
                state = datePickerState,
                modifier = modifier,
                showModeToggle = false,
            )
        }
    }
}

     """.trimIndent()
 }