package il.co.theblitz.observablecollections.abstracts

abstract class ObservableAbstractSet<X, T : MutableSet<X>> : ObservableAbstractCollection<X, T>(), MutableSet<X> {

}