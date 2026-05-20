import { useEffect, useState } from "react";

import api from "../services/api";

import Navbar from "../components/Navbar";

function Dashboard() {

  const [data, setData] =
    useState(null);

  useEffect(() => {

    loadDashboard();

  }, []);

  async function loadDashboard() {

    const response =
      await api.get(
        "/dashboard"
      );

    setData(
      response.data
    );

  }

  if (!data) {

    return <h1>Loading...</h1>

  }

  return (

    <div
      className="
      min-h-screen
      bg-gray-100
      "
    >

      <Navbar />

      <div
        className="
        p-8
        "
      >

        <h1
          className="
          text-4xl
          font-bold
          mb-8
          "
        >

          Dashboard

        </h1>

        <div
          className="
          grid
          grid-cols-2
          md:grid-cols-4
          gap-6
          "
        >

          <Card
            title="Total"
            value={data.totalTasks}
          />

          <Card
            title="Completed"
            value={data.completedTasks}
          />

          <Card
            title="Todo"
            value={data.todoTasks}
          />

          <Card
            title="Overdue"
            value={data.overdueTasks}
          />

        </div>

      </div>

    </div>

  );

}

function Card({title,value}){

function getColor(){

if(title==="Total")
return "bg-blue-500";

if(title==="Completed")
return "bg-green-500";

if(title==="Todo")
return "bg-yellow-500";

if(title==="Overdue")
return "bg-red-500";

return "bg-gray-500";

}

return(

<div
className="
bg-white
rounded-xl
shadow-lg
p-6
hover:scale-105
transition
duration-300
"
>

<div
className={`
${getColor()}
w-4
h-12
rounded-lg
mb-4
`}
>

</div>

<h2
className="
text-gray-500
font-semibold
"
>

{title}

</h2>

<p
className="
text-4xl
font-bold
mt-2
"
>

{value}

</p>

</div>

)

}


export default Dashboard;