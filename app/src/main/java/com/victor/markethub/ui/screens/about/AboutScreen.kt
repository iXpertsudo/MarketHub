







package com.victor.markethub.ui.screens.about

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.victor.markethub.navigation.ROUTE_Home
import com.victor.markethub.ui.theme.newOrange2
import com.victor.markethub.ui.theme.newYellow
import kotlin.math.*

// ─────────────────────────────────────────────
//  Colour palette
// ─────────────────────────────────────────────
private val BrandOrange   = Color(0xFFFF6B00)
private val BrandOrangeLt = Color(0xFFFF8C33)
private val BrandAmber    = Color(0xFFFFBB00)
private val DeepDark      = Color(0xFF0D0D0D)
private val SurfaceDark   = Color(0xFF1A1A1A)
private val CardDark      = Color(0xFF242424)
private val TextPrimary   = Color(0xFFF5F5F5)
private val TextSecondary = Color(0xFFAAAAAA)
private val DividerColor  = Color(0xFF2E2E2E)

// ─────────────────────────────────────────────
//  Animated particles canvas
// ─────────────────────────────────────────────
@Composable
private fun ParticleCanvas(modifier: Modifier = Modifier) {
    val inf = rememberInfiniteTransition(label = "particles")
    val t by inf.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(8000, easing = LinearEasing)),
        label = "t"
    )
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val seeds = listOf(
            Pair(0.12f, 0.18f), Pair(0.55f, 0.08f), Pair(0.78f, 0.25f),
            Pair(0.33f, 0.45f), Pair(0.90f, 0.55f), Pair(0.22f, 0.72f),
            Pair(0.65f, 0.80f), Pair(0.48f, 0.62f), Pair(0.05f, 0.90f),
            Pair(0.82f, 0.93f)
        )
        seeds.forEachIndexed { i, (sx, sy) ->
            val phase = (t + i * 0.1f) % 1f
            val x = sx * w + sin(phase * 2 * PI.toFloat() + i) * 30f
            val y = sy * h + cos(phase * 2 * PI.toFloat() + i * 1.3f) * 20f
            val alpha = (sin(phase * 2 * PI.toFloat()) * 0.5f + 0.5f) * 0.35f
            drawCircle(
                color = if (i % 2 == 0) BrandOrange else BrandAmber,
                radius = if (i % 3 == 0) 6f else 4f,
                center = Offset(x, y),
                alpha = alpha
            )
        }
    }
}

// ─────────────────────────────────────────────
//  Animated rings (hero logo backdrop)
// ─────────────────────────────────────────────
@Composable
private fun PulsingRings(modifier: Modifier = Modifier) {
    val inf = rememberInfiniteTransition(label = "rings")
    val scale1 by inf.animateFloat(
        1f, 1.4f,
        infiniteRepeatable(tween(2000, easing = FastOutSlowInEasing), RepeatMode.Reverse),
        label = "s1"
    )
    val scale2 by inf.animateFloat(
        1f, 1.7f,
        infiniteRepeatable(tween(2400, easing = FastOutSlowInEasing, delayMillis = 300), RepeatMode.Reverse),
        label = "s2"
    )
    Canvas(modifier = modifier) {
        val cx = size.width / 2f; val cy = size.height / 2f; val r = 48.dp.toPx()
        drawCircle(BrandOrange, r * scale1, Offset(cx, cy), alpha = 0.15f)
        drawCircle(BrandOrange, r * scale2, Offset(cx, cy), alpha = 0.08f)
    }
}

// ─────────────────────────────────────────────
//  Animated car strip (scrolling cars)
// ─────────────────────────────────────────────
@Composable
private fun CarAnimationStrip() {
    val inf = rememberInfiniteTransition(label = "cars")
    val offset by inf.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(6000, easing = LinearEasing)),
        label = "carOffset"
    )

    val roadHeight = 90.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(roadHeight)
            .background(Color(0xFF111111))
    ) {
        // Road surface
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width; val h = size.height
            // Road lines
            val lineW = 24.dp.toPx(); val gap = 48.dp.toPx()
            val period = lineW + gap
            val startX = -(offset * period)
            var x = startX % period - period
            while (x < w + period) {
                drawRoundRect(
                    color = BrandAmber, alpha = 0.5f,
                    topLeft = Offset(x, h / 2 - 3f),
                    size = Size(lineW, 6f),
                    cornerRadius = CornerRadius(3f)
                )
                x += period
            }
        }

        // Car 1 — orange sports car (moves left to right)
        CarShape(
            modifier = Modifier
                .size(width = 96.dp, height = 40.dp)
                .align(Alignment.CenterStart)
                .offset(x = ((offset * 1.0f) * 600).dp - 96.dp),
            bodyColor = BrandOrange,
            windowColor = Color(0xFF1A3A5C)
        )

        // Car 2 — amber, slightly delayed
        CarShape(
            modifier = Modifier
                .size(width = 80.dp, height = 34.dp)
                .align(Alignment.CenterStart)
                .offset(
                    x = (((offset + 0.45f) % 1f) * 600).dp - 80.dp,
                    y = (-8).dp
                ),
            bodyColor = BrandAmber,
            windowColor = Color(0xFF1A3A5C)
        )

        // Car 3 — white, different speed feel
        CarShape(
            modifier = Modifier
                .size(width = 88.dp, height = 36.dp)
                .align(Alignment.CenterStart)
                .offset(
                    x = (((offset + 0.7f) % 1f) * 600).dp - 88.dp,
                    y = 8.dp
                ),
            bodyColor = Color(0xFFE0E0E0),
            windowColor = Color(0xFF2A5A8C)
        )
    }
}

// ─────────────────────────────────────────────
//  Simple procedural car shape
// ─────────────────────────────────────────────
@Composable
private fun CarShape(
    modifier: Modifier = Modifier,
    bodyColor: Color,
    windowColor: Color
) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        // Body
        drawRoundRect(
            color = bodyColor,
            topLeft = Offset(0f, h * 0.35f),
            size = Size(w, h * 0.55f),
            cornerRadius = CornerRadius(8f)
        )
        // Cabin
        drawRoundRect(
            color = bodyColor.copy(red = (bodyColor.red * 0.85f).coerceIn(0f, 1f),
                green = (bodyColor.green * 0.85f).coerceIn(0f, 1f),
                blue = (bodyColor.blue * 0.85f).coerceIn(0f, 1f)),
            topLeft = Offset(w * 0.25f, h * 0.10f),
            size = Size(w * 0.50f, h * 0.35f),
            cornerRadius = CornerRadius(10f)
        )
        // Windshield
        drawRoundRect(
            color = windowColor, alpha = 0.85f,
            topLeft = Offset(w * 0.28f, h * 0.13f),
            size = Size(w * 0.44f, h * 0.27f),
            cornerRadius = CornerRadius(6f)
        )
        // Wheels
        listOf(w * 0.18f, w * 0.78f).forEach { cx ->
            drawCircle(Color(0xFF111111), h * 0.22f, Offset(cx, h * 0.88f))
            drawCircle(Color(0xFF555555), h * 0.13f, Offset(cx, h * 0.88f))
            drawCircle(Color(0xFF888888), h * 0.05f, Offset(cx, h * 0.88f))
        }
        // Headlight
        drawCircle(BrandAmber, 5f, Offset(w * 0.96f, h * 0.55f), alpha = 0.9f)
        // Tail light
        drawCircle(Color.Red, 4f, Offset(w * 0.04f, h * 0.55f), alpha = 0.7f)
    }
}

// ─────────────────────────────────────────────
//  Stat card
// ─────────────────────────────────────────────
@Composable
private fun StatCard(icon: androidx.compose.ui.graphics.vector.ImageVector, value: String, label: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardDark),
        border = BorderStroke(1.dp, DividerColor),
        modifier = Modifier.width(100.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(icon, contentDescription = null, tint = BrandOrange, modifier = Modifier.size(22.dp))
            Text(value, color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(label, color = TextSecondary, fontSize = 11.sp, textAlign = TextAlign.Center)
        }
    }
}

// ─────────────────────────────────────────────
//  Feature row
// ─────────────────────────────────────────────
@Composable
private fun FeatureItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(CardDark)
            .border(1.dp, DividerColor, RoundedCornerShape(14.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(BrandOrange.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = BrandOrange, modifier = Modifier.size(22.dp))
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(title, color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(description, color = TextSecondary, fontSize = 12.sp, lineHeight = 18.sp)
        }
    }
}

// ─────────────────────────────────────────────
//  Team member card
// ─────────────────────────────────────────────
@Composable
private fun TeamCard(name: String, role: String, initial: String) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardDark),
        border = BorderStroke(1.dp, DividerColor),
        modifier = Modifier.width(110.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(listOf(BrandOrange, BrandAmber))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(initial, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Text(name, color = TextPrimary, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
            Text(role, color = TextSecondary, fontSize = 10.sp, textAlign = TextAlign.Center)
        }
    }
}

// ─────────────────────────────────────────────
//  Section header
// ─────────────────────────────────────────────
@Composable
private fun SectionHeader(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(Brush.verticalGradient(listOf(BrandOrange, BrandAmber)))
        )
        Text(title, color = TextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
    }
}

// ─────────────────────────────────────────────
//  MAIN SCREEN
// ─────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {

    var selectedIndex by remember { mutableStateOf(0) }

    // Entry animation
    val enterAnim = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        enterAnim.animateTo(1f, tween(700, easing = FastOutSlowInEasing))
    }

    Scaffold(
        containerColor = DeepDark,

        // ── TOP BAR ──────────────────────────────
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "MarketHub",
                            color = TextPrimary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "About Us",
                            color = BrandOrange,
                            fontSize = 11.sp,
                            letterSpacing = 2.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = TextPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SurfaceDark,
                    titleContentColor = TextPrimary,
                    navigationIconContentColor = TextPrimary,
                    actionIconContentColor = TextPrimary
                ),
                actions = {
                    IconButton(onClick = { /* share */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share", tint = TextSecondary)
                    }
                }
            )
        },

        // ── BOTTOM BAR ───────────────────────────
        bottomBar = {
            NavigationBar(containerColor = SurfaceDark, tonalElevation = 0.dp) {
                val items = listOf(
                    Triple(Icons.Default.Home, "Home", ROUTE_Home),
                    Triple(Icons.Default.Favorite, "Wishlist", null),
                    Triple(Icons.Default.ShoppingCart, "Cart", null),
                    Triple(Icons.Default.Person, "Profile", null)
                )
                items.forEachIndexed { i, (icon, label, route) ->
                    NavigationBarItem(
                        selected = selectedIndex == i,
                        onClick = {
                            selectedIndex = i
                            route?.let { navController.navigate(it) }
                        },
                        icon = {
                            Icon(
                                icon, contentDescription = label,
                                tint = if (selectedIndex == i) BrandOrange else TextSecondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        label = {
                            Text(
                                label,
                                color = if (selectedIndex == i) BrandOrange else TextSecondary,
                                fontSize = 10.sp
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = BrandOrange.copy(alpha = 0.15f)
                        )
                    )
                }
            }
        },

        // ── FAB ──────────────────────────────────
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* contact */ },
                containerColor = BrandOrange,
                contentColor = Color.White,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(Icons.Default.Email, contentDescription = "Contact Us")
            }
        }

    ) { padding ->

        // ── SCROLLABLE CONTENT ────────────────────
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .graphicsLayer { alpha = enterAnim.value; translationY = (1f - enterAnim.value) * 60f }
        ) {

            // ── HERO SECTION ──────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF1A1000), DeepDark)
                        )
                    )
            ) {
                ParticleCanvas(modifier = Modifier.fillMaxSize())

                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Logo glow ring
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(110.dp)) {
                        PulsingRings(modifier = Modifier.fillMaxSize())
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.radialGradient(listOf(BrandOrangeLt, BrandOrange))
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(38.dp)
                            )
                        }
                    }

                    Text(
                        "MARKETHUB",
                        color = TextPrimary,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 4.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(BrandOrange)
                                .padding(horizontal = 10.dp, vertical = 3.dp)
                        ) {
                            Text("ENTERPRISE", color = Color.White, fontSize = 10.sp,
                                fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                        }
                        Text("v4.2.1", color = TextSecondary, fontSize = 11.sp)
                    }
                }
            }

            // ── CAR ANIMATION STRIP ───────────────
            CarAnimationStrip()

            // ── BODY ──────────────────────────────
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(28.dp)
            ) {

                // ── MISSION ──────────────────────
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = CardDark),
                    border = BorderStroke(1.dp, DividerColor)
                ) {
                    Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = BrandAmber, modifier = Modifier.size(20.dp))
                            Text("Our Mission", color = BrandAmber, fontSize = 13.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                        }
                        Text(
                            "MarketHub is Africa's fastest-growing enterprise eCommerce platform — " +
                                    "connecting millions of buyers and sellers across 54 countries with zero friction. " +
                                    "We power local economies, enable SMEs and enterprises alike, and deliver world-class " +
                                    "shopping experiences through cutting-edge technology.",
                            color = TextSecondary,
                            fontSize = 13.sp,
                            lineHeight = 22.sp
                        )
                    }
                }

                // ── STATS STRIP ───────────────────
                SectionHeader(title = "By The Numbers")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatCard(Icons.Default.Person,   "12M+",  "Active Users")
                    StatCard(Icons.Default.Star,    "340K+", "Merchants")
                    StatCard(Icons.Default.Info, "5M+",   "Products")
                    StatCard(Icons.Default.Star,      "4.9★",  "App Rating")
                }

                // ── FEATURES ─────────────────────
                SectionHeader(title = "Platform Features")
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    FeatureItem(
                        Icons.Default.Settings,
                        "Bank-Grade Security",
                        "End-to-end encryption, 2FA, fraud detection & PCI-DSS Level 1 compliance."
                    )
                    FeatureItem(
                        Icons.Default.Face,
                        "Real-Time Delivery Tracking",
                        "Live GPS tracking, smart routing & automated notifications on every order."
                    )
                    FeatureItem(
                        Icons.Default.AccountBox,
                        "AI-Powered Recommendations",
                        "Machine-learning engines that personalise every customer journey at scale."
                    )
                    FeatureItem(
                        Icons.Default.Person,
                        "Multi-Currency Payments",
                        "M-Pesa, cards, USSD, crypto & 40+ payment methods with instant settlement."
                    )
                    FeatureItem(
                        Icons.Default.Settings,
                        "24/7 Enterprise Support",
                        "Dedicated account managers, 15-min SLA response, and 99.99% uptime SLA."
                    )
                }

                // ── VERSION / BUILD DETAILS ───────
                SectionHeader(title = "App Information")
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = CardDark),
                    border = BorderStroke(1.dp, DividerColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        val details = listOf(
                            Pair("Version",        "4.2.1 (Build 2024112801)"),
                            Pair("Released",       "28 November 2024"),
                            Pair("Platform",       "Android 8.0+  •  API 26+"),
                            Pair("Package",        "com.victor.markethub"),
                            Pair("Framework",      "Jetpack Compose 1.6"),
                            Pair("Backend",        "Kotlin · Spring Boot · GCP"),
                            Pair("Compliance",     "GDPR · CCPA · PCI-DSS L1")
                        )
                        details.forEachIndexed { idx, (k, v) ->
                            if (idx > 0) Divider(color = DividerColor, thickness = 0.5.dp)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(k, color = TextSecondary, fontSize = 12.sp)
                                Text(v, color = TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.End)
                            }
                        }
                    }
                }

                // ── TEAM ─────────────────────────
                SectionHeader(title = "Core Team")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    TeamCard("Victor M.",   "Founder & CEO",     "V")
                    TeamCard("Aisha K.",    "CTO",               "A")
                    TeamCard("James O.",    "Head of Design",    "J")
                    TeamCard("Neema T.",    "Lead Engineer",     "N")
                    TeamCard("Farida B.",   "Head of Growth",    "F")
                }

                // ── SOCIALS ───────────────────────
                SectionHeader(title = "Connect With Us")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    listOf(
                        Pair(Icons.Default.PlayArrow, "Website"),
                        Pair(Icons.Default.Email,    "Email"),
                        Pair(Icons.Default.Phone,    "Support")
                    ).forEach { (icon, label) ->
                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, BrandOrange.copy(alpha = 0.5f)),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPrimary),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(icon, contentDescription = null, tint = BrandOrange, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.height(4.dp))
                                Text(label, fontSize = 11.sp, color = TextSecondary)
                            }
                        }
                    }
                }

                // ── LEGAL FOOTER ──────────────────
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(3.dp)
                            .clip(CircleShape)
                            .background(Brush.horizontalGradient(listOf(BrandOrange, BrandAmber)))
                    )
                    Text(
                        "© 2024 MarketHub Technologies Ltd. All rights reserved.",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text("Privacy Policy", color = BrandOrange, fontSize = 11.sp)
                        Text("Terms of Service", color = BrandOrange, fontSize = 11.sp)
                        Text("Licenses", color = BrandOrange, fontSize = 11.sp)
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    }
}

// ─────────────────────────────────────────────
//  PREVIEW
// ─────────────────────────────────────────────
@Preview(showBackground = true, backgroundColor = 0xFF0D0D0D)
@Composable
fun AboutScreenPreview() {
    AboutScreen(rememberNavController())
}