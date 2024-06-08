// This should not be edited instead you can always generate using `source_code_generator.js`.


 object CardContentSourceCode {
 
     val code get() = """
 
@Composable
fun CardContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Card
        Card(
            modifier = Modifier.widthIn(max = 140.dp),
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
        Card(
            modifier = Modifier.widthIn(max = 140.dp),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
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
        Card(
            modifier = Modifier.widthIn(max = 140.dp),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            },
            enabled = false,
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