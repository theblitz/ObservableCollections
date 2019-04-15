package il.co.theblitz.observablecollections.abstracts

abstract class ObservableSet<X, T : MutableSet<X>> : ObservableCollection<X, T>(), MutableSet<X> {

}