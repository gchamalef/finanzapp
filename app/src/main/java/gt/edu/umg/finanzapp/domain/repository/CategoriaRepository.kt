package gt.edu.umg.finanzapp.domain.repository

import gt.edu.umg.finanzapp.domain.model.Categoria
import kotlinx.coroutines.flow.Flow

/**
 * Contrato de dominio para acceder y persistir categorías de transacciones.
 * La implementación concreta vive en la capa data/ y usa Room + SQLCipher.
 */
interface CategoriaRepository {

    /**
     * Emite la lista completa de categorías, reactivamente.
     * Cada cambio en la base de datos propaga una nueva emisión.
     */
    fun obtenerCategorias(): Flow<List<Categoria>>

    /** Persiste una nueva [categoria] en la base de datos local. */
    suspend fun insertarCategoria(categoria: Categoria)
}
