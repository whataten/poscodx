import React, {useState} from 'react';
import {_Task, Task_Remove} from './assets/scss/Task.scss';

function Task({task, updateTask, deleteTask}) {
    return (
        <li className={_Task}>
            <input 
                type='checkbox' 
                checked= {task.done === 'Y'}
                onChange={() => {
                    updateTask({
                        ...task, 
                        done: task.done === 'Y' ? 'N' : 'Y'
                    })
                }} 
            />
            {task.name}
            <a href='#' className={Task_Remove}
                onClick={e => {
                    e.preventDefault();
                    deleteTask(task.no);
                }}>
            </a>
        </li>
    );
}

export default Task;