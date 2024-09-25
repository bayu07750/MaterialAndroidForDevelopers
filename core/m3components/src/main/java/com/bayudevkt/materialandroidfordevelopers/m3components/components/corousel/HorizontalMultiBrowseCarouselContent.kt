package com.bayudevkt.materialandroidfordevelopers.m3components.components.corousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
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

    HorizontalMultiBrowseCarousel(
        state = carouselState,
        preferredItemWidth = 160.dp,
        modifier = modifier
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
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalMultiBrowseCarouselContent() {
    MaterialAndroidForDevelopersTheme {
        HorizontalMultiBrowseCarouselContent()
    }
}