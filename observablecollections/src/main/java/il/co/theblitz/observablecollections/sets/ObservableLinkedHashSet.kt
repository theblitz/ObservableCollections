package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*
import kotlin.collections.LinkedHashSet

open class ObservableLinkedHashSet<X>(skipCurrentValueCall: Boolean = false): ObservableSet<X, LinkedHashSet<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = LinkedHashSet<X>()
    }

}