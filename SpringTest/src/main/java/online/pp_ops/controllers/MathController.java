package online.pp_ops.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.pp_ops.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    //htpp://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    //htpp://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    //htpp://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    //htpp://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2.0;
    }

    //htpp://localhost:8080/math/square/81
    @RequestMapping("/square/{numberOne}")
    public Double square(
        @PathVariable("numberOne") String numberOne
    ) throws Exception {
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(numberOne));
    }



    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {  
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);  
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
