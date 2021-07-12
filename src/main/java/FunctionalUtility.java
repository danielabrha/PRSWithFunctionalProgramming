import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalUtility {
    /*
         top k year that highly ordered M drug
     */


    TriFunction<List<Drug>,Integer,String,List<Integer>> listOfKYearsThatHighlyOrderMDrug=
            (drugs, topKyear, drugName) ->drugs.stream().
                    filter(drug->drug.getDrugName().equals(drugName)).
                    flatMap(drug->drug.getDrugOrderList().stream()).
                    map(drugOrder->drugOrder.getVisit()).

                    collect(Collectors.groupingBy(visit->visit.getVisitDate())).entrySet().stream()

}
