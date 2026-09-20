package gt.edu.umg.finanzapp.domain.model

/**
 * Entidad de dominio que representa un presupuesto mensual por categoría.
 *
 * @property id           Identificador único.
 * @property categoriaId  Referencia a la [Categoria] asociada.
 * @property montoLimite  Límite de gasto configurado para el mes.
 * @property mesAnio      Período en formato "MM-YYYY" (ej. "09-2026").
 */
data class Presupuesto(
    val id: Int,
    val categoriaId: Int,
    val montoLimite: Double,
    val mesAnio: String
)
