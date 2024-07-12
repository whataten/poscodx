import React from "react";
import {_EmailForm} from './assets/scss/EmailForm.scss';

function EmailForm({name, email}) {
    return (
        <li className={_EmailForm}>
            {name}
            <br/>
            {email}
        </li>
    );
}

export default EmailForm;