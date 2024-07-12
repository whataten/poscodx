import React from "react";
import {_SearchBar} from './assets/scss/SearchBar.scss';

function SearchBar() {
    return (
        <div className={_SearchBar}>
            <input type='text' placeholder='찾기' />
        </div>
    );
}

export default SearchBar;