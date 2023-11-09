import { useState } from 'react'
import './App.css'
import Formulario from './formulario'
import Tabela from './tabela'

function App() {
  const [btnCadastrar, setBtnCadastrar] = useState(true)

  return (
    <div className="App">
      <Formulario botao={btnCadastrar}/>
      <Tabela />
    </div>
  )
}

export default App
