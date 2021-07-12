import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.stream.Stream;


public class FunctionalUtility {

    /**
     * 1. The number of patients who tested positive for labtest type k on a specific day d?
     * Procedures:
     * First: find the final Lab Result for a specific visit on day d
     * Second: apply (First) for a specific patient for his visits
     * Third: apply (Second) for all patients on that day
     */
    BiFunction<Visit, String, Optional<LabResult>> getLabResult = (v, labTest) ->
            Stream.of(v).flatMap(l->l.getLabOrderList().stream())
            .map(l-> new Tuple<LabTestType, LabResult>(l.getLabTestType(), l.getLabResult()))
            .filter(l->l.getKey().getLabTestName().equals(labTest))
            .map(r->r.getValue())
            .findFirst();


    /*
         top k year that highly ordered M drug
     */


    TriFunction<List<Drug>,Integer,String,List<Integer>> listOfKYearsThatHighlyOrderMDrug=
    (drugs, topKyear, drugName) ->drugs.stream().
                    filter(drug->drug.getDrugName().equals(drugName)).
                    flatMap(drug->drug.getDrugOrderList().stream()).
                    map(drugOrder->drugOrder.getVisit()).map(visit -> visit.getVisitDate().getYear()).
                    collect(Collectors.groupingBy(yr->yr)).entrySet().stream().
                    map(yr->new Tuple<Integer,List<Integer>>(yr.getKey(),yr.getValue())).
                    sorted((t1,t2)->t2.getValue().size()-t2.getValue().size()).
                    limit(topKyear).map(t->t.getKey()).collect(Collectors.toList());


}
