import React from 'react' // = require("react");

class AddContact extends React.Component {
// Props can be passed from parent to child but not the other way round.
// So we can work around this with the help of functions
// The hooks in app.js are reflected in the state

    state = {
        name: "",
        email: "" 
    }

    add = (e) => {
        e.preventDefault();
        if ( this.state.name === "" || this.state.email==="" ) {
            alert(`All Fields are nessecary`)
            return
        }   
        console.log(this.state)
        // Changing the state
        this.props.addContactHandler(this.state)
        // restoring form after adding data
        this.setState({name: "", email: ""})
    }

    render() {
        return (
            <div className="ui main">
                <h2>Add Contact</h2>
                <form className="ui form" onSubmit={this.add}>
                   <div className="field">
                        <label>Name</label>
                        <input type="text"
                         name="name"
                         placeholder="Name"
                         value= {this.state.name}
                         onChange= {
                            (e) => {
                                this.setState({name: e.target.value})
                            }
                        } />
                   </div>
                   <div className="field">
                        <label>Email</label>
                        <input type="email"
                         name="email"
                         placeholder="Email"
                         value= {this.state.email}
                         onChange = {(e)=> {
                             this.setState({email: e.target.value})
                         }}
                         />
                   </div>
                   <button className="ui button blue">Add</button>
                </form>
            </div>
        )
    }

}

export default AddContact