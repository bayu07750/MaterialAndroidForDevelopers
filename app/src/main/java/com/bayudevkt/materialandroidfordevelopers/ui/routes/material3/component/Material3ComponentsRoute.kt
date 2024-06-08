package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Collections
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.m3components.model.CategoryComponent
import com.bayudevkt.materialandroidfordevelopers.m3components.model.Component
import com.bayudevkt.materialandroidfordevelopers.m3components.model.availableMaterial3Components
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.AppListItem
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.BottomRoundedCornerShape
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.FullRoundedCornerShape
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.TopRoundedCornerShape
import com.bayudevkt.materialandroidfordevelopers.ui.utils.LargeTopAppBarWithBackButton
import kotlinx.collections.immutable.ImmutableMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3ComponentsRoute(
    onComponentItemClicked: (String) -> Unit,
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
    data: ImmutableMap<CategoryComponent, List<Component>> = remember { availableMaterial3Components }
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            LargeTopAppBarWithBackButton(
                title = "Components",
                onBack = onBack,
                scrollBehavior = scrollBehavior,
                onSettingsClicked = onSettingsClicked,
            )
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentPadding = PaddingValues(top = 16.dp)
        ) {
            data.forEach { (_, components) ->
                listComponents(
                    components = components,
                    onComponentItemClicked = onComponentItemClicked
                )
                item {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                    )
                }
            }
        }
    }
}

fun LazyListScope.listComponents(
    components: List<Component>,
    onComponentItemClicked: (String) -> Unit,
) {
    itemsIndexed(
        items = components,
        key = { _, component -> component.id }
    ) { index, component ->
        AppListItem(
            title = component.title,
            description = if (component.description != null) stringResource(id = component.description!!) else "",
            icon = Icons.Rounded.Collections,
            onClick = {
                onComponentItemClicked.invoke(component.title)
            },
            shape = when (index) {
                0 -> if (components.size == 1) FullRoundedCornerShape else TopRoundedCornerShape
                components.lastIndex -> BottomRoundedCornerShape
                else -> RoundedCornerShape(0.dp)
            },
            divider = index != components.lastIndex
        )
    }
}
