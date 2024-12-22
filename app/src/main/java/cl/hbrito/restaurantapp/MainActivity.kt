package cl.hbrito.restaurantapp

import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    // Variables para las vistas
    private lateinit var etCantidadPlatillo1: EditText
    private lateinit var tvSubtotalPlatillo1: TextView
    private lateinit var etCantidadPlatillo2: EditText
    private lateinit var tvSubtotalPlatillo2: TextView
    private lateinit var switchPropina: Switch
    private lateinit var tvTotales: TextView

    // Datos del restaurante
    private val pastelChoclo = ItemMenu("Pastel de Choclo", 12000)
    private val cazuela = ItemMenu("Cazuela", 10000)
    private val cuentaMesa = CuentaMesa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajustar los insets para el diseño
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar vistas
        etCantidadPlatillo1 = findViewById(R.id.etCantidadPlatillo1)
        tvSubtotalPlatillo1 = findViewById(R.id.tvSubtotalPlatillo1)
        etCantidadPlatillo2 = findViewById(R.id.etCantidadPlatillo2)
        tvSubtotalPlatillo2 = findViewById(R.id.tvSubtotalPlatillo2)
        switchPropina = findViewById(R.id.switchPropina)
        tvTotales = findViewById(R.id.tvTotales)

        // Configurar datos iniciales
        cuentaMesa.agregarItem(pastelChoclo, 0)
        cuentaMesa.agregarItem(cazuela, 0)

        // Configurar eventos
        configurarEventos()
    }

    private fun configurarEventos() {
        // Evento para cambiar la cantidad del primer platillo
        etCantidadPlatillo1.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                actualizarSubtotalPlatillo1()
                actualizarTotales()
            }
        }

        // Evento para cambiar la cantidad del segundo platillo
        etCantidadPlatillo2.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                actualizarSubtotalPlatillo2()
                actualizarTotales()
            }
        }

        // Evento para activar/desactivar propina
        switchPropina.setOnCheckedChangeListener { _, isChecked ->
            actualizarTotales()
        }
    }

    private fun actualizarSubtotalPlatillo1() {
        // Leer la cantidad del primer platillo ingresada por el usuario
        val cantidad = etCantidadPlatillo1.text.toString().toIntOrNull() ?: 0
        cuentaMesa.obtenerItems()[0].cantidad = cantidad

        // Calcular y mostrar el subtotal
        val subtotal = cuentaMesa.obtenerItems()[0].calcularSubtotal()
        tvSubtotalPlatillo1.text = "Subtotal: ${formatearMoneda(subtotal)}"
    }

    private fun actualizarSubtotalPlatillo2() {
        // Leer la cantidad del segundo platillo ingresada por el usuario
        val cantidad = etCantidadPlatillo2.text.toString().toIntOrNull() ?: 0
        cuentaMesa.obtenerItems()[1].cantidad = cantidad

        // Calcular y mostrar el subtotal
        val subtotal = cuentaMesa.obtenerItems()[1].calcularSubtotal()
        tvSubtotalPlatillo2.text = "Subtotal: ${formatearMoneda(subtotal)}"
    }

    private fun actualizarTotales() {
        // Calcular los totales
        val totalSinPropina = cuentaMesa.calcularTotalSinPropina()
        val propina = if (switchPropina.isChecked) cuentaMesa.calcularPropina() else 0
        val totalConPropina = totalSinPropina + propina

        // Mostrar los totales en el TextView
        tvTotales.text = """
            Total sin propina: ${formatearMoneda(totalSinPropina)}
            Propina: ${formatearMoneda(propina)}
            Total con propina: ${formatearMoneda(totalConPropina)}
        """.trimIndent()
    }

    private fun formatearMoneda(valor: Int): String {
        val formato = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
        return formato.format(valor)
    }
}
