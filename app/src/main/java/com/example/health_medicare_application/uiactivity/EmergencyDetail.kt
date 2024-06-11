package com.example.health_medicare_application.uiactivity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.health_medicare_application.BottomBar
import com.example.health_medicare_application.R
import com.example.health_medicare_application.TopApplicationBar
import com.example.health_medicare_application.ui.theme.Activityscreen
import com.example.health_medicare_application.ui.theme.fillmaxwid
import com.example.health_medicare_application.ui.theme.fnt20
import com.example.health_medicare_application.ui.theme.fnt21
import com.example.health_medicare_application.ui.theme.iconsize
import com.example.health_medicare_application.ui.theme.purple673
import com.example.health_medicare_application.ui.theme.subtxtcol
import com.example.health_medicare_application.ui.theme.subtxtsize
import com.example.health_medicare_application.ui.theme.txtbold
import com.example.health_medicare_application.ui.theme.vertspace
import com.example.health_medicare_application.ui.theme.wid150

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyContactPage(navController: NavController) {
    Scaffold(
        topBar = { TopApplicationBar(abc = "Daftar Anggota", navController) },
        content = { pad -> EmergencyContactPageInfo(pad) },
        bottomBar = { BottomBar(navController) }
    )
}

@Composable
fun EmergencyContactPageInfo(h: PaddingValues) {
    Column(
        modifier = Activityscreen,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = vertspace,
    ) {
        ContactRow(
            imageRes = R.drawable.yunin, // replace with actual drawable resource
            name = "Yuninda Putri Rahmani (21301241024)"
        )
        ContactRow(
            imageRes = R.drawable.fera, // replace with actual drawable resource
            name = "Indah Ferawati Fajri (21301241025)"
        )
        ContactRow(
            imageRes = R.drawable.imel, // replace with actual drawable resource
            name = "Imelda Niken Sujana (21301241037)"
        )
        ContactRow(
            imageRes = R.drawable.trias, // replace with actual drawable resource
            name = "Triasih Mukti (21301244012)"
        )
        ContactRow(
            imageRes = R.drawable.uti, // replace with actual drawable resource
            name = "Uti Ilmiyatul Aliyah\n(21301244040)"
        )
    }
}

@Composable
fun ContactRow(imageRes: Int, name: String) {
    Row(
        horizontalArrangement = Arrangement.Absolute.Left,
        modifier = fillmaxwid
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Contact Photo",
            modifier = Modifier.size(125.dp).padding(end = 8.dp)
        )
        Text(
            text = name,
            color = subtxtcol,
            fontSize = subtxtsize,
            textAlign = TextAlign.Left,
            fontWeight = txtbold,
            modifier = Modifier.padding(start = 0.dp, top = 37.dp, end = 0.dp, bottom = 0.dp)
        )
    }
}

fun call(number: Int, context: Context) {
    val u = Uri.parse("tel:$number")
    val inten = Intent(Intent.ACTION_DIAL, u)
    try {
        context.startActivity(inten)
    } catch (s: SecurityException) {
        Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT).show()
    }
}

fun message(number: Int, context: Context) {
    val msg = Uri.parse("sms:$number")
    val msginten = Intent(Intent.ACTION_VIEW, msg)
    try {
        context.startActivity(msginten)
    } catch (s: SecurityException) {
        Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT).show()
    }
}
