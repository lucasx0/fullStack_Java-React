import { useEffect, useState } from 'react'
import './App.css'
import Formulario from './formulario'
import Tabela from './tabela'

function App() {
  const [btnCadastrar, setBtnCadastrar] = useState(true)
  const [produtos, setProdutos] = useState([])

  //UseEffect
  useEffect(()=>{
    fetch("http://localhost:8080/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setProdutos(retorno_convertido));
  }, []);

  return (
    <div className="App">
      <Formulario botao={btnCadastrar}/>
      <Tabela vetor={produtos}/>
    </div>
  )
}

export default App
