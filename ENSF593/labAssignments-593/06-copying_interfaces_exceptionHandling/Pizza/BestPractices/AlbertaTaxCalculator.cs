public class AlbertaTaxCalculator: ITaxCalculator
{
    public double GetTotalAfterTax(double price) {
        NationalTax nationalTax = new NationalTax();
        return price +price*(0 + nationalTax.nationalTax);
    }
}