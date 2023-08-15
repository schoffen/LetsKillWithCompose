package com.example.letskillwithcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.Transformation
import com.example.letskillwithcompose.R

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp), contentAlignment = Alignment.Center
    ) {
        val painter =
            rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = "https://avatars.githubusercontent.com/u/14994036?v=4")
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(1000)
                        error(drawableResId = R.drawable.ic_person)
                        transformations(
                            CircleCropTransformation()
                        )
                    }).build()
            )
        val painterState = painter.state
        Image(
            painter = painter,
            contentDescription = "Logo image"
        )

        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }

    }
}