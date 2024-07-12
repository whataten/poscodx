import React from 'react';
import RegisterForm from './RegisterForm';
import SearchBar from './SearchBar';
import Emaillist from './Emaillist';
import {_App} from './assets/scss/App.scss';

function App(props) {
    const forms = [
        {name: '둘리', email: 'dooly@gmail.com'},
        {name: '마이콜', email: 'michol@gmail.com'},
        {name: '도우너', email: 'douner@gmail.com'},
        {name: '또치', email: 'ddochi@gmail.com'}
    ];
    
    return (
        <div id={_App}>
            <RegisterForm></RegisterForm>
            <SearchBar></SearchBar>
            <Emaillist forms={forms}></Emaillist>
        </div>
    );
}

export default App;