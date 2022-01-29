package com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM

import androidx.lifecycle.LiveData
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.Contact
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.ContactDAO

class ContactRepository(private val conatctdao: ContactDAO) {

    fun getContacts(): LiveData<List<Contact>> {
        return conatctdao.getContact()
    }

    suspend fun insetContact(contact: Contact) {
        conatctdao.insertContact(contact)
    }

}