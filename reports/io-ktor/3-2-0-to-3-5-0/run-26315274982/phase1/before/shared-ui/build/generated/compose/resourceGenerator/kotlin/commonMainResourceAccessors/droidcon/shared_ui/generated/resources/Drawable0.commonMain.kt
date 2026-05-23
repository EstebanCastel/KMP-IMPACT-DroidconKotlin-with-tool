@file:OptIn(InternalResourceApi::class)

package droidcon.shared_ui.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceItem

private const val MD: String = "composeResources/droidcon.shared_ui.generated.resources/"

internal val Res.drawable.venue_map_1: DrawableResource by lazy {
      DrawableResource("drawable:venue_map_1", setOf(
        ResourceItem(setOf(), "${MD}drawable/venue-map-1.jpg", -1, -1),
      ))
    }

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("venue_map_1", Res.drawable.venue_map_1)
}
