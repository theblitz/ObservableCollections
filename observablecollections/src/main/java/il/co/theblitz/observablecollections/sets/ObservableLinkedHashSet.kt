package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*
import kotlin.collections.LinkedHashSet

open class ObservableLinkedHashSet<X>: ObservableSet<X, LinkedHashSet<X>>(), Serializable {

    init {
        collection = LinkedHashSet<X>()
    }

}