public class Usuario {
    int numCuentaBancaria;
    double retiros;
    String user;
    Usuario emisorDinero;
    private double dinero;
    private static String nombreUsuario;

    public Usuario(Cuenta cuenta, String nombreUsuario) {
        this.user = nombreUsuario;
        this.numCuentaBancaria = this.getNumCuentaBancaria();
    }

    public void ingresar(int numeroCuenta) {
        if (existeCuenta(numeroCuenta)) {
            System.out.println("Ingreso exitoso! \n");
        } else {
            System.out.println("No existe la cuenta: " + numeroCuenta + "\n");
            System.exit(-1);
        }
    }

    public void retirar(int numeroCuenta, double cantidad) {
        if (!existenFondos(cantidad)) {
            System.out.println("El valor a retirar no es válido!!" + "\n");
            return;
        }
        retiros += cantidad;
        Cuenta.fondos -= cantidad;
        System.out.println("El retiro a " + user + " es de: " + cantidad);
        System.out.println("El saldo de " + user + " es: " + Cuenta.fondos + "\n");

    }

    public void depositar(int numeroCuenta, double cantidad) {
        if (!existeCuenta(numeroCuenta)) {
            System.out.println("No existe la cuenta: " + numeroCuenta + "\n");
            return;
        }
        Cuenta.fondos += cantidad;
        System.out.println("El saldo inicial " + user + " es: " + Cuenta.fondos + "\n");
    }

    public void imprimir(int numCuentaBancaria) {
        if (!existeCuenta(numCuentaBancaria)) {
            System.out.println("No existe la cuenta: " + numCuentaBancaria + "\n");
            return;
        }
        System.out.println("----------------------------------------------\n" +
                "*\t Nombre de Usuario: " + user + "\n" +
                "*\t Número de cuenta: " + numCuentaBancaria + "\n" +
                "*\t Dinero total disponible: " + Cuenta.fondos + "\n" +
                "*\t Cantidad total de dinero retirado: " + retiros + "\n");
    }

    public void transferir(Usuario emisor, Usuario receptor, double cantidad) {
        this.emisorDinero = emisor;

        if (!existenFondos(cantidad)) {
            System.out.println("El valor a retirar no es válido!!" + "\n");
            return;
        }
        receptor.dinero += cantidad;
        Cuenta.fondos -= cantidad;
        retiros += cantidad;
        System.out.println("Se transfirió " + cantidad + " a " + receptor.user + " desde " + emisor.user + "\n");
    }

    private boolean existenFondos(double cantidad) {
        return (cantidad < getDinero());
    }

    private boolean existeCuenta(int numeroCuenta) {
        return this.getNumCuentaBancaria() == Cuenta.numCuentaBancaria;
    }

    private int getNumCuentaBancaria() {
        return Cuenta.numCuentaBancaria;
    }

    private double getDinero() {
        return Cuenta.fondos;
    }


}


