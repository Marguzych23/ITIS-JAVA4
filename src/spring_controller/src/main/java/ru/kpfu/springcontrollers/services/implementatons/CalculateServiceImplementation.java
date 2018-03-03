package ru.kpfu.springcontrollers.services.implementatons;

import org.springframework.stereotype.Service;
import ru.kpfu.springcontrollers.models.CalculateModel;
import ru.kpfu.springcontrollers.services.interfaces.CalculateService;

@Service("calculateServiceImplementation")
public class CalculateServiceImplementation implements CalculateService {

    public double calculate(CalculateModel calculateModel) {
        double result = 0;

        switch (calculateModel.getMathOperation()) {
            case "addition": {
                result = calculateModel.getFirstNumber() + calculateModel.getSecondNumber();
                break;
            }
            case "subtraction": {
                result = calculateModel.getFirstNumber() - calculateModel.getSecondNumber();
                break;
            }
            case "multiplication": {
                result = calculateModel.getFirstNumber() * calculateModel.getSecondNumber();
                break;
            }
            case "division": {
                if (calculateModel.getSecondNumber() == 0) {
                    throw new IllegalArgumentException("На ноль делить нельзя");
                }
                result = calculateModel.getFirstNumber() / calculateModel.getSecondNumber();
                break;
            }
            default: {
                throw new IllegalArgumentException("Не опознанная операция");
            }
        }

        return result;
    }
}
