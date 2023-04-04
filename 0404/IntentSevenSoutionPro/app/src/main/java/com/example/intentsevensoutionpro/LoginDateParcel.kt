package com.example.intentsevensoutionpro

import android.os.Parcel
import android.os.Parcelable

data class LoginDateParcel(val id: String?, val pwd: String?) : Parcelable{
    //소포열기
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )
    //소포담기
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(pwd)
    }
    //파일 descriptor이면 핸들, 그 이외의것은 0을 준다.
    override fun describeContents(): Int {
        return 0
    }

    //소포만들기
    companion object CREATOR : Parcelable.Creator<LoginDateParcel> {
        //객체용 소포만들기
        override fun createFromParcel(parcel: Parcel): LoginDateParcel {
            return LoginDateParcel(parcel)
        }
        //배열용 소포만들기
        override fun newArray(size: Int): Array<LoginDateParcel?> {
            return arrayOfNulls(size)
        }
    }

}