import React from "react";
import EmailForm from "./EmailForm";
import {_Emaillist} from './assets/scss/Emaillist.scss';

function Emaillist({forms}) {
    return (
        <ul className={_Emaillist}>
            {forms.map(t => <EmailForm name={t.name} email={t.email}/>)};
        </ul>
    );
}

export default Emaillist;