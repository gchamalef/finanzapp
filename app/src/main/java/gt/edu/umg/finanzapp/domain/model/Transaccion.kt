package gt.edu.umg.finanzapp.domain.model

import java.time.LocalDateTime

/**
 * Entidad de dominio que representa una transacción financiera.
 * Los datos transaccionales NUNCA salen del dispositivo (privacidad por diseño).
 *
 * @property id           Identificador único.
 * @property monto        Importe de la transacción (siempre positivo).
 * @property tipo         [TipoTransaccion.INGRESO] o [TipoTransaccion.EGRESO].
 * @property categoriaId  Referencia a la [Categoria] asociada.
 * @property comercio     Nombre del comercio detectado (puede ser nulo).
 * @property fecha        Fecha y hora exacta de la transacción (UTC local).
 * @property origen       Canal de registro: "SMS", "MANUAL", etc.
 * @property nota         Comentario opcional del usuario.
 */
data class Transaccion(
    val id: Int,
    val monto: Double,
    val tipo: TipoTransaccion,
    val categoriaId: Int,
    val comercio: String?,
    val fecha: LocalDateTime,
    val origen: String,
    val nota: String?
)
