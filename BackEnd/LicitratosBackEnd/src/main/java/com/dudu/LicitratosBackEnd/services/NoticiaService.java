package com.dudu.LicitratosBackEnd.services;

import com.dudu.LicitratosBackEnd.dtos.noticias.NoticiaRequest;
import com.dudu.LicitratosBackEnd.dtos.noticias.NoticiaResponse;
import com.dudu.LicitratosBackEnd.entities.Noticias;
import com.dudu.LicitratosBackEnd.repositories.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoticiaService {

    private final NoticiaRepository nRepo;

    public NoticiaService(NoticiaRepository nRepo) {
        this.nRepo = nRepo;
    }

    public NoticiaResponse novaNoticia(NoticiaRequest nr) {
        Noticias novaNoticia = new Noticias();
        novaNoticia.setTitulo_noticia(nr.tituloNoticia());
        novaNoticia.setTexto_noticia(nr.textoNoticia());
        novaNoticia.setLink_noticia(nr.linkNoticia());
        nRepo.save(novaNoticia);

        return new NoticiaResponse(nr);
    }

    public List<NoticiaResponse> listarNoticias() {
        return nRepo.findAll().stream().map(NoticiaResponse::new).toList();
    }

    public void excluirNoticias(UUID id) {
        nRepo.deleteById(id);
    }
}
