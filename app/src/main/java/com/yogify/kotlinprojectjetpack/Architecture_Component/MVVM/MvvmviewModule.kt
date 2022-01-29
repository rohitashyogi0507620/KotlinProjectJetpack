package com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MvvmviewModule(var repository: ContactRepository) : ViewModel() {

    fun getContact(): LiveData<List<Contact>> {
        return repository.getContacts()
    }

    fun insertContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insetContact(contact)
        }

    }
}