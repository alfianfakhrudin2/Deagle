package com.example.deagle.ui

import android.os.Parcel
import android.os.Parcelable

data class LanguageData(
    val title: String,
    val logo: Int,
    val desc: String,
    var isExpandable: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(logo)
        parcel.writeString(desc)
        parcel.writeByte(if (isExpandable) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LanguageData> {
        override fun createFromParcel(parcel: Parcel): LanguageData {
            return LanguageData(parcel)
        }

        override fun newArray(size: Int): Array<LanguageData?> {
            return arrayOfNulls(size)
        }
    }
}