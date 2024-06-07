// This should not be edited instead you can always generate using `source_code_generator.js`.


 object TimePickerContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerContent(
    modifier: Modifier = Modifier,
) {
    var is24HourFormat by remember { mutableStateOf(false) }
    val state = rememberTimePickerState(is24Hour = is24HourFormat)
    val context = LocalContext.current
    var checked by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(top = 32.dp),
    ) {
        Text(text = "24 Hour Format", modifier = Modifier.align(Alignment.CenterHorizontally),)
        Switch(
            checked = is24HourFormat,
            onCheckedChange = { is24HourFormat = it },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                TimeInput(state = state)
            } else {
                TimePicker(state = state)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconToggleButton(
                checked = checked,
                onCheckedChange = { checked = it },
                content = {
                    Icon(
                        imageVector = if (checked) {
                            Icons.Default.CalendarMonth
                        } else {
                            Icons.Default.KeyboardAlt
                        }, contentDescription = null
                    )
                }
            )
            Button(onClick = {
                val hour = state.hour
                val minute = state.minute
                Toast.makeText(context, , Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Submit")
            }
        }
    }
}

     """.trimIndent()
 }