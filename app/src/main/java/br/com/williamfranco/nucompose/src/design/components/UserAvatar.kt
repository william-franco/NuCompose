package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.williamfranco.nucompose.src.design.theme.white

@Composable
fun UserAvatar() {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary),
    ) {
        Icon(
            imageVector = Icons.Filled.PermIdentity,
            contentDescription = "avatar",
            tint = white,
            modifier = Modifier
                .size(50.dp)
                .padding(horizontal = 10.dp),
        )
    }
}
