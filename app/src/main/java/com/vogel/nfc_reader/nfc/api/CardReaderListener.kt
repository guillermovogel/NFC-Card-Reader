package com.vogel.nfc_reader.nfc.api

import android.app.Activity
import com.vogel.nfc_reader.nfc.implementations.ListenerImplementation
import com.vogel.nfc_reader.nfc.utils.NFCState
import kotlinx.coroutines.flow.Flow

interface CardReaderListener {
    val nfcStatus: Flow<NFCState>

    fun startReading(activity: Activity)

    fun stopReading(activity: Activity)

    companion object {
        fun newInstance(cardReader: CardReader): CardReaderListener {
            return ListenerImplementation(cardReader)
        }
    }
}
