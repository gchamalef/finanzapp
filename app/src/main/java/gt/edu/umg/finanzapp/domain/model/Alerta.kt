package gt.edu.umg.finanzapp.domain.model

import java.time.LocalDateTime

/**
 * Entidad de dominio que representa una alerta generada por el sistema.
 *
 * @property id             Identificador único.
 * @property transaccionId  Transacción que originó la alerta (puede ser nula).
 * @property severidad      Nivel de importancia: "INFO", "ADVERTENCIA", "CRITICA".
 * @property mensaje        Texto descriptivo de la alerta para el usuario.
 * @property timestamp      Momento en que se generó la alerta.
 * @property vista          Indica si el usuario ya leyó la alerta.
 */
data class Alerta(
    val id: Int,
    val transaccionId: Int?,
    val severidad: String,
    val mensaje: String,
    val timestamp: LocalDateTime,
    val vista: Boolean
)
