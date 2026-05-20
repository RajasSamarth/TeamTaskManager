import { useState } from "react";
import api from "../services/api";
import { useNavigate } from "react-router-dom";


function Login() {

  const navigate = useNavigate();

  const [email, setEmail] = useState("");

  const [password, setPassword] = useState("");

  async function login() {

    try {

      const response =
        await api.post(
          "/auth/login",
          {
            email,
            password
          }
        );

      localStorage.setItem(
        "token",
        response.data.token
      );

      navigate("/dashboard");

    }

    catch {

      alert("Invalid Credentials");

    }

  }

  return (

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
          text-4xl
          font-bold
          mb-8
          text-center
          text-blue-700
          "
        >

          Team Task Manager

        </h1>

        <input

          placeholder="Email"

          className="
          border
          w-full
          p-3
          rounded-lg
          mb-4
          "

          onChange={(e) =>
            setEmail(e.target.value)
          }

        />

        <input

          type="password"

          placeholder="Password"

          className="
          border
          w-full
          p-3
          rounded-lg
          mb-6
          "

          onChange={(e) =>
            setPassword(e.target.value)
          }

        />

        <button

          onClick={login}

          className="
          bg-blue-600
          text-white
          w-full
          p-3
          rounded-lg
          hover:bg-blue-700
          "

        >

          Login

        </button>

        <button

        onClick={()=>

        navigate(
        "/signup"
        )

        }

        className="
        mt-4
        text-blue-600
        w-full
        "

        >

        Create Account

        </button>

      </div>

    </div>

  );

}

export default Login;