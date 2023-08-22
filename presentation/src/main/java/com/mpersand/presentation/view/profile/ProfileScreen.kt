package com.mpersand.presentation.view.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mpersand.gymi_components.component.button.GYMIButton
import com.mpersand.gymi_components.component.card.GYMICard
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcReservation

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(GYMITheme.colors.bg),
        topBar = {
            GYMIHeader(
                navigateToMain = {  },
                navigateToNotice = {  },
                navigationToProfile = {  }
            )
        },
        bottomBar = {
            val navItems = listOf("reservation", "home", "equipment")

            GYMINavBar {
                repeat(3) {
                    GYMINavItem(
                        selected = selected == it,
                        icon = {
                            when (navItems[it]) {
                                "reservation" -> IcReservation(tint = LocalContentColor.current)
                                "home" -> IcHome(tint = LocalContentColor.current)
                                "equipment" -> IcEquipment(tint = LocalContentColor.current)
                            }
                        }
                    ) {
                        selected = it
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp),
                text = "내 프로필",
                style = GYMITheme.typography.h4,
                color = GYMITheme.colors.bw
            )
            MyProfile(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                imageUrl = ""
            )
            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                color = GYMITheme.colors.n3,
                thickness = 1.dp
            )
            Spacer(modifier = modifier.weight(1f))
            RentedEquipmentList(modifier = Modifier.padding(horizontal = 20.dp))
            Spacer(modifier = modifier.weight(1f))
            RentedCourt(modifier = Modifier.padding(horizontal = 20.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                modifier = Modifier.padding(vertical = 20.dp),
                color = GYMITheme.colors.n3,
                thickness = 1.dp
            )
            Spacer(modifier = modifier.weight(1f))
            GYMIButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "로그아웃",
                style = GYMITheme.typography.body2,
                backgroundColor = GYMITheme.colors.error,
                contentPadding = 16.dp,
            ) {

            }
            Spacer(modifier = modifier.height(15.dp))
        }
    }
}

@Composable
fun MyProfile(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "3학년 2반 8번",
                style = GYMITheme.typography.body1,
                color = GYMITheme.colors.bw
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "박성현",
                style = GYMITheme.typography.body1,
                color = GYMITheme.colors.bw
            )
            Text(
                text = "위반 사항 보기",
                style = GYMITheme.typography.body2,
                color = GYMITheme.colors.n3
            )
        }
        Image(
            modifier = Modifier
                .size(85.dp)
                .clip(CircleShape),
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = "profile image"
        )
    }
}

@Composable
fun RentedEquipmentList(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "빌린 기자재",
            style = GYMITheme.typography.subtitle3,
            color = GYMITheme.colors.bw
        )
        Spacer(modifier = Modifier.height(7.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(5) {
                GYMICard(imageUrl = "", text = "요넥스 배드민턴 라켓 1")
            }
        }
    }
}

@Composable
fun RentedCourt(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "빌린 코트",
            style = GYMITheme.typography.subtitle3,
            color = GYMITheme.colors.bw
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "1번 코트",
            style = GYMITheme.typography.body3,
            color = GYMITheme.colors.n3
        )
    }
    Spacer(modifier = Modifier.height(7.dp))
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(8.dp)),
        painter = rememberAsyncImagePainter(model = ""),
        contentDescription = "rented court"
    )
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}