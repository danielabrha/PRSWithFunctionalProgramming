@FunctionalInterface
public interface QuadFunction<P,Q,R,S,T> {
    T apply(P p,Q q,R r,S s);
}
