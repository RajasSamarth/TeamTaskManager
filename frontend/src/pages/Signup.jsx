import { useState } from "react";

import api from "../services/api";

import { useNavigate } from "react-router-dom";

function Signup(){

const navigate=useNavigate();

const[
name,
setName
]=useState("");

const[
email,
setEmail
]=useState("");

const[
password,
setPassword
]=useState("");

const[
role,
setRole
]=useState("MEMBER");

async function signup(){

try{

await api.post(

"/auth/signup",

{

name,
email,
password,
role

}

);

alert(
"Signup Successful"
);

navigate("/");

}

catch{

alert(
"Signup Failed"
);

}

}

return(

<div
className="
min-h-screen
flex
items-center
justify-center
bg-gradient-to-r
from-blue-700
to-indigo-700
"
>

<div
className="
bg-white
p-10
rounded-2xl
shadow-2xl
w-96
"
>

<h1
className="
text-3xl
font-bold
text-center
text-blue-700
mb-6
"
>

Create Account

</h1>

<input

placeholder="Name"

value={name}

onChange={(e)=>

setName(
e.target.value
)

}

className="
border
w-full
p-3
rounded-lg
mb-4
"

/>

<input

placeholder="Email"

value={email}

onChange={(e)=>

setEmail(
e.target.value
)

}

className="
border
w-full
p-3
rounded-lg
mb-4
"

/>

<input

type="password"

placeholder="Password"

value={password}

onChange={(e)=>

setPassword(
e.target.value
)

}

className="
border
w-full
p-3
rounded-lg
mb-4
"

/>

<select

value={role}

onChange={(e)=>

setRole(
e.target.value
)

}

className="
border
w-full
p-3
rounded-lg
mb-6
"

>

<option>

MEMBER

</option>

<option>

ADMIN

</option>

</select>

<button

onClick={signup}

className="
bg-blue-600
hover:bg-blue-700
text-white
w-full
p-3
rounded-lg
"

>

Signup

</button>

<button

onClick={()=>navigate("/")}

className="
mt-4
text-blue-600
w-full
"

>

Already have account? Login

</button>

</div>

</div>

);

}

export default Signup;