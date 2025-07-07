import java.util.Scanner;

public class TaskManager {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int option;
		int totalPriority = 0;

		do {
			System.out.println("=== Gestor de Tareas ===");
			System.out.println("1. Agregar tarea.");
			System.out.println("2. Ver tareas (WIP)");
			System.out.println("3. Salir.");
			System.out.println("Selecciona una opcion: ");
			option = sc.nextInt();
			sc.nextLine(); //Clean
			
			switch (option) {
			case 1:
				System.out.println("Nombre de la tarea: ");
				String taskName = sc.nextLine();
				
				System.out.println("Prioridad (1 a 5); ");
				int priority = sc.nextInt();
				sc.nextLine();
				
				if (priority >= 1 && priority <= 5) {
					totalPriority += priority; //Priority accumulator
					System.out.println("Tarea agregada: " + taskName + " (prioridad "+ priority);
					System.out.println("Suma total de prioridades: " + totalPriority);
				}
				
				else {
					System.out.println("Prioridad no valida.");
				}
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
		}
		
		while (option !=3);
		
		sc.close();		
		}
		

}