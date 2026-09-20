package gt.edu.umg.finanzapp.domain.model

/**
 * Entidad de dominio que almacena la configuración personal del usuario.
 *
 * ADVERTENCIA DE SEGURIDAD: [passphraseSqlCipher] es sensible y NUNCA debe
 * ser registrada en logs, transmitida por red ni expuesta en la UI.
 *
 * @property id                        Identificador único (fila singleton en Room).
 * @property passphraseSqlCipher       Frase de paso para cifrado AES-256 de la BD.
 * @property notificacionesActivadas   Si el usuario habilitó las notificaciones.
 */
data class ConfiguracionUsuario(
    val id: Int,
    val passphraseSqlCipher: String,
    val notificacionesActivadas: Boolean
)
