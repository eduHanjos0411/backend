package com.dudu.LicitratosBackEnd.dtos.noticias;

import com.dudu.LicitratosBackEnd.entities.Noticias;

public record NoticiaResponse(
        String tituloNoticia
) {

    public NoticiaResponse(Noticias n) {
        this(
                n.getTitulo_noticia()
        );
    }

    public NoticiaResponse(NoticiaRequest nr) {
        this(
                nr.tituloNoticia()
        );
    }
}
