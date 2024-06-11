package com.example.health_medicare_application.uiactivity

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bedtime
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.health_medicare_application.BottomBar
import com.example.health_medicare_application.TopApplicationBar
import com.example.health_medicare_application.ui.theme.Activityscreen
import com.example.health_medicare_application.ui.theme.Black
import com.example.health_medicare_application.ui.theme.fillmaxwid
import com.example.health_medicare_application.ui.theme.fnt21
import com.example.health_medicare_application.ui.theme.horzcenter
import com.example.health_medicare_application.ui.theme.purple673
import com.example.health_medicare_application.ui.theme.rcshape
import com.example.health_medicare_application.ui.theme.reglogbut
import com.example.health_medicare_application.ui.theme.reglogbuttxtcol
import com.example.health_medicare_application.ui.theme.subtxtcol
import com.example.health_medicare_application.ui.theme.subtxtsize
import com.example.health_medicare_application.ui.theme.txtbold
import com.example.health_medicare_application.ui.theme.txtcenter
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepTrackerPage(navController: NavController)
{
    Scaffold(
        topBar = { TopApplicationBar("Pewaktu Tidur",navController) },
        content = {pad -> SleepTracker(pad) },
        bottomBar = { BottomBar(navController) }
    )
}
@Composable
fun SleepTracker(h:PaddingValues) {
    var start by remember { mutableStateOf(0L) }
    var stop by remember { mutableStateOf(0L) }
    var startstr by remember { mutableStateOf("") }
    var stopstr by remember { mutableStateOf("") }
    var isRunning by remember { mutableStateOf(false) }
    var starten by remember { mutableStateOf(false) }
    var stopen by remember { mutableStateOf(false) }
    var tracken by remember { mutableStateOf(false) }
    val butcolor = ButtonDefaults.buttonColors(purple673)
    Column(
        modifier = Activityscreen,
        horizontalAlignment = horzcenter,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        Text(
            text = "Pantau Waktu Tidurmu",
            fontSize = fnt21,
            fontWeight = txtbold,
            color = Black,
            modifier = fillmaxwid.padding(top = 25.dp),
            textAlign = txtcenter
        )
        Icon(
            imageVector = Icons.Outlined.Bedtime,
            contentDescription = "Sleep",
            tint = purple673,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Biarkan Aplikasi Tetap Terbuka di Latar Belakang",
            fontSize = subtxtsize,
            fontWeight = txtbold,
            color = subtxtcol,
            modifier = fillmaxwid,
            textAlign = txtcenter
        )
        Text(
            text = "'Hari yang Dihabiskan dengan Baik membawa Tidur yang Bahagia' Leonardo da Vinci.",
            fontSize = 16.sp,
            color = Color.Blue,
            fontWeight = txtbold,
            modifier = fillmaxwid,
            textAlign = txtcenter
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = fillmaxwid
        )
        {
            Button(
                onClick = {
                    start = System.currentTimeMillis()
                    isRunning = true
                    starten = true
                },
                modifier = Modifier.width(120.dp),
                colors = butcolor,
                shape = rcshape
            ) {
                Text(
                    text = "Mulai", color = reglogbuttxtcol, fontSize = reglogbut,
                    textAlign = txtcenter
                )
            }
            Button(
                onClick = {
                    stop = System.currentTimeMillis()
                    isRunning = false
                    stopen = true
                },
                modifier = Modifier.width(120.dp),
                colors = butcolor,
                shape = rcshape
            )
            {
                Text(
                    text = "Cukup", color = reglogbuttxtcol, fontSize = reglogbut,
                    textAlign = txtcenter
                )
            }
        }
        startstr = formatDateTime(start)
        stopstr = formatDateTime(stop)
        Button(
            onClick = {
                isRunning = false
                tracken = true
            },
            modifier = fillmaxwid,
            colors = butcolor,
            shape = rcshape
        )
        {
            Text(
                text = "Waktu Tidur", color = reglogbuttxtcol, fontSize = reglogbut,
                textAlign = txtcenter
            )
        }
        if (starten) {
            Row(horizontalArrangement = Arrangement.Center)
            {
                Text(
                    text = "Start : " + startstr,
                    fontSize = 18.sp,
                    fontWeight = txtbold,
                    color = Black
                )
            }
        }
        if (stopen) {
            Row(horizontalArrangement = Arrangement.Center)
            {
                Text(
                    text = "Stop : " + stopstr,
                    fontSize = 18.sp,
                    fontWeight = txtbold,
                    color = Black
                )
            }
        }
        if (tracken) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(bottom = 35.dp)
            )
            {
                Text(
                    text = "Sleep Duration : " + formatTime(stop - start),
                    fontSize = fnt21,
                    fontWeight = txtbold,
                    color = Color.Blue
                )
            }
        }
    }
}
fun formatDateTime(timestamp: Long): String {
    val dateFormat = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss", Locale.getDefault())
    return dateFormat.format(Date(timestamp))
}
fun formatTime(timeInMillis: Long): String {
    val hours = (timeInMillis / (1000 * 60 * 60)) % 24
    val minutes = (timeInMillis / (1000 * 60)) % 60
    val seconds = (timeInMillis / 1000) % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}