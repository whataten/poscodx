import React from 'react';
import GroceryItem from './GroceryItem';
import {grocery_list} from './assets/scss/GroceryList.scss';

export default function GroceryList({groceries}) {
    return (
        <ol className={grocery_list}>
            { 
                groceries.map(e => <GroceryItem
                                     key={e.no} 
                                     name={e.name}
                                     count={e.count} />)
            }
        </ol>
    );
}

// export default GroceryList;