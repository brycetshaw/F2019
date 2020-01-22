
// This class contains a few examples of bad practices in writing software. 
// There are some "Code Smells" here pointing to problems.
// Check these out:
// https://refactoring.guru/smells/long-parameter-list
// https://sourcemaking.com/refactoring/smells/long-method
// https://sourcemaking.com/refactoring/smells/primitive-obsession
// https://sourcemaking.com/refactoring/smells/switch-statements

namespace BestPractices
{

    // How to make sure the functionality of this class is not broken after making changes? Unit testing
    // https://docs.microsoft.com/en-us/dotnet/core/testing/unit-testing-with-dotnet-test
    public class Pizza
    {

        // How many arguments is too many?
        // Is this function doing too much? (Think single responsibility)
        // Do we have to pass all these arguments every time?
        // Can naming of the arguments be more clear?
        ITaxCalculator _taxCalculator;
        public Pizza(ITaxCalculator taxCalculator){
            _taxCalculator = taxCalculator;
        }
        public double CalculatePrice(int numberOfToppings, PriceDefinition priceDefinition)
        {
            

            double price = priceDefinition.BasePrice;

            price = numberOfToppings*priceDefinition.PricePerUnit + price;
            price = _taxCalculator.GetTotalAfterTax(price);

            return price;
        }
    }
}
