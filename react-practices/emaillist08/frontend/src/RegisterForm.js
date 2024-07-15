import React from 'react';
import {_RegisterForm} from './assets/scss/RegisterForm.scss'

function RegisterForm() {
    return (
        <form className={_RegisterForm}>
            <input type='text' name='firstName' placeholder='성' class="InputFirstName" />
            <input type='text' name='lastName' placeholder='이름' class="InputLastName" />
            <input type='text' name='email' placeholder='이메일' class="InputEmail" />
            <input type='submit' value='등록' />
        </form>
    );
}

export default RegisterForm;