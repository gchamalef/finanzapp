package gt.edu.umg.finanzapp.domain.model

/**
 * Entidad de dominio que representa una categoría de transacciones.
 *
 * @property id        Identificador único de la categoría.
 * @property nombre    Nombre descriptivo (ej. "Alimentación", "Transporte").
 * @property tipo      Clasificación de la categoría según [TipoCategoria].
 */
data class Categoria(
    val id: Int,
    val nombre: String,
    val tipo: TipoCategoria
)
