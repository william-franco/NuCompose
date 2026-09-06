package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.williamfranco.nucompose.src.design.theme.NuColor02
import br.com.williamfranco.nucompose.src.design.theme.NuColor03
import br.com.williamfranco.nucompose.src.features.home.models.PromoCard

@Composable
fun PromoCardsRow(promoCards: List<PromoCard>) {
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(0)
    }

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(vertical = 10.dp)
            .horizontalScroll(scrollState)
            .padding(bottom = 10.dp),
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        promoCards.forEach { card ->
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(NuColor03)
                    .width(240.dp)
                    .then(
                        if (card.suffix.isEmpty()) Modifier.height(70.dp) else Modifier,
                    )
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    buildAnnotatedString {
                        append(card.prefix)
                        withStyle(style = SpanStyle(color = NuColor02)) {
                            append(card.highlight)
                        }
                        append(card.suffix)
                    },
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 10.dp)
                        .fillMaxSize(),
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        letterSpacing = (-0.5).sp,
                    ),
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}
