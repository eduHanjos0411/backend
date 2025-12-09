package com.dudu.LicitratosBackEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "noticias")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Noticias {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_noticia")
    private UUID id_noticia;

    @Column(name = "titulo_noticia")
    private String titulo_noticia;

    @Column(name = "texto_noticia")
    private String texto_noticia;

    @Column(name = "link_noticia")
    private String link_noticia;
}
