package com.vogel.nfc_reader.nfc.api

import android.nfc.tech.IsoDep
import com.github.devnied.emvnfccard.parser.EmvTemplate
import com.vogel.nfc_reader.nfc.implementations.ReaderImplementation
import com.vogel.nfc_reader.nfc.model.Card

interface CardReader {
    fun getCardResult(isoDep: IsoDep): Result<Card>

    companion object {
        fun newInstance(): CardReader {
            val config = EmvTemplate.Config()
                .setContactLess(true) // Enable contact less reading
                .setReadAllAids(true) // Read all aids in card
                .setReadTransactions(false) // Read all transactions
                .setRemoveDefaultParsers(false) // Remove default parsers (GeldKarte and Emv)
                .setReadAt(true) //  To extract ATS or ATR
                .setReadCplc(false) // To read CPLC data. Not for contactless cards.

            return ReaderImplementation(
                config = config,
                builder = EmvTemplate.Builder(),
            )
        }
    }
}
