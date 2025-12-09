package com.dudu.LicitratosBackEnd.dtos.noticias;

public record NoticiaRequest(
        String tituloNoticia,
        String textoNoticia,
        String linkNoticia
) {
}
