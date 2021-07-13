import java.util.List;
import java.util.Locale;
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
    BiFunction<Visit, String, Optional<String>> getLabResult = (visit, labTest) ->
            Stream.of(visit).flatMap(l->l.getLabOrderList().stream())
            .map(l-> new Tuple<LabTestType, LabResult>(l.getLabTestType(), l.getLabResult()))
            .filter(l->l.getKey().getLabTestName().equals(labTest))
            .map(r->r.getValue().getLabResultName())
            .findFirst();

    QuadFunction<Patient, Integer, String, String, Optional<Visit>> findResultPerPatient = (patient, day, labtestType,
                                                                                 labresult) ->
            Stream.of(patient).flatMap(p->p.getVisitList().stream())
            .filter(v->v.getVisitDate().getDayOfMonth() == day)
                    .filter(v->getLabResult.apply(v, labtestType).equals(labresult))
            .findFirst();
    QuadFunction<List<Patient>, Integer, String, String, Long> numberOfPatientsWithResultX = (patients, day,
    labtestType, labresult) ->
            patients.stream().map(p->new Tuple<Patient, Optional<Visit>>(p, findResultPerPatient.apply(p, day,
                    labtestType,
                    labresult)))
            .map(p->p.getKey())
            .count();

    /**
     * 2. Most Common Lab Test Type in a given year
     *
     */
    Function<Visit, List<LabTestType>> getLabTestTypeForVisit = (v) ->
            Stream.of(v).flatMap(l->l.getLabOrderList().stream())
            .map(t->t.getLabTestType())
            .collect(Collectors.toList());

    BiFunction<Patient, Integer, List<Tuple<LabTestType, Integer>>> getLabTestTypeForPatient = (p, year) ->
            Stream.of(p).flatMap(v->v.getVisitList().stream())
            .filter(v->v.getVisitDate().getYear() == year)
            .flatMap(v->getLabTestTypeForVisit.apply(v).stream())
            .collect(Collectors.groupingBy(l->l))
            .entrySet().stream()
            .map(l->new Tuple<LabTestType, Integer>((LabTestType) l.getKey(), (int) l.getValue().stream().count()))
            .collect(Collectors.toList());

    TriFunction<List<Patient>, Integer, Integer, List<LabTestType>> findTopKLabTestTypeInYear = (patients, year, k) ->
            patients.stream().flatMap(p->getLabTestTypeForPatient.apply(p, year).stream())
            .collect(Collectors.groupingBy(l->l.getKey()))
            .entrySet().stream()
            .map(l-> new Tuple<LabTestType, Integer>(l.getKey(), l.getValue().stream().mapToInt(x->x.getValue()).sum()))
            .sorted((t1, t2)->t2.getValue()-t1.getValue())
            .map(t->t.getKey())
            .limit(k)
            .collect(Collectors.toList());

    /**
     * 2. Top K Symptoms in the clinic in a specific year;
     */

    BiFunction<Patient, Integer, List<Symptom>> patientSymptomsInYear = (patient, year) ->
            Stream.of(patient).flatMap(p->p.getVisitList().stream())
            .filter(v->v.getVisitDate().getYear() == year)
            .flatMap(s->s.getSymptomList().stream())
            .collect(Collectors.toList());

    TriFunction<List<Patient>, Integer, Integer, List<String>> topKSymptomsinYear = (patients, year, k) ->
            patients.stream().flatMap(p->patientSymptomsInYear.apply(p, year).stream())
                    .collect(Collectors.groupingBy(s->s))
                    .entrySet().stream()
            .map(s->new Tuple<Symptom, Integer>(s.getKey(), (int)s.getValue().stream().count()))
            .sorted((t1, t2)->(int)(t2.getValue()-t1.getValue()))
            .map(s->s.getKey().getSymptomName())
                    .limit(k)
            .collect(Collectors.toList());

    /**
     * 3. First Names of patients in capital letters and the number of times they took Drug x in a given year
     */
    TriFunction<List<Drug>, String, Integer, List<Tuple<String, Integer>>> averageNumberOfPatients = (drugs, drugName,
                                                                                                year) ->
            drugs.stream().filter(d->d.getDrugName().equals(drugName))
            .flatMap(o->o.getDrugOrderList().stream())
            .map(v->v.getVisit())
            .filter(v->v.getVisitDate().getYear() == year)
            .map(p->p.getPatient())
            .collect(Collectors.groupingBy(p->p))
            .entrySet().stream()
            .map(p->new Tuple<Patient, Integer>(p.getKey(), (int)p.getValue().stream().count()))
            .map(p->new Tuple<String, Integer>(p.getKey().getfName().toUpperCase(), p.getValue()))
            .collect(Collectors.toList());

    /*
         top k year that highly ordered M drug
     */





}
