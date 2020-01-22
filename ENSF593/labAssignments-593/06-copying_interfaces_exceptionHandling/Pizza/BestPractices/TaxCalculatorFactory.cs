using System.Collections.Generic;

public class TaxCalculatorFactory {


    public Dictionary<string, ITaxCalculator> _calculators;

    public TaxCalculatorFactory(){
        _calculators = new Dictionary<string, ITaxCalculator>
        {
            {"AB", new AlbertaTaxCalculator()},
            {"ON", new OntarioTaxCalculator()}
        };
    }

    public ITaxCalculator GetCalculator(string province) {
        return _calculators[province];
    }
}