package il.co.theblitz.observablecollections.full

import il.co.theblitz.observablecollections.abstracts.ObservableAbstractSet
import java.io.Serializable

open class ObservableLinkedHashSet<X>: ObservableAbstractSet<X, LinkedHashSet<X>>(), Serializable {

    init {
        collection = LinkedHashSet<X>()
    }
}