package Transformation;

import cucumber.api.Transform;
import cucumber.api.Transformer;

public class SalaryCountTransformer extends Transformer<Integer> {

    @Override
    public Integer transform(String salary)
    {
        return salary.length();
    }
}
