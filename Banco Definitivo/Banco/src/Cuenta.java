public class Cuenta {
    public static int numCuentaBancaria;
    public static double fondos;
    String nombreBanco;

    public Cuenta(int numeroCuenta, double fondos, String nombreBanco) {
        Cuenta.numCuentaBancaria = numeroCuenta;
        Cuenta.fondos = fondos;
        this.nombreBanco = nombreBanco;
    }

}
