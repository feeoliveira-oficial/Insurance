import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class InsuranceManager
{
    private final ArrayList<Insurance> insurances = new ArrayList<>();
    private final Insurance[] applications = new Insurance[6];
    private double totalMoney = 0;
    private double totalClaimsPaid = 0;
    private double totalCancelledContractsPayments = 0;
    private final Random random = new Random();

    public void receiveApplications()
    {
        for (int i = 0; i < 6; i++)
        {
            String clientName = "Client" + (i + 1);
            applications[i] = new Insurance(clientName);
            System.out.println((i + 1) + ". " + applications[i]);
        }
    }
    public void viewAgreements()
    {
        // Display all current agreements
        for (Insurance insurance : insurances)
        {
            System.out.println(insurance);
        }
    }
    public void acceptApplication(int index)
    {
        if (insurances.size() < 20 && index >= 1 && index <= applications.length)
        {
            Insurance selected = applications[index - 1];
            insurances.add(selected);
            System.out.println("Application accepted for: " + selected);
        }
        else
        {
            System.out.println("Cannot accept more applications");
        }
    }
    public void viewFinancialBreakdown()
    {
        System.out.println("Total Money: " + totalMoney);
        System.out.println("Total Agreements: " + insurances.size());
        System.out.println("Total Claims Paid: " + totalClaimsPaid);
        System.out.println("Total Cancelled Contracts Payments: " + totalCancelledContractsPayments);
        System.out.println("Net Profit: " + (totalMoney - totalClaimsPaid - totalCancelledContractsPayments));
        System.out.println("Average Net Profit: " + (totalMoney - totalClaimsPaid - totalCancelledContractsPayments) / insurances.size());
    }
    public void breakAgreement()
    {
        viewAgreements();
        System.out.println("Select an agreement to break (by index): ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (index >= 0 && index < insurances.size()) {
            Insurance removed = insurances.remove(index);
            double penalty = removed.getYearlyFee() * 10; // costs 10x the annual tax to break an agreement
            totalMoney -= penalty;
            totalCancelledContractsPayments += penalty;
            System.out.println("Broke agreement with: " + removed);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    public void moveTimeForward()
    {
        double moneyEarned = 0;
        double claimsPaid = 0;
        for (Insurance insurance : insurances)
        {
            totalMoney += insurance.getYearlyFee();
            moneyEarned += insurance.getYearlyFee();
            if (random.nextDouble() * 100 < insurance.getRisk())
            {
                totalMoney -= insurance.getInsuranceAmount();
                claimsPaid += insurance.getInsuranceAmount();
                totalClaimsPaid += insurance.getInsuranceAmount();
            }
        }
        System.out.println("Money Earned: " + moneyEarned);
        System.out.println("Claims Paid: " + claimsPaid);
    }
}
