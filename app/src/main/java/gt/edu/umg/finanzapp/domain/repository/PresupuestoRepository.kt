package gt.edu.umg.finanzapp.domain.repository

import gt.edu.umg.finanzapp.domain.model.Presupuesto
import kotlinx.coroutines.flow.Flow

/**
 * Contrato de dominio para acceder y persistir presupuestos mensuales.
 * La implementación concreta vive en la capa data/ y usa Room + SQLCipher.
 */
interface PresupuestoRepository {

    /**
     * Emite los presupuestos del período indicado, reactivamente.
     *
     * @param mesAnio Período en formato "MM-YYYY" (ej. "09-2026").
     */
    fun obtenerPresupuestosDelMes(mesAnio: String): Flow<List<Presupuesto>>

    /** Persiste un nuevo [presupuesto] en la base de datos local. */
    suspend fun insertarPresupuesto(presupuesto: Presupuesto)
}
