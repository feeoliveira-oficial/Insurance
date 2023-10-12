import java.util.Random;
public class Insurance
{
    private static final double MAX_RISK = 100.0;
    private static final double MIN_RISK = 5.0;
    private static final double MAX_FEE_MULTIPLIER = 20;
    private static final double MIN_FEE_MULTIPLIER = 5;

    private String clientName;
    private double yearlyFee;
    private double risk;
    private double insuranceAmount;

    public Insurance(String clientName)
    {
        this.clientName = clientName;
        Random rand = new Random();

        this.yearlyFee = rand.nextInt(1000) + 500; // example, you can adjust
        this.risk = MIN_RISK + (MAX_RISK - MIN_RISK) * rand.nextDouble();
        double multiplier = MIN_FEE_MULTIPLIER + (MAX_FEE_MULTIPLIER - MIN_FEE_MULTIPLIER) * rand.nextDouble();
        this.insuranceAmount = this.yearlyFee * multiplier;
    }
    @Override
    public String toString()
    {

        var pattern = "| %-13s | $ %14.2f | %-9.2f%% | $ %20.2f |";
        return String.format(pattern,
                clientName,
                yearlyFee,
                risk,
                insuranceAmount
        );
//        return "Client Name: " + clientName + ", Yearly Fee: " + String.format("$ %.2f", yearlyFee) +
//                ", Risk: " + String.format(" %.2f%%",risk) + ", Insurance Amount: " + String.format("$ %.2f",insuranceAmount);
    }
    public double getYearlyFee()
    {
        return yearlyFee;
    }

    public double getRisk()
    {
        return risk;
    }

    public double getInsuranceAmount()
    {
        return insuranceAmount;
    }
}
