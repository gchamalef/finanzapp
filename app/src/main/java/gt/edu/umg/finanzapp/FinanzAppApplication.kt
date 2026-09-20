package gt.edu.umg.finanzapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Punto de entrada de la aplicación.
 * @HiltAndroidApp dispara la generación de código de Hilt en tiempo de compilación
 * (procesado por KSP) y establece el componente raíz del grafo de dependencias.
 */
@HiltAndroidApp
class FinanzAppApplication : Application()
