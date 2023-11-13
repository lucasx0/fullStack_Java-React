import React from "react";

export default function Formulario({botao, eventoTeclado, cadastrar}){
    return(
        <form action="">
            <input type="text" onChange={eventoTeclado} name="nome" placeholder="Nome" className="form-control"/>
            <input type="text" placeholder="Marca" onChange={eventoTeclado} name="marca" className="form-control"/>
            {
                botao
                ?
                <input type="button" value="Cadastrar" className="btn btn-primary" onClick={cadastrar}/>
                :
                <div>

                <input type="button" value="Alterar" className="btn btn-warning"/>
                <input type="button" value="Excluir" className="btn btn-danger"/>
                <input type="button" value="Cancelar" className="btn btn-secondary"/>   
                </div>
            }

      
        </form>
    )
}