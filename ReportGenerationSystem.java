class SalesReport extends Thread {

    @Override
    public void run() {
        System.out.println("Sales Report Generation Started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sales Report Completed");
    }
}

class InventoryReport extends Thread {

    @Override
    public void run() {
        System.out.println("Inventory Report Generation Started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inventory Report Completed");
    }
}

class ProfitReport extends Thread {

    @Override
    public void run() {
        System.out.println("Profit Report Generation Started");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Profit Report Completed");
    }
}

public class ReportGenerationSystem {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread Started");

        SalesReport sales = new SalesReport();
        InventoryReport inventory = new InventoryReport();
        ProfitReport profit = new ProfitReport();

        sales.start();
        inventory.start();
        profit.start();

        sales.join();
        inventory.join();
        profit.join();

        System.out.println("All Reports Completed");

        System.out.println("Main Thread Finished");
    }
}