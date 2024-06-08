package com.bayudevkt.materialandroidfordevelopers.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.bayudevkt.materialandroidfordevelopers.core.ui.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val PoppinsFontFamily = FontFamily(Font(googleFont = GoogleFont("Poppins"), fontProvider = provider))
val RobotoFontFamily = FontFamily(Font(googleFont = GoogleFont("Roboto"), fontProvider = provider))
val MontserratFontFamily = FontFamily(Font(googleFont = GoogleFont("Montserrat"), fontProvider = provider))
val DancingScriptFontFamily = FontFamily(Font(googleFont = GoogleFont("Dancing Script"), fontProvider = provider))

// Default Material 3 typography values
val DefaultTypography = Typography()

val RobotoTypography = Typography(
    displayLarge = DefaultTypography.displayLarge.copy(fontFamily = RobotoFontFamily),
    displayMedium = DefaultTypography.displayMedium.copy(fontFamily = RobotoFontFamily),
    displaySmall = DefaultTypography.displaySmall.copy(fontFamily = RobotoFontFamily),
    headlineLarge = DefaultTypography.headlineLarge.copy(fontFamily = RobotoFontFamily),
    headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = RobotoFontFamily),
    headlineSmall = DefaultTypography.headlineSmall.copy(fontFamily = RobotoFontFamily),
    titleLarge = DefaultTypography.titleLarge.copy(fontFamily = RobotoFontFamily),
    titleMedium = DefaultTypography.titleMedium.copy(fontFamily = RobotoFontFamily),
    titleSmall = DefaultTypography.titleSmall.copy(fontFamily = RobotoFontFamily),
    bodyLarge = DefaultTypography.bodyLarge.copy(fontFamily = RobotoFontFamily),
    bodyMedium = DefaultTypography.bodyMedium.copy(fontFamily = RobotoFontFamily),
    bodySmall = DefaultTypography.bodySmall.copy(fontFamily = RobotoFontFamily),
    labelLarge = DefaultTypography.labelLarge.copy(fontFamily = RobotoFontFamily),
    labelMedium = DefaultTypography.labelMedium.copy(fontFamily = RobotoFontFamily),
    labelSmall = DefaultTypography.labelSmall.copy(fontFamily = RobotoFontFamily)
)

val PoppinsTypography = Typography(
    displayLarge = DefaultTypography.displayLarge.copy(fontFamily = PoppinsFontFamily),
    displayMedium = DefaultTypography.displayMedium.copy(fontFamily = PoppinsFontFamily),
    displaySmall = DefaultTypography.displaySmall.copy(fontFamily = PoppinsFontFamily),
    headlineLarge = DefaultTypography.headlineLarge.copy(fontFamily = PoppinsFontFamily),
    headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = PoppinsFontFamily),
    headlineSmall = DefaultTypography.headlineSmall.copy(fontFamily = PoppinsFontFamily),
    titleLarge = DefaultTypography.titleLarge.copy(fontFamily = PoppinsFontFamily),
    titleMedium = DefaultTypography.titleMedium.copy(fontFamily = PoppinsFontFamily),
    titleSmall = DefaultTypography.titleSmall.copy(fontFamily = PoppinsFontFamily),
    bodyLarge = DefaultTypography.bodyLarge.copy(fontFamily = PoppinsFontFamily),
    bodyMedium = DefaultTypography.bodyMedium.copy(fontFamily = PoppinsFontFamily),
    bodySmall = DefaultTypography.bodySmall.copy(fontFamily = PoppinsFontFamily),
    labelLarge = DefaultTypography.labelLarge.copy(fontFamily = PoppinsFontFamily),
    labelMedium = DefaultTypography.labelMedium.copy(fontFamily = PoppinsFontFamily),
    labelSmall = DefaultTypography.labelSmall.copy(fontFamily = PoppinsFontFamily)
)

val MontserratTypography = Typography(
    displayLarge = DefaultTypography.displayLarge.copy(fontFamily = MontserratFontFamily),
    displayMedium = DefaultTypography.displayMedium.copy(fontFamily = MontserratFontFamily),
    displaySmall = DefaultTypography.displaySmall.copy(fontFamily = MontserratFontFamily),
    headlineLarge = DefaultTypography.headlineLarge.copy(fontFamily = MontserratFontFamily),
    headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = MontserratFontFamily),
    headlineSmall = DefaultTypography.headlineSmall.copy(fontFamily = MontserratFontFamily),
    titleLarge = DefaultTypography.titleLarge.copy(fontFamily = MontserratFontFamily),
    titleMedium = DefaultTypography.titleMedium.copy(fontFamily = MontserratFontFamily),
    titleSmall = DefaultTypography.titleSmall.copy(fontFamily = MontserratFontFamily),
    bodyLarge = DefaultTypography.bodyLarge.copy(fontFamily = MontserratFontFamily),
    bodyMedium = DefaultTypography.bodyMedium.copy(fontFamily = MontserratFontFamily),
    bodySmall = DefaultTypography.bodySmall.copy(fontFamily = MontserratFontFamily),
    labelLarge = DefaultTypography.labelLarge.copy(fontFamily = MontserratFontFamily),
    labelMedium = DefaultTypography.labelMedium.copy(fontFamily = MontserratFontFamily),
    labelSmall = DefaultTypography.labelSmall.copy(fontFamily = MontserratFontFamily)
)

val DancingScriptTypography = Typography(
    displayLarge = DefaultTypography.displayLarge.copy(fontFamily = DancingScriptFontFamily),
    displayMedium = DefaultTypography.displayMedium.copy(fontFamily = DancingScriptFontFamily),
    displaySmall = DefaultTypography.displaySmall.copy(fontFamily = DancingScriptFontFamily),
    headlineLarge = DefaultTypography.headlineLarge.copy(fontFamily = DancingScriptFontFamily),
    headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = DancingScriptFontFamily),
    headlineSmall = DefaultTypography.headlineSmall.copy(fontFamily = DancingScriptFontFamily),
    titleLarge = DefaultTypography.titleLarge.copy(fontFamily = DancingScriptFontFamily),
    titleMedium = DefaultTypography.titleMedium.copy(fontFamily = DancingScriptFontFamily),
    titleSmall = DefaultTypography.titleSmall.copy(fontFamily = DancingScriptFontFamily),
    bodyLarge = DefaultTypography.bodyLarge.copy(fontFamily = DancingScriptFontFamily),
    bodyMedium = DefaultTypography.bodyMedium.copy(fontFamily = DancingScriptFontFamily),
    bodySmall = DefaultTypography.bodySmall.copy(fontFamily = DancingScriptFontFamily),
    labelLarge = DefaultTypography.labelLarge.copy(fontFamily = DancingScriptFontFamily),
    labelMedium = DefaultTypography.labelMedium.copy(fontFamily = DancingScriptFontFamily),
    labelSmall = DefaultTypography.labelSmall.copy(fontFamily = DancingScriptFontFamily)
)