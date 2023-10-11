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
        return "Client Name: " + clientName + ", Yearly Fee: " + yearlyFee +
                ", Risk: " + risk + ", Insurance Amount: " + insuranceAmount;
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
