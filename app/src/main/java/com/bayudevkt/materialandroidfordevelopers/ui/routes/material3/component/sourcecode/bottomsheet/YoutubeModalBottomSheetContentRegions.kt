// This should not be edited instead you can always generate using `source_code_generator.js`.


 object YoutubeModalBottomSheetContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YoutubeModalBottomSheetContent(
    modifier: Modifier = Modifier,
    options: List<DataDropdownMenu> = remember { DataDummy.dataDropdownMenu }
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var openBottomState by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(10) {
            YoutubeItem(
                onMenuClicked = {
                    openBottomState = true
                }
            )
        }
    }

    if (openBottomState) {
        ModalBottomSheet(
            onDismissRequest = {
                openBottomState = false
            },
            content = {
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
                                    openBottomState = false
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
            },
            sheetState = sheetState,
        )
    }
}

@Composable
fun YoutubeItem(
    onMenuClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 200.dp),
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Surface(
                    modifier = Modifier
                        .padding(bottom = 8.dp, end = 8.dp)
                        .align(Alignment.BottomEnd),
                    shape = MaterialTheme.shapes.small,
                    color = Color.Black,
                    contentColor = Color.White,
                ) {
                    Text(
                        modifier = Modifier.padding(all = 4.dp),
                        text = "27:09",
                        fontSize = 12.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column {
                        Text(
                            text = "A bird flying sunset",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Text(text = "Person - 94K - 1 hour ago")
                    }
                }
                IconButton(onClick = onMenuClicked) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

     """.trimIndent()
 }