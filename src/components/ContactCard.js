import React from 'react'
import user from '../images/user.jpg'

// This functionality is acheived in large scale through use of State

const ContactCard = (props)=> {
    const {id, name, email } = props.contact
    return (
        <div className="item">
            <img className= "ui avatar image" src= {user} alt="user" />
            <div className="content">
                <div className="header">
                    {name}
                </div>
                <div className="header">
                    {email}
                </div>
            </div>
            <i className="trash alternate icon" style ={{color: "red", marginTop: "7px"}}
            onClick={() => { props.clickHandler(id) }}  />
        </div>
    )

}

export default ContactCard