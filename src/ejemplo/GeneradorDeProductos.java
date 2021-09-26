package ejemplo;

import java.util.Random;

class GeneradorDeProductos implements Runnable {
  private Producto[] productos;

  public GeneradorDeProductos(Producto[] productos) {
    this.productos = productos;
  }

  @Override
  public void run() {
    Producto[] productosGenerados = generarCantidadesAleatorias(productos.length);
    for (int i = 0; i < productos.length; i++) {
      productos[i] = productosGenerados[i];
    }
  }

  private static Producto[] generarCantidadesAleatorias(int numeroDeProductos) {
    Random random = new Random();
    // crear arreglo producto con precio
    Producto[] stock = new Producto[numeroDeProductos];
    for (int i = 0; i < numeroDeProductos; i++) {
      Producto producto = new Producto();
      producto.setNombre("Producto #" + (i + 1));
      stock[i] = producto;
    }

    // asignar una cantidad a los productos
    int cantidadTotalProductos = 90_000_0000;
    int productosGenerados = 0;
    while (productosGenerados < cantidadTotalProductos) {
      // determinar posicion del producto aleatorio
      int posicionAleatoria = random.nextInt(numeroDeProductos);
      // determinar cantidad aleatoria a agregar
      int cantidadAAgregar = random.nextInt(10);
      // obteniendo referencia al producto en posicion "posicionAleatoria"
      Producto productoActual = stock[posicionAleatoria];
      productoActual.setCantidad(cantidadAAgregar + productoActual.getCantidad());

      productosGenerados += cantidadAAgregar;
    }
    return stock;
  }
}
