import { useEffect, useState } from "react";

import api from "../services/api";

import Navbar from "../components/Navbar";

function Projects(){

const[
projects,
setProjects

]=useState([]);

const[
name,
setName

]=useState("");

const[
description,
setDescription

]=useState("");

useEffect(()=>{

loadProjects();

},[]);

async function loadProjects(){

const response=

await api.get(
"/projects"
);

setProjects(
response.data
);

}

async function createProject(){

if(!name){

alert(
"Enter Project Name"
);

return;

}

await api.post(

"/projects",

{

name,
description

}

);

setName("");

setDescription("");

loadProjects();

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

Projects

</h1>

<div
className="
bg-white
p-6
rounded-xl
shadow-md
mb-8
"
>

<div
className="
grid
md:grid-cols-3
gap-4
"
>

<input

placeholder=
"Project Name"

value={name}

onChange={(e)=>

setName(
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

<button

onClick={
createProject
}

className="
bg-blue-600
hover:bg-blue-700
text-white
rounded-lg
"

>

Create Project

</button>

</div>

</div>

<div
className="
grid
md:grid-cols-2
gap-5
"
>

{

projects.map(

project=>(

<div

key={
project.id
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
text-2xl
mb-2
"
>

{

project.name

}

</h2>

<p
className="
text-gray-600
"
>

{

project.description

}

</p>

</div>

)

)

}

</div>

</div>

</div>

);

}

export default Projects;