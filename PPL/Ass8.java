package system;

import java.util.Scanner;

// Thread class
class DeliveryAgent extends Thread {
    private String agentName;
    private String orderName;

    DeliveryAgent(String agentName, String orderName) {
        this.agentName = agentName;
        this.orderName = orderName;
    }

    public void run() {
        System.out.println(agentName + " started delivering " + orderName);

        try {
            Thread.sleep(2000); // simulate delivery time
        } catch (InterruptedException e) {
            System.out.println("Error in delivery");
        }

        System.out.println(agentName + " delivered " + orderName);
    }
}

public class delivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        DeliveryAgent[] agents = new DeliveryAgent[n];

        // Taking input
        for (int i = 0; i < n; i++) {
            System.out.println("\nOrder " + (i + 1));

            System.out.print("Enter Agent Name: ");
            String agent = sc.nextLine();

            System.out.print("Enter Food Order: ");
            String order = sc.nextLine();

            agents[i] = new DeliveryAgent(agent, order);
        }

        // Start all threads
        for (int i = 0; i < n; i++) {
            agents[i].start();
        }

        sc.close();
    }
}
