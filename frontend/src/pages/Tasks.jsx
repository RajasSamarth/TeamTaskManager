import {

useEffect,
useState

}

from "react";

import api
from "../services/api";

import Navbar
from "../components/Navbar";

function Tasks(){

const[
tasks,
setTasks

]=useState([]);

const[
title,
setTitle

]=useState("");

const[
description,
setDescription

]=useState("");

const[
priority,
setPriority

]=useState("MEDIUM");

async function loadTasks(){

const response=

await api.get(
"/tasks/project/1"
);

setTasks(
response.data
);

}

useEffect(()=>{

loadTasks();

},[]);

async function createTask(){

await api.post(

"/tasks",

{

title,

description,

priority,

dueDate:
"2026-05-25",

assignedUserId:1,

projectId:1

}

);

setTitle("");

setDescription("");

loadTasks();

}

return(

<div
className="
min-h-screen
bg-gray-100
"
>

<Navbar/>

<div
className="
p-8
"
>

<h1
className="
text-4xl
font-bold
mb-6
"
>

Tasks

</h1>

<div
className="
bg-white
p-6
rounded-xl
shadow-md
mb-8
grid
md:grid-cols-4
gap-4
"
>

<input

placeholder=
"Task Name"

value={title}

onChange={(e)=>

setTitle(
e.target.value
)

}

className="
border
p-3
rounded-lg
"

/>

<input

placeholder=
"Description"

value={
description
}

onChange={(e)=>

setDescription(
e.target.value
)

}

className="
border
p-3
rounded-lg
"

/>

<select

value={
priority
}

onChange={(e)=>

setPriority(
e.target.value
)

}

className="
border
rounded-lg
"

>

<option>

LOW

</option>

<option>

MEDIUM

</option>

<option>

HIGH

</option>

</select>

<button

onClick={
createTask
}

className="
bg-blue-600
hover:bg-blue-700
text-white
rounded-lg
"

>

Create Task

</button>

</div>

<div
className="
grid
md:grid-cols-2
gap-5
"
>

{

tasks.map(

task=>(

<div

key={
task.id
}

className="
bg-white
p-6
rounded-xl
shadow-md
hover:shadow-xl
transition
"

>

<h2
className="
font-bold
text-xl
"
>

{

task.title

}

</h2>

<p
className="
text-gray-600
mb-3
"
>

{

task.description

}

</p>

<div
className="
flex
gap-3
"
>

<span
className="
bg-blue-100
text-blue-700
px-3
py-1
rounded-full
"
>

{

task.status

}

</span>

<span
className="
bg-red-100
text-red-600
px-3
py-1
rounded-full
"
>

{

task.priority

}

</span>

</div>

</div>

)

)

}

</div>

</div>

</div>

);

}

export default Tasks;