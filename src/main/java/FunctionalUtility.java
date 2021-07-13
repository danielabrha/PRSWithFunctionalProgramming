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
                    map(drugOrder->drugOrder.getVisit()).map(visit ->
                    visit.getVisitDate().getYear()).
                    collect(Collectors.groupingBy(yr->yr)).entrySet().stream().
                    map(yr->new Tuple<Integer,List<Integer>>(yr.getKey(),yr.getValue())).
                    sorted((t1,t2)->t2.getValue().size()-t2.getValue().size()).
                    limit(topKyear).map(t->t.getKey()).collect(Collectors.toList());


    BiFunction<Visit,String,List<DrugOrder>> listOfDrugOrderWithGivenVisitAndDrugName=(visit, drugName) ->
            Stream.of(visit).
                    flatMap(v->v.getDrugOrderList().stream()).
                    filter(drugOrder ->
                            drugOrder.getDrug().getDrugName().
                                    equals(drugName)).
                    collect(Collectors.toList());



    BiFunction<Visit,String,Long> countTotalDrugOrder=(visit, drugName) ->
            listOfDrugOrderWithGivenVisitAndDrugName.apply(visit,drugName).stream().count();

    BiFunction<Visit,String,Long> totalAmountDrugOrder=(visit, drugName) ->
            listOfDrugOrderWithGivenVisitAndDrugName.
                    apply(visit,drugName).stream().
                    map(drugOrder->drugOrder.getAmount()).
                    reduce(0,(a,b)->a+b).longValue();

    QuadFunction<List<Patient>,String,Integer,Integer,List<Patient>>
            topKPatientWhoTookDrugXMoreThanMAndGreaterThanXinAmount=
        (patients,drugName,times,totalAmount)->patients.stream().
                flatMap(patient -> patient.getVisitList().stream()).
                filter(visit -> countTotalDrugOrder.
                apply(visit,drugName) >=times && totalAmountDrugOrder.
                apply(visit,drugName)>=totalAmount).
                map(v->v.getPatient()).distinct().collect(Collectors.toList());

Function<Patient,Long> noOfVisitPerPatient=patient ->Stream.of(patient).flatMap(p->p.getVisitList().stream()).count();

    TriFunction<List<Patient>,String,Integer,List<String>> listOfSymptoms=
            (patients,topK,fullName) -> patients.stream().
            filter(patient->noOfVisitPerPatient.
            apply(patient)>=2 &&
                    (patient.getfName()+" "+patient.getlName()).equals(fullName)).
            flatMap(patient->patient.getVisitList().stream()).
            flatMap(v->v.getSymptomList().stream()).
            map(s->s.getSymptomName()).
            collect(Collectors.groupingBy(symptom->symptom)).entrySet().stream().
            map(symp->new Tuple<String,List<String>>(symp.getKey(),symp.getValue())).
            sorted((symp1,symp2)->symp2.getValue().size()-symp1.getValue().size()).
                    map(symp->symp.getKey()).limit(topK).collect(Collectors.toList());


}
