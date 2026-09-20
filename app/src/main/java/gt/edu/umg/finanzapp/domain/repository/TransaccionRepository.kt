package gt.edu.umg.finanzapp.domain.repository

import gt.edu.umg.finanzapp.domain.model.Transaccion
import kotlinx.coroutines.flow.Flow

/**
 * Contrato de dominio para acceder y persistir transacciones financieras.
 * La implementación concreta vive en la capa data/ y usa Room + SQLCipher.
 * Los datos NUNCA salen del dispositivo.
 */
interface TransaccionRepository {

    /**
     * Emite la lista completa de transacciones, reactivamente.
     * Cada cambio en la base de datos propaga una nueva emisión.
     */
    fun obtenerTransacciones(): Flow<List<Transaccion>>

    /** Persiste una nueva [transaccion] en la base de datos local. */
    suspend fun insertarTransaccion(transaccion: Transaccion)

    /** Elimina la transacción con el [id] dado de la base de datos local. */
    suspend fun eliminarTransaccion(id: Int)
}
