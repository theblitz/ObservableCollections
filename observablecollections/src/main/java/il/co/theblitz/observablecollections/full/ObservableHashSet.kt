package il.co.theblitz.observablecollections.full

import il.co.theblitz.observablecollections.abstracts.ObservableAbstractSet
import java.io.Serializable

open class ObservableHashSet<X>: ObservableAbstractSet<X, HashSet<X>>(), Serializable {

//    fun spliterator(): Spliterator<X> {
//        return collection.spliterator()
//    }

//    fun clone(): Any {
//        return collection.clone()
//    }

    init {
        collection = HashSet<X>()
    }
}