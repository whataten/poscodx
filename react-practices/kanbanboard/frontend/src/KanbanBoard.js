import React, {useState, useEffect} from 'react';
import CardList from './CardList';
import './assets/scss/kanbanBoard.scss';

function KanbanBoard() {
    const [cards, setCards] = useState([]);
    const fetchCards = async () => {
        try {
            const response = await fetch('/api/cards', {
                method: 'get',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: null
            });
            console.log(response.status);
            
            if (!response.ok) {
                throw new Error(`${response.status} ${response.statusText}`);
            }

            const json = await response.json();

            if(json.result !== 'success') {
                throw new Error(json.message);
            }
            
            console.log(json.data);
            setCards(json.data);
        } catch(err) {
            console.error(err);
        }
    }

    useEffect(()=> {    
        fetchCards();
    }, []);

    return (
        <div className={'Kanban_Board'}>
            <CardList cards={cards.filter(data => ( data.status === "ToDo"))} status={"ToDo"}/>
            <CardList cards={cards.filter(data => ( data.status === "Doing"))} status={"Doing"}/>
            <CardList cards={cards.filter(data => ( data.status === "Done"))} status={"Done"}/>
        </div>
    );
}

export default KanbanBoard;