package le11;

public interface IObservable {
    void add(IObserver obs);
    void updateChain() throws Exception;
}
