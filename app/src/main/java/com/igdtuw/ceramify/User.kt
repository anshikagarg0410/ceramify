package com.igdtuw.ceramify

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(val name: String, val mail: String, val password: String, val username: String)
