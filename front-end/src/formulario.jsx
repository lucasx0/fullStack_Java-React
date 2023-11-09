import React from "react";

export default function Formulario(){
    return(
        <form action="">
            <input type="text"  placeholder="Nome"/>
            <input type="text" placeholder="Marca"/>

            <input type="button" value="Cadastrar" />
            <input type="button" value="Alterar" />
            <input type="button" value="Excluir" />
            <input type="button" value="Cancelar" />
        </form>
    )
}