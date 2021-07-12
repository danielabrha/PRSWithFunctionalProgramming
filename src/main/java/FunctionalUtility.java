import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalUtility {
    /*
         top k year that highly ordered M drug
     */


    TriFunction<List<Drug>,Integer,String,List<Integer>> listOfKYearsThatHighlyOrderMDrug=
            (drugs, topKyear, s) -> drugs.stream().flatMap(drug->drug.getDrugOrderList().stream()).
                    filter(drugOrder -> drugOrder.getDrug().equals(s)).
                    sorted((getDrug1,getDrug2)->getDrug2.getVisit().getVisitDate().getYear()-get)
}
