import React from 'react';
import './assets/scss/App.scss';

export default function App() {
    return (
        <div className={'App'}>
            <div>
                <ul>
                    {
                        Array.from({length:100}, (_, i) => i + 1).map(e => <li key={e}>{`아이템 ${e}입니다.`}</li>)
                    }
                </ul>
            </div>
        </div>
    );
}