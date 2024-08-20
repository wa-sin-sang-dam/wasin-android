package com.wasin.presentation.router_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wasin.data.model.router.FindAllRouterResponse
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.CompanyImageItem
import com.wasin.presentation._common.ImageMarker
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation._theme.gray_E8E8E8
import com.wasin.presentation._theme.main_green
import com.wasin.presentation._theme.typography
import kotlin.math.roundToInt

@Composable
fun RouterListScreen(
    navController: NavController,
    viewModel: RouterListViewModel = hiltViewModel()
) {
    WithTitle(
        title = "라우터 관리",
        description = "라우터 상태에 따라 원활할 경우 초록색, 불안정할 경우 빨간색으로 나타나요. \n" +
                "마커를 클릭하면 개별 라우터에 대한 상세 정보를 확인 및 편집하고 모니터링을 진행할 수 있어요."
    ) {
        item {
            CompanyImageComponent(
                imageUrl = viewModel.routerListDTO.value.image.companyImage,
                routerList = viewModel.routerListDTO.value.routerList,
                enterImageSize = { viewModel.enterImageSize(it) },
                onClick = { navController.navigate(WasinScreen.RouterDetailScreen.route + "?routerId=${it}") }
            )
        }
        item {
            BlueLongButton(
                text = "라우터 추가",
                onClick = { navController.navigate(WasinScreen.RouterAddScreen.route) }
            )
        }
        item {
            Text(
                text = "Wifi 목록",
                style = typography.titleMedium,
                modifier = Modifier.padding(top = 25.dp)
             )
        }
        items(viewModel.routerListDTO.value.routerList) {
            RouterItemComponent(
                name = it.name,
                state = it.state,
                onClick = { navController.navigate(WasinScreen.RouterDetailScreen.route + "?routerId=${it.routerId}") }
            )
        }
    }
}

@Composable
fun CompanyImageComponent(
    imageUrl: String,
    routerList: List<FindAllRouterResponse.EachRouter> = emptyList(),
    enterImageSize: (Int) -> Unit,
    onClick: (Long) -> Unit
) {
    var localWidth by remember { mutableIntStateOf(0) }

    LaunchedEffect(true) {
        enterImageSize(localWidth)
    }
    Box (
        modifier = Modifier.fillMaxWidth()
    ) {
        CompanyImageItem(
            modifier = Modifier
                .onGloballyPositioned {
                    localWidth = it.size.width
                }
            ,
            imageUrl = imageUrl
        )
        routerList.forEach {
            ImageMarker(
                modifier = Modifier.absoluteOffset {
                    IntOffset(it.positionX.roundToInt(), it.positionY.roundToInt())
                },
                onClick = { onClick(it.routerId) }
            )
        }
    }

}

@Composable
fun RouterItemComponent(
    name: String = "휴게소 Wifi ",
    state: String = "",
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onClick)
            .border(BorderStroke(0.5.dp, gray_E8E8E8), RoundedCornerShape(30.dp))
            .padding(horizontal = 30.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = name,
            style = typography.titleMedium,
        )
        Text(
            text = state,
            style = typography.titleMedium,
            color = main_green
        )
    }
}
