package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.williamfranco.nucompose.src.design.theme.white

@Composable
fun IconsTopMenu(
    isBalanceVisible: Boolean,
    onToggleBalanceVisibility: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onToggleBalanceVisibility) {
            Icon(
                imageVector = if (isBalanceVisible) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                },
                contentDescription = if (isBalanceVisible) {
                    "Ocultar saldo"
                } else {
                    "Mostrar saldo"
                },
                tint = white,
                modifier = Modifier.size(28.dp),
            )
        }
        Icon(
            imageVector = Icons.Filled.HelpOutline,
            contentDescription = "Ajuda",
            tint = white,
            modifier = Modifier
                .size(46.dp)
                .padding(horizontal = 10.dp),
        )
        Icon(
            imageVector = Icons.Filled.MailOutline,
            contentDescription = "Mensagens",
            tint = white,
            modifier = Modifier
                .size(46.dp)
                .padding(horizontal = 10.dp),
        )
    }
}
