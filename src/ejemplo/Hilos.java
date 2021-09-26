package ejemplo;

public class Hilos {

  public static void main(String[] args) {
    long comienzo = System.currentTimeMillis();
    int numeroDeProductos = 20;

    Producto[] vectorA = new Producto[numeroDeProductos];
    Producto[] vectorB = new Producto[numeroDeProductos];

    Thread hilo1 = new Thread(new GeneradorDeProductos(vectorA));
    Thread hilo2 = new Thread(new GeneradorDeProductos(vectorB));
    hilo1.start();
    hilo2.start();

    while (hilo1.isAlive() || hilo2.isAlive()) {
    }

    ///.......
    Producto[] vectorC = new Producto[numeroDeProductos];
    for (int i = 0; i < numeroDeProductos; i++) {
      int cantidadA = vectorA[i].getCantidad();
      int cantidadB = vectorB[i].getCantidad();

      //si los valores correspondientes de los vectores A y B son iguales se almacena este mismo
      //valor, si el valor de B es mayor que el de A se almacena el doble de la diferencia entre B y
      //A, si se da el caso de que A es mayor que B, se almacena B
      Producto productoC = new Producto();
      productoC.setNombre("Producto #" + (i + 1));
      if (cantidadA == cantidadB) {
        productoC.setCantidad(cantidadA);
      } else if (cantidadB > cantidadA) {
        productoC.setCantidad(2 * (cantidadB - cantidadA));
      } else {
        productoC.setCantidad(cantidadB);
      }
      vectorC[i] = productoC;
    }

    System.out.println("Vector A");
    imprimirVector(vectorA);
    System.out.println("Vector B");
    imprimirVector(vectorB);
    System.out.println("Vector C");
    imprimirVector(vectorC);

    long finalTiempo = System.currentTimeMillis();
    System.out.println("Se demoro: " + (finalTiempo - comienzo) + "ms");
  }

  private static void imprimirVector(Producto[] vectorC) {
    for (Producto producto : vectorC) {
      System.out.println(producto);
    }
  }
}
