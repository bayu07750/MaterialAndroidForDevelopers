// This should not be edited instead you can always generate using `source_code_generator.js`.


 object HorizontalMultiBrowseCarouselContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalMultiBrowseCarouselContent(
    modifier: Modifier = Modifier,
) {
    val items = remember {
        listOf(
            R.drawable.gambar_1,
            R.drawable.gambar_2,
            R.drawable.gambar_3,
            R.drawable.gambar_4,
            R.drawable.image
        )
    }

    val carouselState = rememberCarouselState { items.size }

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        HorizontalMultiBrowseCarousel(
            state = carouselState,
            preferredItemWidth = 160.dp,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(16.dp),
        ) { position ->
            Image(
                modifier = Modifier
                    .maskClip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = items[position]),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

     """.trimIndent()
 }