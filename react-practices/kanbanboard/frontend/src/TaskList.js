import React, {useRef} from 'react';
import Task from './Task';
import {Task_List, Input_Add_Task} from './assets/scss/TaskList.scss';

function TaskList({no, tasks, addTask, updateTask, deleteTask}) {
    const inputRef = useRef(null);
    return (
        <div className={Task_List}>
            <ul>
                {/* 주어진 task 개수만큼 반복 -> 리스트에 뿌리기  */}
                {tasks.map(t => 
                {
                    return <Task 
                        key={t.no}
                        task={t}
                        // no ={t.no} 
                        // name={t.name}
                        // done={t.done}
                        updateTask={updateTask}
                        deleteTask={deleteTask}
                    />
                }
                )}
                {/* <Task /> */}
            </ul>
            <input 
                ref={inputRef}
                className={Input_Add_Task} 
                type='text' 
                placeholder='태스크 추가'
                onKeyDown={(t) => {
                    if(t.key==="Enter") {
                        addTask({name:t.target.value, cardNo: no, done:'N'});
                        inputRef.current.value = null; //초기화
                    }
                }} 
            />
        </div>
    );
}

export default TaskList;