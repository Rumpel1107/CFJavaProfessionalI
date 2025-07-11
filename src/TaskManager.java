import java.util.Scanner;

public class TaskManager {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int option;
		int totalPriority = 0;
		Activity lastTask = null; // This will hold the last created task.

		do {
			showMenu();
			option = readOption(sc);
			// We call runOption and receive a 'Result' object back.
			Result result = runOption(option, sc, totalPriority, lastTask);
			// We update our variables with the values from the Result object.
			totalPriority = result.totalPriority;
			lastTask = result.task;

		} while (option != 3);
		
		System.out.println("Cerrando el scanner...");
		sc.close();
	}

	public static void showMenu() {
		clearConsole();
		
		System.out.println("=== Gestor de Tareas ===");
		System.out.println("1. Agregar tarea.");
		System.out.println("2. Ver ultima tarea.");
		System.out.println("3. Salir.");

	}

	public static int readOption(Scanner sc) {
		System.out.println("Selecciona una opcion: ");
		return sc.nextInt();
	}

	public static Result runOption(int option, Scanner sc, int totalPriority, Activity lastTask) {
		sc.nextLine();

		switch (option) {
		case 1:
			// We call addTask and return its result directly.
			return addTask(sc, totalPriority);

		case 2:
			if (lastTask != null) {
				lastTask.run();
			} else {
				System.out.println("Aun no hay tareas registradas.");
			}
			break;

		case 3:
			System.out.println("¡Hasta luego!");
			break;

		default:
			System.out.println("Opcion invalida, intenta de nuevo.");
			break;
		}

		return new Result(totalPriority, lastTask);
	}

	public static Result addTask(Scanner sc, int totalPriority) {
		System.out.print("Nombre de la tarea: ");
		String name = sc.nextLine();

		System.out.print("Prioridad (1 a 5); ");
		int priority = sc.nextInt();
		sc.nextLine();

		if (priority >= 1 && priority <= 5) {
			Task newTask = new Task(name, priority);
			System.out.println("Tarea " + name + " agregada con prioridad " + priority);
			totalPriority += priority;
			System.out.println("Suma total de prioridades: " + totalPriority);
			return new Result(totalPriority, newTask);
		} else {
			System.out.println("Prioridad no valida.");
			return new Result(totalPriority, null);
		}

	}

	public static class Result {
		int totalPriority;
		Activity task;

		public Result(int totalPriority, Activity task) {
			this.totalPriority = totalPriority;
			this.task = task;
		}
	}
	
	public static void clearConsole() {
	    try {
	        String operatingSystem = System.getProperty("os.name"); //Check the current operating system

	        if (operatingSystem.contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            new ProcessBuilder("clear").inheritIO().start().waitFor();
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}