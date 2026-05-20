import { Link, useLocation } from "react-router-dom";

function Navbar(){

const location=useLocation();

function logout(){

localStorage.removeItem("token");
window.location="/";

}

function active(path){

return location.pathname===path
?"bg-white text-blue-600"
:"text-white";

}

return(

<nav
className="
bg-gradient-to-r
from-blue-700
to-indigo-700
shadow-lg
px-8
py-4
flex
justify-between
items-center
"
>

<h1
className="
text-2xl
font-bold
text-white
"
>

Team Task Manager

</h1>

<div
className="
flex
gap-3
items-center
"
>

<Link
to="/dashboard"
className={`px-4 py-2 rounded-lg ${active("/dashboard")}`}
>

Dashboard

</Link>

<Link
to="/projects"
className={`px-4 py-2 rounded-lg ${active("/projects")}`}
>

Projects

</Link>

<Link
to="/tasks"
className={`px-4 py-2 rounded-lg ${active("/tasks")}`}
>

Tasks

</Link>

<button

onClick={logout}

className="
bg-red-500
hover:bg-red-600
px-4
py-2
rounded-lg
transition
"

>

Logout

</button>

</div>

</nav>

);

}

export default Navbar;