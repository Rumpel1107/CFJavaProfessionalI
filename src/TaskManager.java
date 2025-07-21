import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskManager {

	private static final Scanner sc = new Scanner(System.in);
	private static final HashMap<String, Task> mapTask = new HashMap<>();
	private static int priorityAcumulator = 0;

	public static void main(String[] args) {
		int option;

		do {
			showMenu();
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
			case 1 -> addTask();
			case 2 -> showTask();
			case 3 -> searchTask();
			case 4 -> deleteTask();
			case 5 -> showAcumulator();
			case 6 -> System.out.println("Saliendo del programa...");
			default -> System.out.println("Opcion invalida.");
			}
		} while (option != 6);

	}

	private static void showMenu() {
		System.out.println("=== Gestor de Tareas ===");
		System.out.println("1. Agregar tarea.");
		System.out.println("2. Listar tareas.");
		System.out.println("3. Buscar tareas por ID.");
		System.out.println("4. Eliminar tareas por ID.");
		System.out.println("5. Ver total acumulado de prioridades.");
		System.out.println("6. Salir.");
		System.out.println("Elegir una opcion: ");
	}

	private static void addTask() {
		
		System.out.println("ID de la tarea: ");
		String id = sc.nextLine();
				
		if (mapTask.containsKey(id)) {
			System.out.println("Este ID ya fue registrado con otra tarea.");
			return;
		}

		System.out.print("Nombre de la tarea: ");
		String name = sc.nextLine();

		System.out.print("Prioridad (1 a 5); ");
		
		try {
			int priority = Integer.parseInt(sc.nextLine());
			
			if (priority < 1 || priority > 5) {
				System.out.println("Error: Prioridad no valida. Debe ser entre 1 y 5.");
				return;
	        }
		
			Task newTask = new Task(name, priority);
			mapTask.put(id, newTask);
			priorityAcumulator += priority;
			System.out.println("Tarea agregada con exito.");
			System.out.println("Total acumulado de prioridades: " + priorityAcumulator);
			
		} catch (NumberFormatException e) {
	        System.out.println("Error: Debes introducir un número válido para la prioridad.");
        }
	}

	private static void showTask() {
		if (mapTask.isEmpty()) {
			System.out.println("No hay tareas para mostrar.");
			return;
		}

		System.out.println("\n=== Tareas Registradas ===");
		mapTask.forEach((String id, Task task) -> {
			System.out.print("ID: " + id + " - ");
			task.execute();
		});
	}

	private static void searchTask() {
		System.out.println("Ingresa el ID de la tarea a buscar: ");
		String id = sc.nextLine();

		Task t = mapTask.get(id);
		if (t != null) {
			System.out.println("Tarea encontrada: ");
			t.execute();
		} else {
			System.out.println("No se encontro ninguna tarea con ese ID.");
		}
	}

	private static void deleteTask() {
		System.out.println("Ingresar el ID de la tarea a eliminar: ");
		String id = sc.nextLine();

		Task deletedTask = mapTask.remove(id);
		if (deletedTask != null) {
			priorityAcumulator -= deletedTask.getPriority();
			System.out.println("Tarea eliminada correctamente.");
			System.out.println("Total acumulado actualizado: " + priorityAcumulator);
		} else {
			System.out.println("No se encontro ninguna tarea con ese ID.");
		}
	}

	private static void showAcumulator() {
		System.out.println("Acumulador de prioridades: " + priorityAcumulator);
	}
}