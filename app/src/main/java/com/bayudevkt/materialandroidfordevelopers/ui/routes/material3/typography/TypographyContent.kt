package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.typography

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/**
 * Typography
 */

@Composable
fun TypographyContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = stringResource(R.string.display_large_56sp),
            style = MaterialTheme.typography.displayLarge,
        )
        Text(
            text = stringResource(R.string.display_medium_45sp),
            style = MaterialTheme.typography.displayMedium,
        )
        Text(
            text = stringResource(R.string.display_small_36sp),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(R.string.headline_large_32sp),
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = stringResource(R.string.headline_medium_28sp),
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = stringResource(R.string.headline_small_24sp),
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = stringResource(R.string.title_large_22sp),
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = stringResource(R.string.title_medium_16sp),
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = stringResource(R.string.title_small_14sp),
            style = MaterialTheme.typography.titleSmall,
        )
        Text(
            text = stringResource(R.string.body_large_16sp),
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = stringResource(R.string.body_medium_14sp),
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = stringResource(R.string.body_small_12sp),
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            text = stringResource(R.string.label_large_14sp),
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            text = stringResource(R.string.label_medium_12sp),
            style = MaterialTheme.typography.labelMedium,
        )
        Text(
            text = stringResource(R.string.label_small_11sp),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypographyPage() {
    MaterialAndroidForDevelopersTheme {
        TypographyContent()
    }
}