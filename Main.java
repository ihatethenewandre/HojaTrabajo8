import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######################################################");
        System.out.println("###### SISTEMA DE ATENCION MEDICA POR PRIORIDAD ######");
        System.out.println("######################################################");
        System.out.println("\nPor favor, seleccione una opción:");
        System.out.println("1. Usar PriorityQueue de VectorHeap");
        System.out.println("2. Usar PriorityQueue de JavaCollectionsFramework");
        System.out.print("Ingrese la opción a elegir: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("1".equals(input)) {
            handlePatientsVectorHeap(new VectorHeap<>());
        } else if ("2".equals(input)) {
            handlePatientsJavaCollectionsFramework(new PriorityQueue<>());
        } else {
            System.out.println("\nEntrada no válida. Por favor, intente de nuevo.");
        }
        scanner.close();
    }

    private static void handlePatientsVectorHeap(VectorHeap<Paciente> heap) {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                heap.add(new Paciente(parts[0], parts[1], parts[2].charAt(0)));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        while (!heap.isEmpty()) {
            System.out.println("\nPor favor, seleccione una opción:");
            System.out.println("1. Atender al siguiente paciente");
            System.out.println("2. Salir del sistema");
            System.out.print("Ingrese la opción a elegir: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                Paciente paciente = heap.remove();
                System.out.println("\nAtendiendo a:");
                System.out.println("Nombre: " + paciente.getNombre());
                System.out.println("Descripción Síntoma: " + paciente.getDescripcionSintoma());
                System.out.println("Código Emergencia: " + paciente.getCodigoEmergencia());
            } else if ("2".equals(input)) {
                break;
            } else {
                System.out.println("\nEntrada no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void handlePatientsJavaCollectionsFramework(PriorityQueue<Paciente> queue) {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                queue.add(new Paciente(parts[0], parts[1], parts[2].charAt(0)));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        while (!queue.isEmpty()) {
            System.out.println("\nPor favor, seleccione una opción:");
            System.out.println("1. Atender al siguiente paciente");
            System.out.println("2. Salir del sistema");
            System.out.print("Ingrese la opción a elegir: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                Paciente paciente = queue.remove();
                System.out.println("\nAtendiendo a:");
                System.out.println("Nombre: " + paciente.getNombre());
                System.out.println("Descripción Síntoma: " + paciente.getDescripcionSintoma());
                System.out.println("Código Emergencia: " + paciente.getCodigoEmergencia());
            } else if ("2".equals(input)) {
                break;
            } else {
                System.out.println("\nEntrada no válida. Por favor, intente de nuevo.");
            }
        }
    }
}