package il.co.theblitz.observablecollections.abstracts

import java.io.Serializable
import java.util.concurrent.TransferQueue

open class ObservableTransferQueue<X, Y: TransferQueue<X>>(skipCurrentValueCall: Boolean = false): ObservableBlockingQueue<X, Y>(skipCurrentValueCall), Serializable