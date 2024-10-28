package com.emmanuel.ldswutilizacindewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.emmanuel.ldswutilizacindewidgets.ui.theme.LDSWUtilizaciónDeWidgetsTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


val typography = Typography(
    displayLarge = TextStyle(fontSize = 30.sp)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LDSWUtilizaciónDeWidgetsTheme {
                AppInterface()
            }
        }
    }
}


@Composable
fun AppInterface() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        //Encabezado con Imagen
        HeaderComposable(
            title = "WIDGETS",
            profileImage = painterResource(id = R.drawable.baseline_person_24),
            name = "Emmanuel Solis",
            initials = "ESR"
        )
        //Seccion con Imagen y Texto
        ImageWithText(
            image = painterResource(id = R.drawable.nave),
            text = "Se avecina la era de los coches voladores"
        )
        //Card con contenido
        ContentCard(
            image = painterResource(id = R.drawable.ic_launcher_foreground),
            title = "Emmanuel Solis",
            description = "Soy estudiante de Licenciatura en desarrollo de sistemas web"
        )
    }
}

@Composable
fun ContentCard(image: Painter, title: String, description: String) {
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            // Imagen con superposicion
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
            ){
                // Imagen de fondo
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagen de fondo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                // Imagen de perfil en superposicion
                Image(
                    painter = image,
                    contentDescription = "Imagen de perfil",
                    modifier = Modifier
                        .size(120.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(8.dp)),
                )
            }

            HeaderTexts(text = title)
            ParraghaphTexts(text = description)
        }
    }
}

@Composable
fun ImageWithText(image: Painter, text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = "coche volador",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        // Overlay sobre la imagen
        Box(
            modifier = Modifier
                .matchParentSize() // Ocupa todo el espacio de la imagen
                .background(Color.Black.copy(alpha = 0.35f))
        )
        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            style = TextStyle(
                color = Color.White,
                fontSize = 36.sp,
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun HeaderComposable(title: String, profileImage: Painter, name: String, initials: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderTitle(title = title)
        ProfileSection(
            profileImage = profileImage, name = name, initials = initials
        )
    }
}

@Composable
fun HeaderTitle(title: String) {
    Text(
        text = title, style = TextStyle(
            fontSize = 24.sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun ProfileSection(profileImage: Painter, name: String, initials: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        ProfileImage(profileImage = profileImage, initials = initials)
        Text(
            text = name, style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun ProfileImage(profileImage: Painter, initials: String) {
    Box(
        modifier = Modifier
            .size(58.dp)
            .clip(CircleShape), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = profileImage, contentDescription = "Perfil", modifier = Modifier.fillMaxSize()
        )
        // Texto encima de la imagen
        Text(
            text = initials, fontWeight = FontWeight.ExtraBold, style = TextStyle(
                color = Color.White, fontSize = 12.sp, fontFamily = FontFamily.Monospace
            ), modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 9.dp)
        )
    }
}

@Composable
fun HeaderTexts(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text, style = typography.displayLarge, modifier = modifier
    )
}

@Composable
fun ParraghaphTexts(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize
) {
    Text(
        text = text, style = TextStyle(fontSize = fontSize), modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    LDSWUtilizaciónDeWidgetsTheme {
        AppInterface()
    }
}
