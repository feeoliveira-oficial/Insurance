import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        InsuranceManager manager = new InsuranceManager();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            String pattern = "| %-37s |%n";
            System.out.println("+---------------------------------------+");
            System.out.println("|            MAIN MENU                  |");
            System.out.println("+---------------------------------------+");
            System.out.format(pattern,"1. Receive new application");
            System.out.format(pattern,"2. View current insurance agreements");
            System.out.format(pattern,"3. View financial breakdown");
            System.out.format(pattern,"4. Break insurance agreement");
            System.out.format(pattern,"5. Move time forward");
            System.out.format(pattern,"0. Exit");
            System.out.println("+---------------------------------------+");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    manager.receiveApplications();
                    System.out.println("Select an application to accept (1-6), or 0 to cancel:");
                    int appChoice = scanner.nextInt();
                    if (appChoice >= 1 && appChoice <= 6) {
                        manager.acceptApplication(appChoice);
                    }
                break;
                case 2:
                    manager.viewAgreements();
                    break;
                case 3:
                    manager.viewFinancialBreakdown();
                    break;
                case 4:
                    manager.breakAgreement();
                    break;
                case 5:
                    manager.moveTimeForward();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            }
        }
    }