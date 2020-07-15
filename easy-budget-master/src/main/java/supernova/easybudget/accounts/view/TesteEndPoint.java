package supernova.easybudget.accounts.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@RestController
public class TesteEndPoint {

    @GetMapping("/teste")
    public int teste() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        return numbers.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    @GetMapping("/teste2")
    public String teste2(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        String results = numbers.stream()
                .filter(i -> i % 2 == 1)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return results;
    }

}
