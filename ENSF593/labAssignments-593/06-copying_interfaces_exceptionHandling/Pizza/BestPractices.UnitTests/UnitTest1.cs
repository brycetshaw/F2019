using System;
using Xunit;

namespace BestPractices.UnitTests
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            PriceDefinition priceDefinition = new PriceDefinition() {
                BasePrice = 9,
                PricePerUnit = 1
            };


            Pizza p = new Pizza(new TaxCalculatorFactory().GetCalculator("AB"));
            double total = p.CalculatePrice(2, priceDefinition);
            double expected = 11.55;

            Assert.Equal(expected,total);

        }

        [Fact]
        public void Test2()
        {
            TaxCalculatorFactory taxCalculatorFactory = new TaxCalculatorFactory();
            ITaxCalculator result = taxCalculatorFactory.GetCalculator("AB");
            Assert.IsType<AlbertaTaxCalculator>(result);
        }
    }
}
