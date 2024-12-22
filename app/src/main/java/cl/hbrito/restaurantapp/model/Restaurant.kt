package cl.hbrito.restaurantapp

// Clase que representa un platillo del menú
data class ItemMenu(val nombre: String, val precio: Int)

// Clase que representa un item en la mesa (un platillo y su cantidad)
data class ItemMesa(val itemMenu: ItemMenu, var cantidad: Int) {
    // Calcula el subtotal del item (cantidad * precio del platillo)
    fun calcularSubtotal(): Int = cantidad * itemMenu.precio
}

// Clase que gestiona los platillos y totales de la mesa
class CuentaMesa {
    private val _items = mutableListOf<ItemMesa>() // Lista de items en la mesa
    var aceptaPropina: Boolean = true // Define si se aplica propina

    // Agrega un item a la cuenta (un platillo y su cantidad inicial)
    fun agregarItem(itemMenu: ItemMenu, cantidad: Int) {
        _items.add(ItemMesa(itemMenu, cantidad))
    }

    // Obtiene todos los items de la mesa
    fun obtenerItems(): List<ItemMesa> = _items

    // Calcula el total sin incluir propina
    fun calcularTotalSinPropina(): Int = _items.sumOf { it.calcularSubtotal() }

    // Calcula la propina (10% del total sin propina, si aplica)
    fun calcularPropina(): Int = if (aceptaPropina) (calcularTotalSinPropina() * 0.1).toInt() else 0

    // Calcula el total con propina incluida
    fun calcularTotalConPropina(): Int = calcularTotalSinPropina() + calcularPropina()
}
