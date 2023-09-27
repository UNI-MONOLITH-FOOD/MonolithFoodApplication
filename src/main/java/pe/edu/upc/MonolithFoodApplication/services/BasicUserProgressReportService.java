package pe.edu.upc.MonolithFoodApplication.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.edu.upc.MonolithFoodApplication.dtos.AverageDailyCaloriesConsumedDTO;
import pe.edu.upc.MonolithFoodApplication.dtos.CaloriesConsumedLastWeekDTO;
import pe.edu.upc.MonolithFoodApplication.repositories.EatRepository;

@Service
@AllArgsConstructor
public class BasicUserProgressReportService {
    private final EatRepository eatRepository;
    //@Autowired
   // private UserRepository userRepository;


    public CaloriesConsumedLastWeekDTO getCaloriesConsumedInTheLastWeek (String username)
    {   
        List<Object[]> results = eatRepository.AveragecaloriesLastWeek(username);
        Object[] firstResult = results.get(0);
        return new CaloriesConsumedLastWeekDTO(
            (String) firstResult[0],
            (Double) firstResult[1]
        );
    }

    public List<AverageDailyCaloriesConsumedDTO> getAverageDailyCaloriesConsumedDTO (String username)
    {   
        List<Object[]> results = eatRepository.AverageCalorieConsumptioDay(username);
        
        List<AverageDailyCaloriesConsumedDTO> averageDailyCaloriesConsumedDTOs = results.stream().map(result ->{
        return new AverageDailyCaloriesConsumedDTO(
            (String) result[0],
            (Timestamp) result[1],
            (Double) result[2]
            );
        }
        ).collect(Collectors.toList());
        return averageDailyCaloriesConsumedDTOs;
    }
}
