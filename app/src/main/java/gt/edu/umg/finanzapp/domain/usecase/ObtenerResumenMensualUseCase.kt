package gt.edu.umg.finanzapp.domain.usecase

import gt.edu.umg.finanzapp.domain.model.Presupuesto
import gt.edu.umg.finanzapp.domain.model.TipoTransaccion
import gt.edu.umg.finanzapp.domain.model.Transaccion

/**
 * Modelo de resultado del resumen mensual calculado por [ObtenerResumenMensualUseCase].
 *
 * @property totalIngresos            Suma de todos los ingresos del período.
 * @property totalEgresos             Suma de todos los egresos del período.
 * @property desglosePorCategoria     Mapa categoriaId → total gastado/ingresado.
 * @property cumplimientoPorCategoria Mapa categoriaId → porcentaje de uso del presupuesto
 *                                    (0.0 = 0 %, 1.0 = 100 %, >1.0 = excedido).
 */
data class ResumenMensual(
    val totalIngresos: Double,
    val totalEgresos: Double,
    val desglosePorCategoria: Map<Int, Double>,
    val cumplimientoPorCategoria: Map<Int, Double>
)

/**
 * Caso de uso: calcula el resumen financiero mensual a partir de transacciones
 * y presupuestos ya cargados en memoria.
 *
 * No realiza E/S; recibe los datos como parámetros para facilitar las pruebas
 * unitarias con datos sintéticos sin necesidad de mocks de repositorio.
 */
class ObtenerResumenMensualUseCase {

    /**
     * Ejecuta el caso de uso.
     *
     * @param transacciones Lista de [Transaccion] del período a analizar.
     * @param presupuestos  Lista de [Presupuesto] del mismo período.
     * @return [ResumenMensual] con totales y porcentajes de cumplimiento.
     */
    operator fun invoke(
        transacciones: List<Transaccion>,
        presupuestos: List<Presupuesto>
    ): ResumenMensual {
        val totalIngresos = transacciones
            .filter { it.tipo == TipoTransaccion.INGRESO }
            .sumOf { it.monto }

        val totalEgresos = transacciones
            .filter { it.tipo == TipoTransaccion.EGRESO }
            .sumOf { it.monto }

        // Desglose: suma de egresos agrupada por categoría
        val desglosePorCategoria: Map<Int, Double> = transacciones
            .filter { it.tipo == TipoTransaccion.EGRESO }
            .groupBy { it.categoriaId }
            .mapValues { (_, lista) -> lista.sumOf { it.monto } }

        // Cumplimiento: gasto real / límite de presupuesto por categoría
        val cumplimientoPorCategoria: Map<Int, Double> = presupuestos
            .associate { presupuesto ->
                val gastado = desglosePorCategoria[presupuesto.categoriaId] ?: 0.0
                val cumplimiento = if (presupuesto.montoLimite > 0.0) {
                    gastado / presupuesto.montoLimite
                } else {
                    0.0
                }
                presupuesto.categoriaId to cumplimiento
            }

        return ResumenMensual(
            totalIngresos = totalIngresos,
            totalEgresos = totalEgresos,
            desglosePorCategoria = desglosePorCategoria,
            cumplimientoPorCategoria = cumplimientoPorCategoria
        )
    }
}
