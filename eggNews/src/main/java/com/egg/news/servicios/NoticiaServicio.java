package com.egg.news.servicios;

import com.egg.news.entidades.Noticia;
import com.egg.news.excepciones.MiException;
import com.egg.news.repositorios.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public Noticia consultarNoticia() {
        return null;
    }

    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws MiException {

        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El titulo de la noticia no puede ser nulo o estar vacio");
        }
        if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("El cuerpo de la noticia no puede ser nulo o estar vacio");
        }

        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setFecha(new Date());
        noticiaRepositorio.save(noticia);

    }

    @Transactional
    public void modificarNoticia(String id, String titulo, String cuerpo) throws MiException {
        validarNoticia(titulo, cuerpo, id);
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();

            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);

            noticiaRepositorio.save(noticia);
        }
    }

    @Transactional
    public void bajaNoticia(String id) throws MiException {
        if (id.isEmpty() || id == null) {
            throw new MiException("El ID de la noticia no puede ser nulo o estar vacio");
        }
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            noticiaRepositorio.delete(respuesta.get());
        }
    }

    public List<Noticia> listarNoticias() {
        List<Noticia> noticias = new ArrayList();
        noticias = noticiaRepositorio.findAll();
        return noticias;
    }

    private void validarNoticia(String titulo, String cuerpo, String id) throws MiException {
        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }

        if (id.isEmpty() || id == null) {
            throw new MiException("El id no puede ser nulo o estar vacio");
        }
        if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("El cuerpo no puede ser nulo o estar vacio");
        }

    }

    public Noticia getOne(String id) {
        return noticiaRepositorio.getOne(id);
    }

}
