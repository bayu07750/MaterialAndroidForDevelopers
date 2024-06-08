// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ElevatedCardContentSourceCode {
 
     val code get() = """
 
@Composable
fun ElevatedCardContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Card
        ElevatedCard(
            modifier = Modifier.widthIn(max = 140.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                modifier = Modifier
                    .width(140.dp)
                    .height(100.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Card Example",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        // Card with OnClick
        ElevatedCard(
            modifier = Modifier.widthIn(max = 140.dp),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            },
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                modifier = Modifier
                    .width(140.dp)
                    .height(100.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Try click me!",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        // Disabled Card
        ElevatedCard(
            modifier = Modifier.widthIn(max = 140.dp),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            },
            enabled = false,
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp,
                disabledElevation = 20.dp,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                modifier = Modifier
                    .width(140.dp)
                    .height(100.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Card Disabled",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

     """.trimIndent()
 }