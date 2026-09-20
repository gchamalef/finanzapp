package gt.edu.umg.finanzapp.domain.usecase

import gt.edu.umg.finanzapp.domain.model.Transaccion
import gt.edu.umg.finanzapp.domain.repository.TransaccionRepository

/**
 * Caso de uso: registra una nueva transacción en la fuente de datos local.
 *
 * Delega directamente en [TransaccionRepository]; en futuras iteraciones
 * podrá agregar validaciones de negocio (monto > 0, categoría existente, etc.).
 *
 * @property transaccionRepo Repositorio de transacciones inyectado por Hilt.
 */
class RegistrarTransaccionUseCase(
    private val transaccionRepo: TransaccionRepository
) {
    /**
     * Ejecuta el caso de uso.
     *
     * @param transaccion Entidad de dominio a persistir.
     */
    suspend operator fun invoke(transaccion: Transaccion) {
        transaccionRepo.insertarTransaccion(transaccion)
    }
}
