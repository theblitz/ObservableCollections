package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*

abstract class ObservableSequentialList<X, T: AbstractSequentialList<X>>(skipCurrentValueCall: Boolean = false): Serializable, ObservableList<X, T>(skipCurrentValueCall)