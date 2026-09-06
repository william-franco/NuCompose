package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.williamfranco.nucompose.src.design.theme.NuBackgroundColor01
import br.com.williamfranco.nucompose.src.design.theme.NuColor05
import br.com.williamfranco.nucompose.src.features.home.models.CreditInfo
import br.com.williamfranco.nucompose.src.features.home.models.HIDDEN_AMOUNT

@Composable
fun CreditInfoSection(
    creditInfo: CreditInfo,
    isBalanceVisible: Boolean,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .paddingFromBaseline(
                top = 65.dp,
                bottom = 24.dp,
            ),
    ) {
        Icon(
            ImageVector.vectorResource(id = creditInfo.iconRes),
            contentDescription = creditInfo.title,
            modifier = Modifier
                .size(34.dp)
                .padding(start = 8.dp),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = creditInfo.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                ),
            )
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = null,
                tint = NuBackgroundColor01,
                modifier = Modifier.size(32.dp),
            )
        }
        Text(
            text = creditInfo.subtitle,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            style = TextStyle(
                color = NuColor05,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = (-0.5).sp,
            ),
        )
        Text(
            text = if (isBalanceVisible) creditInfo.amount else HIDDEN_AMOUNT,
            modifier = Modifier
                .padding(top = 2.dp)
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp,
            ),
        )
        Text(
            text = if (isBalanceVisible) {
                creditInfo.footer
            } else {
                "Limite disponível de $HIDDEN_AMOUNT"
            },
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                color = NuColor05,
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = (-0.5).sp,
            ),
        )
    }
}
