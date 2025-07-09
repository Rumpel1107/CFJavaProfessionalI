import java.util.Scanner;

public class TaskManager {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int option;
		int totalPriority = 0;

		do {
			showMenu();
			option = readOption(sc);
			totalPriority = runOption(option, sc, totalPriority);
		} while (option != 3);

		sc.close();
	}

	public static void showMenu() {
		System.out.println("=== Gestor de Tareas ===");
		System.out.println("1. Agregar tarea.");
		System.out.println("2. Ver tareas (WIP)");
		System.out.println("3. Salir.");

	}

	public static int readOption(Scanner sc) {
		System.out.println("Selecciona una opcion: ");
		return sc.nextInt();
	}

	public static int runOption(int option, Scanner sc, int totalPriority)
	{
		sc.nextLine();

		switch (option) {
		case 1:
			totalPriority = addTask(sc, totalPriority);
			break;

		case 2:
			System.out.println("Funcion 'Ver Tareas' aun no se a implementado.");
			break;

		case 3:
			System.out.println("¡Hasta luego!");
			break;
		default:
			System.out.println("Opcion invalida, intenta de nuevo.");
		}

		return totalPriority;
	}

	public static int addTask(Scanner sc, int totalPriority) {
		System.out.println("Nombre de la tarea: ");
		String taskName = sc.nextLine();

		System.out.println("Prioridad (1 a 5); ");
		int priority = sc.nextInt();
		sc.nextLine();

		if (priority >= 1 && priority <= 5) {
			totalPriority += priority;
			System.out.println("Tarea " + taskName + " agregada con prioridad " + priority);
			System.out.println("Suma total de prioridades: " + totalPriority);
		} else {
			System.out.println("Prioridad no valida.");
		}
		
		return totalPriority;

	}

}