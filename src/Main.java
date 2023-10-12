import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        InsuranceManager manager = new InsuranceManager();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("1 Receive new application");
            System.out.println("2. View current insurance agreements");
            System.out.println("3. View financial breakdown");
            System.out.println("4. Break insurance agreement");
            System.out.println("5. Move time forward");
            System.out.println("0. Exit");
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