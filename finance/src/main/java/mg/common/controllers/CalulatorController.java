package mg.common.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
public class CalulatorController {

    private final double MONTHS_IN_YEAR = 12;

    private final double YEAR_RATE = 0.075;

    private final double[] monthRates = new double[]{0.0, 50.0, 70.0, 100.0, 150.0, 200.0, 300.0, 500.0, 700.0, 1000.0};

    private final int[] periodValues = new int[]{0, 3, 6, 9, 12, 24, 36, 60, 84, 108, 120};

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public ModelAndView doCalculations(){
        ModelAndView modelAndView = new ModelAndView();
        List<List<Double>> result = new ArrayList<>();
        for (int i = 0; i < monthRates.length; i++){
            result.add(new ArrayList<>());
            for(int j = 0; j < periodValues.length; j++){
                double lastValue = 0.0;
                for (int k = 0; k < periodValues[j]; k++){
                    lastValue = (YEAR_RATE / MONTHS_IN_YEAR)*(lastValue) + lastValue + monthRates[i];
                }
                result.get(i).add(periodValues[j] == 0 ? monthRates[i] : lastValue);
            }
        }
        modelAndView.addObject("table", result);
        modelAndView.addObject("monthRates", monthRates);
        modelAndView.addObject("periodValues", periodValues);
        modelAndView.setViewName("test/calc");
        return modelAndView;
    }

}
