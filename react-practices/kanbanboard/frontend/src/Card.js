import React, {useState, useEffect} from 'react';
import TaskList from './TaskList';
import {_Card, Card_Title} from './assets/scss/Card.scss';

function Card({no, title, description}) {
    const [isOpen, setIsOpen] = useState(false);
    const [tasks, setTasks] = useState([]);

    //@GetMapping("/card") == @GetMapping("/cards") 
    //@GetMapping("/task") === @GetMapping("/tasks")
    //@PostMapping("/task") === @PostMapping("/tasks")
    //@PutMapping("/task/{no}") === @PutMapping("/tasks/{no}")
    //@DeleteMapping("/task/{no}") === @DeleteMapping("/tasks/{no}")

    //  TODO: get tasks 
    const fetchTaskList = async () => {
        try {
            const response = await fetch(`/api/tasks?no=${no}`, {
                method: 'get',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: null
            });
            console.log(response);

            if(!response.ok) throw new Error(`${response.status} ${response.statusText}`);
            
            const json = await response.json();

            if(json.result !== 'success') {
                throw new Error(json.message);
            }

            console.log(json.data);
            setTasks(json.data);
        } catch(err) {
            console.log(err);
        }
    }
    
    useEffect(() => {
        fetchTaskList();
    }, []);

    //task post 
    const addTask= async (task) => {
        try{
            const response= await fetch('/api/tasks' , {
                method: 'post',
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(task)
            });

            if(!response.ok) throw new Error(`${response.status} ${response.statusText}`);

            const json = await response.json();
            console.log(json);

            if(json.result !== 'success') throw new Error(json.message);

            //삽입 후 상태 업데이트
            console.log(json.data);
            setTasks([...tasks, json.data]);
        } catch(err) {
            console.error(err);
        }
    }

    // task put
    const updateTask = async(task) => {
        try {
            console.log('updateTask' + task);
            const response = await fetch(`/api/tasks/${task.no}`, {
                method: 'put',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(task)
            });

            // const response = await fetch(`/api/tasks`, {
            //     method: 'put',
            //     headers: {
            //         'Accept': 'application/json',
            //         'Content-Type': 'application/json'
            //     },
            //     body: JSON.stringify(task)
            // });

            if(!response.ok) throw new Error(`${response.status} ${response.statusText}`);

            const json = await response.json();
            console.log(json);

            if(json.result !== 'success') throw new Error(json.message);

            console.log(json.data);
            setTasks(tasks.map(t => t.no === task.no? task : t));
            //setTasks(prev => prev.map(v => v.no == task.no ? {...v, done: v.done == 'Y' ? 'N' : 'Y'} : v));
        } catch(err) {
            console.error(err);
        }
    }

    // task delete
    const deleteTask = async(no) => {
        try {
            const response = await fetch(`/api/tasks/${no}`, {
                method: 'delete',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: null
            });

            if(!response.ok) throw new Error(`${response.status} ${response.statusText}`);

            const json = await response.json();
            console.log(json);

            if(json.result!== 'success') throw new Error(json.message);

            console.log(json.data);
            //조건을 만족하는 애만 새로운 배열로 만들어줌 
            setTasks(tasks.filter(t => t.no!== no));
        } catch(err) {
            console.error(err);
        }
    } 

return (
    <div className={_Card}>
        <div 
            className={`${Card_Title} ${isOpen ? 'Card_Title_Open' : ''}`}
            onClick={() => { setIsOpen(!isOpen);}}
        >
            {title}
        </div>
        <div className={'Card_Details'}>{description}</div>
        {isOpen && (
            <TaskList 
                no={no} 
                tasks={tasks} 
                addTask={addTask} 
                updateTask={updateTask} 
                deleteTask={deleteTask} 
            />
        )}
    </div>
);
}

export default Card;