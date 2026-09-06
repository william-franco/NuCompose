package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.williamfranco.nucompose.src.design.theme.NuColor01
import br.com.williamfranco.nucompose.src.design.theme.NuColor03
import br.com.williamfranco.nucompose.src.features.home.models.DiscoveryCardItem

@Composable
fun DiscoveryCard(card: DiscoveryCardItem) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .width(240.dp)
            .height(180.dp)
            .background(NuColor03)
            .padding(vertical = 10.dp, horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                    ),
                ) {
                    append("${card.title}\n")
                }
                append(card.description)
            },
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                letterSpacing = (-0.5).sp,
            ),
        )

        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
                containerColor = NuColor01,
            ),
        ) {
            Text(text = card.buttonTitle)
        }
    }
}
