// This should not be edited instead you can always generate using `source_code_generator.js`.


 object DateRangePickerContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val dateRangeState = rememberDateRangePickerState(
            yearRange = 2000..2045,
            initialDisplayMode = DisplayMode.Picker,
        )
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 4.dp,
            modifier = Modifier
                .weight(1f)
        ) {
            DateRangePicker(
                state = dateRangeState,
                modifier = Modifier,
                showModeToggle = true,
            )
        }
        val context = LocalContext.current
        Button(onClick = {
            val startDate = DateHelper.formatTime(dateRangeState.selectedStartDateMillis)
            val endDate = DateHelper.formatTime(dateRangeState.selectedEndDateMillis)
            Toast.makeText(context, , Toast.LENGTH_LONG).show()
        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Select Date")
        }
    }
}

     """.trimIndent()
 }