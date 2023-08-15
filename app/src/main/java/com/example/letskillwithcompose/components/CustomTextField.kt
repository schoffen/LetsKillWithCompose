package com.example.letskillwithcompose.components

import android.graphics.Outline
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.letskillwithcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LimitTextField(maxCharacter: Int) {
    var name by remember { mutableStateOf("") }

    OutlinedTextField(
        value = name,
        onValueChange = { if (it.length <= maxCharacter) name = it },
        placeholder = { Text(text = "Enter your name") },
        label = { Text(text = "Name") },
        maxLines = 1
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField() {
    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text, onValueChange = { text = it },
        placeholder = { Text("Type here...") },
        shape = MaterialTheme.shapes.medium,
        label = { Text(text = "Telefone") },
        leadingIcon = { Image(imageVector = Icons.Default.Phone, contentDescription = "Name") },
        trailingIcon = {
            if (text.length > 8)
                Image(imageVector = Icons.Default.Check, contentDescription = "Checked")
            else
                Image(imageVector = Icons.Default.Close, contentDescription = "Checked")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = {
                Log.d("Teste", "Ligando...")
            }
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    @DrawableRes
    val iconResId =
        if (passwordVisibility) R.drawable.ic_visibility else R.drawable.ic_visibility_off

    OutlinedTextField(
        value = password, onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Password") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    painter = painterResource(iconResId),
                    contentDescription = "Visibility Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
    )
}