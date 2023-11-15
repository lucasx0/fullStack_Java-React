import { useEffect, useState } from 'react'
import './App.css'
import Formulario from './formulario'
import Tabela from './tabela'

function App() {

  //Objeto produto
  const produto = {
    codigo: 0,
    nome: '',
    marca: ''
  }


  const [btnCadastrar, setBtnCadastrar] = useState(true)
  const [produtos, setProdutos] = useState([])
  const [objProduto, setObjProduto] = useState(produto)

  //UseEffect
  useEffect(()=>{
    fetch("http://localhost:8080/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setProdutos(retorno_convertido));
  }, []);

  // Obeter dados do formulario

  const Digitar = (e) =>{
    setObjProduto({...objProduto, [e.target.name] :e.target.value});
  }
  //Cadastrar Produto

  const cadastrar = () => {
    fetch('http://localhost:8080/cadastrar', {
      method: 'post',
      body: JSON.stringify(objProduto),
      headers:{
        'Content-Type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      if(retorno_convertido.mensagem !== undefined){
        alert(retorno_convertido.mensagem)
      }else{
        setProdutos([...produtos, retorno_convertido])
        alert('Cadastro efetuado com Sucesso!')
        limparFormulario();
      }
    })
  }

  //Limpar Formulario

  const limparFormulario = () => {
    setObjProduto(produto)
  }

  return (
    <div className="App">
      
      <Formulario botao={btnCadastrar} eventoTeclado={Digitar} cadastrar={cadastrar} obj={produto}/>
      <Tabela vetor={produtos}/>
    </div>
  )
}

export default App
