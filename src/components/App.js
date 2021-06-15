import './App.css'
import React, { useState, useEffect } from 'react'
import Header from './Header'
import ContactList from './ContactList'
import AddContact  from './AddContact'
const uuid = require('uuid').v4

function App() {
  const [contacts, setContacts] = useState([]);
  const LOCAL_STORAGE_KEY = "contacts"
  
    // contact retreived from AddControl.js
  const addContactHandler = (contact) => {
    console.log(contact)
    setContacts([...contacts, { id: uuid(), ...contact }])
  }

  const removeContactHandler = (id) => {
    const newContactList = contacts.filter((contact)=> {return contact.id !== id})
    setContacts(newContactList)
  }


  useEffect(()=> {
    var retreivedContacts = JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY))
    if (retreivedContacts)  
      setContacts(retreivedContacts)
  }, [])

  useEffect(()=> {
    localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(contacts))
  }, [contacts])

  return (
    <div className="ui container" >
      <Header />
      <AddContact addContactHandler={addContactHandler} />
      <ContactList contacts = {contacts} getContactId={removeContactHandler} />
    </div>
  );
}

export default App;

// Resume from useEffects as you wanna keep changes even if you refresh the page
