import React from "react";
import {_Searchbar} from './assets/scss/SearchBar.scss';

function SearchBar() {
    return (
        <div className={_Searchbar}>
            <input type='text' placeholder='찾기' />
        </div>
    );
}

export default SearchBar;