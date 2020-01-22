public class OntarioTaxCalculator: ITaxCalculator
{
    public double GetTotalAfterTax(double price) {
        NationalTax nationalTax = new NationalTax();
        return price +price*(.08 + nationalTax.nationalTax);
    }
}