package gt.edu.umg.finanzapp.domain.usecase

import gt.edu.umg.finanzapp.domain.model.Transaccion
import gt.edu.umg.finanzapp.domain.repository.TransaccionRepository
import kotlinx.coroutines.flow.Flow

/**
 * Caso de uso: obtiene el flujo reactivo de todas las transacciones registradas.
 *
 * @property transaccionRepo Repositorio de transacciones inyectado por Hilt.
 */
class ObtenerTransaccionesUseCase(
    private val transaccionRepo: TransaccionRepository
) {
    /**
     * Ejecuta el caso de uso.
     *
     * @return [Flow] que emite la lista de transacciones ante cada cambio.
     */
    operator fun invoke(): Flow<List<Transaccion>> =
        transaccionRepo.obtenerTransacciones()
}
