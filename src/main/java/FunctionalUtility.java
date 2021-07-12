import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
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
            (drugs, topKyear, s) -> drugs.stream().flatMap(drug->drug.getDrugOrderList().stream()).
                    filter(drugOrder -> drugOrder.getDrug().equals(s)).
                    sorted((getDrug1,getDrug2)->getDrug2.getVisit().getVisitDate().getYear()-get)



}
