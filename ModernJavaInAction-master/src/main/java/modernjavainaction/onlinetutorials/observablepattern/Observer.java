package modernjavainaction.onlinetutorials.observablepattern;

public interface Observer<T> {

    void handle(PropertyChangedEventArgs<T> args);

}
