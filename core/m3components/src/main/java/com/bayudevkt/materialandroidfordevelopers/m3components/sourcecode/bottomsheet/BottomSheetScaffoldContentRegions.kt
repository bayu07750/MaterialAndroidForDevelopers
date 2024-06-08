// This should not be edited instead you can always generate using `source_code_generator.js`.


 object BottomSheetScaffoldContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun BottomSheetScaffoldContent(
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded,
            skipHiddenState = true,
        ),
        snackbarHostState = snackbarHostState,
    )
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetContent = {
            val padModifier = Modifier
                .padding(horizontal = 16.dp)
            Text(
                modifier = padModifier,
                text = "A bird flying over the ocean at sunset photo",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider(modifier = padModifier)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = padModifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(text = "Views", style = MaterialTheme.typography.bodySmall)
                    Text(text = "226,295", style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = "Downloads", style = MaterialTheme.typography.bodySmall)
                    Text(text = "1,870", style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = "Features In", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Editorial", style = MaterialTheme.typography.bodyLarge)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = padModifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    tint = Color.Blue.copy(alpha = 0.5f)
                )
                Text(text = "Gred Bulla - On Unsplash", style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(20) {
                    Image(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(MaterialTheme.shapes.medium),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        },
        sheetPeekHeight = 200.dp,
        sheetShape = MaterialTheme.shapes.large,
        sheetDragHandle = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(text = "swipe me!")
                BottomSheetDefaults.DragHandle()
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = it) { data ->
                Snackbar(
                    snackbarData = data,
                    shape = CircleShape,
                    containerColor = BottomSheetDefaults.ContainerColor,
                    contentColor = MaterialTheme.colorScheme.contentColorFor(BottomSheetDefaults.ContainerColor),
                    dismissActionContentColor = MaterialTheme.colorScheme.contentColorFor(BottomSheetDefaults.ContainerColor),
                    actionColor = MaterialTheme.colorScheme.primary
                )
            }
        },
        topBar = {
            TopAppBar(title = { Text(text = "Demo BottomSheetScaffold") })
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Image(
                modifier = Modifier
                    .combinedClickable(
                        onClick = {
                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    "Snackbar",
                                    actionLabel = "OK",
                                    withDismissAction = true
                                )
                                when (result) {
                                    SnackbarResult.Dismissed -> {
                                        Toast
                                            .makeText(context, "Close", Toast.LENGTH_SHORT)
                                            .show()
                                    }

                                    SnackbarResult.ActionPerformed -> {
                                        Toast
                                            .makeText(context, "OK", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        },
                        onLongClick = {

                        }
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Try to click or long click image",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White.copy(alpha = .5f)
            )
        }
    }
}

     """.trimIndent()
 }