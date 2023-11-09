import { useState } from 'react'
import './App.css'
import Formulario from './formulario'
import Tabela from './tabela'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <Formulario />
      <Tabela />
    </div>
  )
}

export default App
