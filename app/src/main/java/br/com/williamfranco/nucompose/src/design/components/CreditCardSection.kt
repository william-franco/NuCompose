package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.williamfranco.nucompose.src.design.theme.NuColor03
import br.com.williamfranco.nucompose.src.features.home.models.CreditCardInfo

@Composable
fun CreditCardSection(creditCard: CreditCardInfo) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 18.dp)
            .fillMaxSize()
            .padding(bottom = 10.dp),
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(NuColor03)
                .padding(vertical = 8.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                ImageVector.vectorResource(id = creditCard.iconRes),
                contentDescription = creditCard.title,
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 8.dp),
            )
            Text(
                text = creditCard.title,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(start = 10.dp)
                    .fillMaxSize(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = (-0.5).sp,
                ),
            )
        }
    }
}
