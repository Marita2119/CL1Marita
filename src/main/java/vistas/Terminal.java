package vistas;

import java.util.Scanner;
import com.entidad.Empleado;
import com.repository.EmpleadoInterface;
import com.repository.EmpleadoImplement;

public class Terminal {

    public static void main(String[] args) {
        EmpleadoInterface dao = new EmpleadoImplement();
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Empleados");
            System.out.println("1) Listar Empleados");
            System.out.println("2) Agregar Empleado");
            System.out.println("3) Editar Empleado");
            System.out.println("4) Eliminar Empleado");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Lista de Empleados:");
                    listarEmpleados(dao);
                    break;
                case 2:
                    agregarEmpleado(dao, entrada);
                    break;
                case 3:
                    editarEmpleado(dao, entrada);
                    break;
                case 4:
                    eliminarEmpleado(dao, entrada);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    entrada.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void listarEmpleados(EmpleadoInterface dao) {
        for (Empleado e : dao.listarEmpleados()) {
            System.out.println("ID: " + e.getIdEmpleado());
            System.out.println("Nombre: " + e.getNombres() + " " + e.getApellidos());
            System.out.println("Edad: " + e.getEdad());
            System.out.println("Sexo: " + e.getSexo());
            System.out.println("Salario: " + e.getSalario());
            System.out.println("------------------------------");
        }
    }

    private static void agregarEmpleado(EmpleadoInterface dao, Scanner entrada) {
        System.out.print("Ingrese el Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese el Apellido: ");
        String apellidos = entrada.nextLine();
        System.out.print("Ingrese la Edad: ");
        int edad = entrada.nextInt();
        entrada.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el Sexo (M/F): ");
        String sexo = entrada.nextLine();
        System.out.print("Ingrese el Salario (1500 - 2500): ");
        double salario = entrada.nextDouble();
        entrada.nextLine(); // Limpiar el buffer

        Empleado empleado = new Empleado(apellidos, nombre, edad, sexo, salario);
        dao.agregarEmpleado(empleado);
        System.out.println("Empleado agregado correctamente.");
    }

    private static void editarEmpleado(EmpleadoInterface dao, Scanner entrada) {
        System.out.print("Ingrese el ID del empleado que quiere editar: ");
        int idEditar = entrada.nextInt();
        entrada.nextLine(); // Limpiar el buffer

        Empleado empleadoEditar = dao.obtenerEmpleado(idEditar);

        if (empleadoEditar != null) {
            System.out.print("Ingrese el nuevo Nombre: ");
            String nombreEdit = entrada.nextLine();
            System.out.print("Ingrese el nuevo Apellido: ");
            String apellidosEdit = entrada.nextLine();
            System.out.print("Ingrese la nueva Edad: ");
            int edadEdit = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese el nuevo Sexo (M/F): ");
            String sexoEdit = entrada.nextLine();
            System.out.print("Ingrese el nuevo Salario (1500 - 2500): ");
            double salarioEdit = entrada.nextDouble();

            empleadoEditar.setNombres(nombreEdit);
            empleadoEditar.setApellidos(apellidosEdit);
            empleadoEditar.setEdad(edadEdit);
            empleadoEditar.setSexo(sexoEdit);
            empleadoEditar.setSalario(salarioEdit);

            dao.actualizarEmpleado(empleadoEditar);
            System.out.println("Empleado actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún empleado con ese ID.");
        }
    }

    private static void eliminarEmpleado(EmpleadoInterface dao, Scanner entrada) {
        System.out.print("Ingrese el ID del empleado que va a eliminar: ");
        int idEliminar = entrada.nextInt();
        entrada.nextLine();

        Empleado empleadoEliminar = dao.obtenerEmpleado(idEliminar);

        if (empleadoEliminar != null) {
            dao.eliminarEmpleado(empleadoEliminar);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún empleado con ese ID.");
        }
    }
}
