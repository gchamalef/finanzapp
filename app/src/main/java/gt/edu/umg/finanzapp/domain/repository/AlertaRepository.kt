package gt.edu.umg.finanzapp.domain.repository

import gt.edu.umg.finanzapp.domain.model.Alerta
import kotlinx.coroutines.flow.Flow

/**
 * Contrato de dominio para acceder y persistir alertas del sistema.
 * La implementación concreta vive en la capa data/ y usa Room + SQLCipher.
 */
interface AlertaRepository {

    /**
     * Emite la lista de alertas que el usuario aún no ha visto, reactivamente.
     * Cada cambio en la base de datos propaga una nueva emisión.
     */
    fun obtenerAlertasNoVistas(): Flow<List<Alerta>>

    /** Persiste una nueva [alerta] en la base de datos local. */
    suspend fun insertarAlerta(alerta: Alerta)

    /** Marca la alerta con el [id] dado como leída. */
    suspend fun marcarAlertaComoVista(id: Int)
}
